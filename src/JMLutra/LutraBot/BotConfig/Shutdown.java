package JMLutra.LutraBot.BotConfig;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.Timestamp;
import java.util.Date;

import static JMLutra.LutraBot.LutraBot.*;

public class Shutdown extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();
        MessageChannel cnl = event.getChannel();

        if (args[0].equalsIgnoreCase(LutraBot.prefix + "shutdown")){
            if (event.getMember().getUser().equals(jda.getUserById("469957180968271873"))) {
                msg.addReaction("a:yess:830897926242566185").queue();

                Date date = new Date();
                Timestamp timestampShutdown = new Timestamp(date.getTime());
                //Message to bot-status
                botStatus.sendMessage(timestampShutdown + " LutraBot is Shutting down.").queue();
                //Message to Console
                System.out.println(timestampShutdown + " LutraBot is Shutting down.");

                jda.shutdown();
            } else {
                Date date = new Date();
                Timestamp timestampAttemptedShutdown = new Timestamp(date.getTime());

                msg.reply("Nope, fuck you :3").queue();
                botStatus.sendMessage(timestampAttemptedShutdown + " " + event.getMember().getUser().getAsTag() + " (" + event.getMember().getUser().getAsMention() + ")" + " tried to Shut me down without permissions! Get the 20cm Fisteisen!").queue();
                System.out.println(timestampAttemptedShutdown + " " + event.getMember().getUser().getAsTag() + " tried to Shut me down without permissions! Get the 20cm Fisteisen!" );
            }
        }
    }
}
