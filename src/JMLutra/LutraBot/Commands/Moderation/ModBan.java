package JMLutra.LutraBot.Commands.Moderation;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ModBan extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();

        if(args[0].equalsIgnoreCase(LutraBot.prefix + "ban")){

        }
    }
}
