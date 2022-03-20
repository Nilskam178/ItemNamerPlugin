package itemnamer.itemnamer;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("rename").setExecutor(new ItemCommand());
    }

    @Override
    public void onDisable() {
    }
}
