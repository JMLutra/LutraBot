package JMLutra.LutraBot.Events.MessageEvents;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static JMLutra.LutraBot.LutraBot.LutraBotBackend;
import static JMLutra.LutraBot.BotConfig.FeatureToggle.reactionToggle;
//TODO
public class MessageReceived extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();
        if (reactionToggle){
            if (event.getGuild().equals(LutraBotBackend)) {
                msg.addReaction("a:noo:830897904881369098").queue();
            }
        }
    }
}
