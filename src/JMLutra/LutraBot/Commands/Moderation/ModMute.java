package JMLutra.LutraBot.Commands.Moderation;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//TODO
public class ModMute extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();
        MessageChannel cnl = event.getChannel();

        if(args[0].equalsIgnoreCase(LutraBot.prefix + "mute")){
            msg.delete().queue();
            if (args.length > 1 && args.length < 3){

            } else if (args.length == 3){

            } else {

            }

        }
    }
}
