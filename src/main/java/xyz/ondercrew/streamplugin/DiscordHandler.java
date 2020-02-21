package xyz.ondercrew.streamplugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.configuration.file.FileConfiguration;

public class DiscordHandler {
    private DiscordEvents events = new DiscordEvents();
    private FileConfiguration configFile = StreamPlugin.getPlugin(StreamPlugin.class).getConfig();

    public SuccessAndResult login () {
        try {
            JDA jda = new JDABuilder(configFile.getString("discord.token")).build();
            jda.addEventListener(events);
            return new SuccessAndResult(jda);
        } catch (Exception e) {
            return new SuccessAndResult();
        }
    }
}
