package JMLutra.LutraBot.Events.BotEvents;

import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LutraBotShutDownEvent extends ListenerAdapter {
    @Override
    public void onShutdown(ShutdownEvent event){
        //Stops the Programm
        System.exit(0);
    }
}
