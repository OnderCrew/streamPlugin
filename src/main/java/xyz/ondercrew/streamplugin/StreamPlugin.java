package xyz.ondercrew.streamplugin;

import net.dv8tion.jda.api.JDA;
import org.bukkit.plugin.java.JavaPlugin;

public final class StreamPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Onder Crew Stream Plugin v1");

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        DiscordSender discordSender = new DiscordSender();
        JDA discordClient = new DiscordHandler().login().jda;
        discordSender.registerClient(discordClient);

        this.getCommand("twitch").setExecutor(new CommandHandler());
        this.getCommand("nick").setExecutor(new CommandHandler());

        this.getServer().getPluginManager().registerEvents(new NicknameForcer(), this);
        this.getServer().getPluginManager().registerEvents(discordSender, this);
    }
}
