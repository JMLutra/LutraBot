package JMLutra.LutraBot;


import JMLutra.LutraBot.BotConfig.FeatureToggle;
import JMLutra.LutraBot.BotConfig.PresenceConfig;
import JMLutra.LutraBot.BotConfig.Shutdown;

import JMLutra.LutraBot.Commands.Dev.TestCommands;
import JMLutra.LutraBot.Commands.General.Embeds;
import JMLutra.LutraBot.Commands.General.Ping;
import JMLutra.LutraBot.Commands.Moderation.ModClear;
import JMLutra.LutraBot.Events.BotEvents.LutraBotReadyEvent;
import JMLutra.LutraBot.Events.BotEvents.LutraBotShutDownEvent;
import JMLutra.LutraBot.Events.GuildEvents.GuildMemberJoin;
import JMLutra.LutraBot.Events.GuildEvents.GuildMemberLeave;
import JMLutra.LutraBot.Events.MessageEvents.MessageReactionAdd;
import JMLutra.LutraBot.Events.MessageEvents.MessageReceived;
import JMLutra.LutraBot.Events.MessageEvents.IfYouPingMeYourWaifuDies;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class LutraBot {
    public static String prefix = "lutra!";
    public static JDA jda;
    public static SelfUser LutraBotSelfUser;
    public static User BotOwner;

    //LutraBot-Backend
    public static Guild LutraBotBackend;
    public static TextChannel botTest;
    public static TextChannel botStatus;

    public static void main(String[] args) throws LoginException, InterruptedException {
/*
        JDABuilder builder = JDABuilder.createDefault(Token.LutraToken);
        //Gateway Intents
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES);
        builder.enableIntents(GatewayIntent.GUILD_EMOJIS);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS);

        //Member Cache
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.NONE);

        //Event Listener
        builder.addEventListeners(new LutraBotReadyEvent());
        builder.addEventListeners(new Embeds());
        builder.addEventListeners(new ModClear());
        builder.addEventListeners(new GuildMemberJoin());
        builder.addEventListeners(new GuildMemberLeave());
        builder.addEventListeners(new FeatureToggle());
        builder.addEventListeners(new TestCommands());
        builder.addEventListeners(new MessageReceived());
        builder.addEventListeners(new Shutdown());
        builder.addEventListeners(new LutraBotShutDownEvent());
        builder.addEventListeners(new MessageReactionAdd());
        builder.addEventListeners(new Ping());
        builder.addEventListeners(new IfYouPingMeYourWaifuDies());
        builder.addEventListeners(new PresenceConfig());

        //JDA
        //jda = builder.build().awaitReady();
        jda = JDABuilder.createDefault(Token.LutraToken).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("cute otters"));


        jda.awaitReady();*/

        jda = JDABuilder.createDefault(Token.LutraToken).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("cute otters"));

        //JDABuilder
        JDABuilder builder = JDABuilder.createDefault(Token.LutraToken);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES);
        builder.enableIntents(GatewayIntent.GUILD_EMOJIS);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.NONE);
        builder.addEventListeners(new GuildMemberLeave());
        builder.addEventListeners(new GuildMemberJoin());
        builder.addEventListeners(new MessageReactionAdd());
        builder.addEventListeners(new MessageReceived());
        builder.build();

        //EventListeners
        jda.addEventListener(new LutraBotReadyEvent());
        jda.addEventListener(new Embeds());
        jda.addEventListener(new ModClear());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
        jda.addEventListener(new FeatureToggle());
        jda.addEventListener(new TestCommands());
        jda.addEventListener(new MessageReceived());
        jda.addEventListener(new Shutdown());
        jda.addEventListener(new LutraBotShutDownEvent());
        jda.addEventListener(new MessageReactionAdd());
        jda.addEventListener(new Ping());
        //jda.addEventListener(new IfYouPingMeYourWaifuDies());
        jda.addEventListener(new PresenceConfig());

        jda.awaitReady();
    }

}
