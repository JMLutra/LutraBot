package JMLutra.LutraBot.Events.GuildEvents;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static JMLutra.LutraBot.BotConfig.FeatureToggle.joinToggle;
import static JMLutra.LutraBot.BotConfig.FeatureToggle.joinRoleToggle;

import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "[member] lass dich umarmen.",
            "Never gonna give [member] up. Never let [member] down!",
            "Herzlich Wilkommen [member]!",
            "Servus [member]",
            "Naaaaaaa [member]?",
            "Rawr [member]!",
            "Renn [member]! Renn so schnell du kannst!",
    };



    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){

        if (joinToggle) {
            Random rand = new Random();
            int number = rand.nextInt(messages.length);

            EmbedBuilder join = new EmbedBuilder();
            join.setColor(0x66d8ff);
            join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

            event.getGuild().getSystemChannel().sendMessage(join.build()).queue();
            join.clear();

        }

        //Add Role
        if (joinRoleToggle) {
            event.getGuild().addRoleToMember(event.getMember(), (Role) event.getGuild().getRolesByName("Member", true).get(0)).complete();
        }
        //System.out.println(event.getMember().getUser().getAsTag() + " ist dem Server " + event.getGuild().getName() + " beigetreten.");
    }
}
