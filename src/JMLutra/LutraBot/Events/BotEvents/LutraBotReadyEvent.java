package JMLutra.LutraBot.Events.BotEvents;

import JMLutra.LutraBot.LutraBot;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.Timestamp;
import java.util.Date;

import static JMLutra.LutraBot.LutraBot.*;

public class LutraBotReadyEvent extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        //Start-Time
        Date date = new Date();
        Timestamp timestampStart = new Timestamp(date.getTime());
        //botStatus Channel
        botStatus =jda.getTextChannelById("828235516796993546");
        //Start Message Discord
        botStatus.sendMessage(timestampStart + " <@469957180968271873> LutraBot started successfully. Yay! ").queue();
        //Start Message Konsole
        System.out.println(timestampStart + " LutraBot started.");
        //SelfUser
        LutraBotSelfUser = jda.getSelfUser();
        //BotOwner
        BotOwner = jda.getUserById("469957180968271873");
        //BotTest Channel
        LutraBot.botTest = jda.getTextChannelById("828235372823576589");
        //LutraBotBackend Guild
        LutraBot.LutraBotBackend = jda.getGuildById("828235372823576586");
    }
}
