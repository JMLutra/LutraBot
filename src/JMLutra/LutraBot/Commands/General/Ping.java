
package JMLutra.LutraBot.Commands.General;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;

import java.util.function.Consumer;

public class Ping extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;

        if (args[0].equalsIgnoreCase(LutraBot.prefix + "ping")) {

            //copied from https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/requests/RestAction.html

            MessageChannel channel = event.getChannel();
            final long time = System.currentTimeMillis();
            RestAction<Message> action = channel.sendMessage("Berechne Ping...");
            Consumer<Message> callback = (message) -> {
                 Message m = message; // ^This is a lambda parameter!^
                final long ping = System.currentTimeMillis() - time;
                m.editMessage("Ping: " + ping + "ms").queue();
                System.out.println("LutraBot Ping: " + ping + "ms");
            };
            action.queue(callback);
        }
    }
}

