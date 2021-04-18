package JMLutra.LutraBot.BotConfig;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static JMLutra.LutraBot.LutraBot.BotOwner;

public class FeatureToggle extends ListenerAdapter {
    public static boolean clearToggle = true;
    public static boolean joinToggle = true;
    public static boolean joinRoleToggle = true;
    public static boolean leaveToggle = true;
    public static boolean reactionToggle = false;
    public static boolean reactionDeleteToggle = false;

    private String clearField;
    private String joinField;
    private String joinRoleField;
    private String leaveField;
    private String reactionField;
    private String reactionDeleteField;

    //TODO sauber machen
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getAuthor().isBot()) return;
        if (!event.getMember().getUser().equals(BotOwner)) return;
        Message msg = event.getMessage();
        MessageChannel cnl = event.getChannel();

        //Clear
        if (clearToggle){
            clearField = "<a:yess:830897926242566185> Clear-Command aktiv";
        }else {
            clearField = "<a:noo:830897904881369098> Clear-Command nicht aktiv";
        }
        //Join
        if (joinToggle){
            joinField = "<a:yess:830897926242566185> Join-Nachricht aktiv";
        }else {
            joinField = "<a:noo:830897904881369098> Join-Nachricht nicht aktiv";
        }
        //Join-Rolle
        if (joinRoleToggle){
            joinRoleField = "<a:yess:830897926242566185> Join-Rolle aktiv";
        }else {
            joinRoleField = "<a:noo:830897904881369098> Join-Rolle nicht aktiv";
        }
        //Leave
        if (leaveToggle){
            leaveField = "<a:yess:830897926242566185> Leave-Nachricht aktiv";
        }else {
            leaveField = "<a:noo:830897904881369098> Leave-Nachricht nicht aktiv";
        }
        //Reaction
        if (reactionToggle){
            reactionField = "<a:yess:830897926242566185> Reactions aktiv";
        }else {
            reactionField = "<a:noo:830897904881369098> Reactions nicht aktiv";
        }
        //Reaction Delete
        if (reactionDeleteToggle){
            reactionDeleteField = "<a:yess:830897926242566185> Löschen bei Reactions aktiv";
        } else {
            reactionDeleteField = "<a:noo:830897904881369098> Löschen bei Reactions nicht aktiv";
        }

        if (args[0].equalsIgnoreCase(LutraBot.prefix + "toggle")){
            msg.delete().queue();
           if (args.length < 2) {
               EmbedBuilder toggle = new EmbedBuilder();
               toggle.setTitle("LutraBot Features");
               toggle.setDescription("Einzelne Features können mit `lutra!toggle [feature]` aktiviert/deaktiviert werden.");
               toggle.addField("Clear-Command `[clear]`", clearField, false);
               toggle.addField("Join-Nachricht `[join]`", joinField, false);
               toggle.addField("Join-Rolle `[joinRole]`", joinRoleField, false);
               toggle.addField("Leave-Nachricht `[leave]`", leaveField, false);
               toggle.addField("Reactions `[reactions]`", reactionField, false);
               toggle.addField("Löschen bei Reactions `[reactionsDelete]`", reactionDeleteField, false);
               toggle.setFooter("Aufgerufen von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
               toggle.setColor(0xa016e0);

               cnl.sendMessage(toggle.build()).queue();

               toggle.clear();
           } else {
               if (args[1].equalsIgnoreCase("clear")) {
                   if (clearToggle) {
                       clearToggle = false;

                       EmbedBuilder clearEmbedD = new EmbedBuilder();
                       clearEmbedD.setTitle("Clear-Command deaktiviert");
                       clearEmbedD.addField("Clear-Command Status:", "<a:noo:830897904881369098>", false);
                       clearEmbedD.setFooter("Clear-Command deaktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       clearEmbedD.setColor(0xff0000);

                       cnl.sendMessage(clearEmbedD.build()).queue();

                       clearEmbedD.clear();
                   } else {
                       clearToggle = true;

                       EmbedBuilder clearEmbedA = new EmbedBuilder();
                       clearEmbedA.setTitle("Clear-Command aktiviert");
                       clearEmbedA.addField("Clear-Command Status:", "<a:yess:830897926242566185>", false);
                       clearEmbedA.setFooter("Clear-Command aktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       clearEmbedA.setColor(0x00ff00);

                       cnl.sendMessage(clearEmbedA.build()).queue();

                       clearEmbedA.clear();
                   }
               }
               if (args[1].equalsIgnoreCase("join")) {
                   if (joinToggle) {
                       joinToggle = false;

                       EmbedBuilder joinEmbedD = new EmbedBuilder();
                       joinEmbedD.setTitle("Join-Nachrichten deaktiviert");
                       joinEmbedD.addField("Join-Nachrichten Status:", "<a:noo:830897904881369098>", false);
                       joinEmbedD.setFooter("Join-Nachrichten deaktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       joinEmbedD.setColor(0xff0000);

                       cnl.sendMessage(joinEmbedD.build()).queue();

                       joinEmbedD.clear();
                   } else {
                       joinToggle = true;

                       EmbedBuilder joinEmbedA = new EmbedBuilder();
                       joinEmbedA.setTitle("Join-Nachrichten aktiviert");
                       joinEmbedA.addField("Join-Nachrichten Status:", "<a:yess:830897926242566185>", false);
                       joinEmbedA.setFooter("Join-Nachrichten aktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       joinEmbedA.setColor(0x00ff00);

                       cnl.sendMessage(joinEmbedA.build()).queue();

                       joinEmbedA.clear();
                   }
               }
               if (args[1].equalsIgnoreCase("joinRole")) {
                   if (joinRoleToggle) {
                       joinRoleToggle = false;

                       EmbedBuilder joinRoleEmbedD = new EmbedBuilder();
                       joinRoleEmbedD.setTitle("Join-Rolle deaktiviert");
                       joinRoleEmbedD.addField("Join-Rolle Status:", "<a:noo:830897904881369098>", false);
                       joinRoleEmbedD.setFooter("Join-Rolle deaktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       joinRoleEmbedD.setColor(0xff0000);

                       cnl.sendMessage(joinRoleEmbedD.build()).queue();

                       joinRoleEmbedD.clear();
                   } else {
                       joinRoleToggle = true;

                       EmbedBuilder joinRoleEmbedA = new EmbedBuilder();
                       joinRoleEmbedA.setTitle("Join-Rolle aktiviert");
                       joinRoleEmbedA.addField("Join-Rolle Status:", "<a:yess:830897926242566185>", false);
                       joinRoleEmbedA.setFooter("Join-Rolle aktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       joinRoleEmbedA.setColor(0x00ff00);

                       cnl.sendMessage(joinRoleEmbedA.build()).queue();

                       joinRoleEmbedA.clear();
                   }
               }
               if (args[1].equalsIgnoreCase("leave")) {
                   if (leaveToggle) {
                       leaveToggle = false;

                       EmbedBuilder leaveEmbedD = new EmbedBuilder();
                       leaveEmbedD.setTitle("Leave-Nachricht deaktiviert");
                       leaveEmbedD.addField("Leave-Nachricht Status:", "<a:noo:830897904881369098>", false);
                       leaveEmbedD.setFooter("Leave-Nachricht deaktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       leaveEmbedD.setColor(0xff0000);

                       cnl.sendMessage(leaveEmbedD.build()).queue();

                       leaveEmbedD.clear();
                   } else {
                       leaveToggle = true;

                       EmbedBuilder leaveEmbedA = new EmbedBuilder();
                       leaveEmbedA.setTitle("Leave-Nachricht aktiviert");
                       leaveEmbedA.addField("Leave-Nachricht Status:", "<a:yess:830897926242566185>", false);
                       leaveEmbedA.setFooter("Leave-Nachricht aktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       leaveEmbedA.setColor(0x00ff00);

                       cnl.sendMessage(leaveEmbedA.build()).queue();

                       leaveEmbedA.clear();
                   }
               }
               if (args[1].equalsIgnoreCase("reactions")) {
                   if (reactionToggle) {
                       reactionToggle = false;

                       EmbedBuilder reactionEmbedD = new EmbedBuilder();
                       reactionEmbedD.setTitle("Reactions deaktiviert");
                       reactionEmbedD.addField("Reactions Status:", "<a:noo:830897904881369098>", false);
                       reactionEmbedD.setFooter("Reactions deaktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       reactionEmbedD.setColor(0xff0000);

                       cnl.sendMessage(reactionEmbedD.build()).queue();

                       reactionEmbedD.clear();
                   } else {
                       reactionToggle = true;

                       EmbedBuilder reactionEmbedA = new EmbedBuilder();
                       reactionEmbedA.setTitle("Reactions aktiviert");
                       reactionEmbedA.addField("Reactions Status:", "<a:yess:830897926242566185>", false);
                       reactionEmbedA.setFooter("Reactions aktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       reactionEmbedA.setColor(0x00ff00);

                       cnl.sendMessage(reactionEmbedA.build()).queue();

                       reactionEmbedA.clear();
                   }
               }
               if (args[1].equalsIgnoreCase("reactionsDelete")) {
                   if (reactionDeleteToggle) {
                       reactionDeleteToggle = false;

                       EmbedBuilder reactionDeleteEmbedD = new EmbedBuilder();
                       reactionDeleteEmbedD.setTitle("Löschen bei Reactions deaktiviert");
                       reactionDeleteEmbedD.addField("Löschen bei Reactions Status:", "<a:noo:830897904881369098>", false);
                       reactionDeleteEmbedD.setFooter("Löschen bei Reactions deaktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       reactionDeleteEmbedD.setColor(0xff0000);

                       cnl.sendMessage(reactionDeleteEmbedD.build()).queue();

                       reactionDeleteEmbedD.clear();
                   } else {
                       reactionDeleteToggle = true;

                       EmbedBuilder reactionDeleteEmbedA = new EmbedBuilder();
                       reactionDeleteEmbedA.setTitle("Löschen bei Reactions aktiviert");
                       reactionDeleteEmbedA.addField("Löschen bei Reactions Status:", "<a:yess:830897926242566185>", false);
                       reactionDeleteEmbedA.setFooter("Löschen bei Reactions aktiviert von: " + event.getMember().getUser().getAsTag(), event.getMember().getUser().getAvatarUrl());
                       reactionDeleteEmbedA.setColor(0x00ff00);

                       cnl  .sendMessage(reactionDeleteEmbedA.build()).queue();

                       reactionDeleteEmbedA.clear();
                   }
               }
           }
        }
    }
}
