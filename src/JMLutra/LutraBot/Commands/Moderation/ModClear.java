package JMLutra.LutraBot.Commands.Moderation;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import static JMLutra.LutraBot.BotConfig.FeatureToggle.clearToggle;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ModClear extends ListenerAdapter{
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();

        if (args[0].equalsIgnoreCase(LutraBot.prefix + "clear")){
            msg.delete().queue();
            if (clearToggle) {
                if (args.length < 2) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setTitle("Der Command konnte nicht ausgeführt werden.");
                    error.setDescription("Bitte gib einen Zahlenwert zwischen 1 und 100 an.");
                    error.setFooter("ausgelöst durch " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                    error.setColor(0xff1919);

                    event.getChannel().sendMessage(error.build()).complete().delete().queueAfter(10, TimeUnit.SECONDS);
                    error.clear();

                } else {
                    try {
                        MessageHistory history = new MessageHistory(event.getTextChannel());
                        List<Message> messages = history.retrievePast(Integer.parseInt(args[1]) + 1).complete();
                        event.getTextChannel().deleteMessages(messages).queue();
                        event.getTextChannel().sendMessage(args[1] + " Nachrichten wurden gelöscht").complete().delete().queueAfter(5, TimeUnit.SECONDS);

                    } catch (IllegalArgumentException e) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setTitle("Nachrichten konnten nicht gelöscht werden.");
                        error.setDescription("Die angegebene Anzahl an Nachrichte konnte nicht gelöscht werden, da die Anzahl entweder zu groß war oder die Nachrichten zu alt.");
                        error.setFooter("ausgelöst durch " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                        error.setColor(0xff1919);

                        event.getChannel().sendMessage(error.build()).complete().delete().queueAfter(10, TimeUnit.SECONDS);
                        error.clear();
                    }
                }
            } else {
                EmbedBuilder clearNotActive = new EmbedBuilder();
                clearNotActive.setTitle("Die Clear Funktion ist nicht aktiviert!");
                clearNotActive.setDescription("<a:noo:830897904881369098>");
                clearNotActive.setColor(0xff0000);

                event.getChannel().sendMessage(clearNotActive.build()).queue();
                clearNotActive.clear();
            }
        }
    }
}
