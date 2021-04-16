package JMLutra.LutraBot.Events.MessageEvents;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

import static JMLutra.LutraBot.LutraBot.jda;

public class IfYouPingMeYourWaifuDies extends ListenerAdapter {
//TODO
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getAuthor().equals(LutraBot.LutraBotSelfUser)) return;
        Message msg = event.getMessage();

        List<User> mentions = msg.getMentionedUsers();
        User me = jda.getUserById("469957180968271873");
        boolean isMe = mentions.contains(me);

        if (isMe){
            System.out.println("Test");
        }
    }
}
