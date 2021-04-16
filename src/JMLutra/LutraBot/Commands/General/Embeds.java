package JMLutra.LutraBot.Commands.General;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Embeds extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        Message msg = event.getMessage();

        if (args[0].equalsIgnoreCase(LutraBot.prefix + "help")){
            msg.delete().queue();

            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("LutraBot Commands");
            help.setDescription("Die Commands für den LutraBot");
            help.addField("Prefix", "Das Prefix ist: " + LutraBot.prefix, false);
            help.addField("help", "Ruft diese Nachricht auf", false);
            help.addField("info", "Zeigt Infos über den LutraBot", false);
            help.addField("test", "eine ganze Reihe von Test Commands", false);
            help.addField("toggle", "(de-)aktivieren einzelner Funktionen", false);

            help.setColor(0xa016e0);
            help.setFooter("aufgerufen von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());

            event.getChannel().sendMessage(help.build()).queue();
            help.clear();
        }

        if (args[0].equalsIgnoreCase( LutraBot.prefix + "info")){
            msg.delete().queue();

            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("LutraBot Infos");
            info.setDescription("Informationen über den LutraBot");
            info.addField("Dev", "J_M_Lutra", false);
            info.addField("Features","Alle Features können mit `lutra!toggle` (de-)aktiviert werden", false);
            info.addField("", "Clear-, help- und infocommand", false);
            info.addField("","Joinnachricht und Rollenvergabe", false);
            info.addField("","Leavenachricht",false);
            info.setColor(0xa016e0);
            info.setFooter("aufgerufen von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());

            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }

    }
}
