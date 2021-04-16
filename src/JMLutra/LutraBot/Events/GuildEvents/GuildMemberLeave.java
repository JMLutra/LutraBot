package JMLutra.LutraBot.Events.GuildEvents;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static JMLutra.LutraBot.BotConfig.FeatureToggle.leaveToggle;

import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages = {
            "[member] wollte sich nicht mehr knuddeln lassen.",
            "Always gonna give [member] up. Always let [member] down!",
            "Servus [member]",
            "[member] konnte sich rechtzeitig retten.",
    };

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event){
        if (leaveToggle) {
            Random rand = new Random();
            int number = rand.nextInt(messages.length);

            EmbedBuilder leave = new EmbedBuilder();
            leave.setColor(0xf48342);
            leave.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

            event.getGuild().getSystemChannel().sendMessage(leave.build()).queue();
            leave.clear();

        }

        //System.out.println(event.getMember().getUser().getAsTag() + " hat den Server " + event.getGuild().getName() + " verlassen.");
    }
}