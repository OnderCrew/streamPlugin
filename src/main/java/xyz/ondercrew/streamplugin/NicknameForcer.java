package xyz.ondercrew.streamplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NicknameForcer implements Listener {
    private FileConfiguration configFile = StreamPlugin.getPlugin(StreamPlugin.class).getConfig();

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (configFile.isString("nickname.force." + player.getName())) {
            player.setDisplayName(configFile.getString("nickname.force." + player.getName()));
        }
    }
}
