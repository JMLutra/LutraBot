package JMLutra.LutraBot.BotConfig;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static JMLutra.LutraBot.LutraBot.jda;

public class PresenceConfig extends ListenerAdapter {
//TODO
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();
        MessageChannel cnl = event.getChannel();

        if(args[0].equalsIgnoreCase(LutraBot.prefix + "presence")){
            msg.delete().queue();
            if (args.length < 2){
                //TODO Error Embed

            }
            if (args[1].equalsIgnoreCase("activity")){
                //TODO Embed
                jda.getPresence().setActivity(Activity.playing(args[2]));
            }
        }
    }
}
