package JMLutra.LutraBot.Events.MessageEvents;

//TODO Fixxen
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static JMLutra.LutraBot.LutraBot.LutraBotSelfUser;
import static JMLutra.LutraBot.BotConfig.FeatureToggle.reactionDeleteToggle;

public class MessageReactionAdd extends ListenerAdapter {
    //TODO
    @Override
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {

        if (reactionDeleteToggle) {
            if (event.getReactionEmote().equals("a:noo:830897904881369098") &&
                    !event.getMember().getUser().equals(LutraBotSelfUser)) {
                if(event.getMember().getUser().equals(event.getChannel().retrieveMessageById(event.getMessageId()).complete().getAuthor())){
                    event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
                }else {
                    event.getReaction().removeReaction().queue();
                }

            }
        }
    }
}
