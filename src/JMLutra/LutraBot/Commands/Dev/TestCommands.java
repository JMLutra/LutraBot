package JMLutra.LutraBot.Commands.Dev;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

import static JMLutra.LutraBot.LutraBot.*;

public class TestCommands extends ListenerAdapter {
    String[] messagesj = {      //Messages for Join Test
            "[member] lass dich umarmen.",
            "Never gonna give [member] up. Never let [member] down!",
            "Herzlich Wilkommen [member]!",
            "Servus [member]!",
            "Naaaaaaa [member]?",
            "Rawwwr [member]",
            "Renn [member]! Renn so schnell du kannst!",
    };

    String[] messagesl = {      //Message for Leave Test
            "[member] wollte sich nicht mehr knuddeln lassen.",
            "Always gonna give [member] up. Always let [member] down!",
            "Servus [member]",
            "[member] konnte sich rechtzeitig retten.",
    };

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();

        //+ Rolle auf Backend
        if (args[0].equalsIgnoreCase(LutraBot.prefix + "+")){
            msg.delete().queue();

            if (event.getGuild().getId().equals("828235372823576586")){
                event.getGuild().addRoleToMember(event.getMember(), (Role) event.getGuild().getRolesByName("+", true).get(0)).complete();

            }else{
                event.getChannel().sendMessage("Dieser Command kann hier nicht verwedet werden!").queue();
            }
        }

        if (args[0].equalsIgnoreCase(LutraBot.prefix + "test")){
            msg.delete().queue();
            //generell Testnachricht
           if(args.length < 2) {

               botStatus.sendMessage("Testnachricht ausgelöst durch: " + event.getAuthor().getAsTag()).queue();

               System.out.println("Testnachricht ausgelöst durch: " + event.getAuthor().getAsTag() + " auf " + event.getGuild().getName());
           }else{
               //Join Test
               if(args[1].equalsIgnoreCase("join")){
                   event.getGuild().getSystemChannel().sendMessage("onGuildMemberJoin Test, ausgelöst von: " + event.getAuthor().getAsTag()).queue();

                   Random rand = new Random();
                   int number = rand.nextInt(messagesj.length);

                   EmbedBuilder join = new EmbedBuilder();
                   join.setColor(0x66d8ff);
                   join.setDescription(messagesj[number].replace("[member]", event.getMember().getAsMention()));

                   event.getGuild().getSystemChannel().sendMessage(join.build()).queue();
                   join.clear();

                   System.out.println("onGuildMemberJoin Test, ausgelöst von: " + event.getAuthor().getAsTag() + " auf " + event.getGuild().getName());
               }
               //Leave Test
               if(args[1].equalsIgnoreCase("leave")){
                   event.getGuild().getSystemChannel().sendMessage("onGuildMemberLeave Test, ausgelöst von: " + event.getAuthor().getAsTag()).queue();

                   Random rand = new Random();
                   int number = rand.nextInt(messagesl.length);

                   EmbedBuilder leave = new EmbedBuilder();
                   leave.setColor(0xf48342);
                   leave.setDescription(messagesl[number].replace("[member]", event.getMember().getAsMention()));

                   event.getGuild().getSystemChannel().sendMessage(leave.build()).queue();
                   leave.clear();

                   System.out.println("onGuildMemberLeave Test, ausgelöst von: " + event.getAuthor().getAsTag() + " auf " + event.getGuild().getName());
               }
               //Test ob die Jar funktioniert
               if (args[1].equalsIgnoreCase("jar")){
                   System.out.println("Jar Test");
                   event.getChannel().sendMessage("Jar Test").queue();
               }
           }
        }
    }
}
