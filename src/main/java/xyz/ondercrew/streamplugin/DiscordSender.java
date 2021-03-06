package xyz.ondercrew.streamplugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class DiscordSender implements Listener {
    private JDA jda;
    private FileConfiguration configFile = StreamPlugin.getPlugin(StreamPlugin.class).getConfig();

    public void registerClient (JDA jda) { this.jda = jda; }

    @EventHandler
    public void onPlayerChat (AsyncPlayerChatEvent event) {
        TextChannel targetChannel = jda.getTextChannelById(configFile.getLong("discord.channelId"));
        String author = event.getPlayer().getDisplayName();
        String content = event.getMessage();
        targetChannel.sendMessage("<" + author + "> " + content).queue();
    }
}
