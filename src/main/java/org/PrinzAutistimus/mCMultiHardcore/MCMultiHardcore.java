package org.PrinzAutistimus.mCMultiHardcore;

import org.PrinzAutistimus.mCMultiHardcore.GameState.GameState;
import org.PrinzAutistimus.mCMultiHardcore.NextTryCommand.NextTryCommand;
import org.PrinzAutistimus.mCMultiHardcore.PlayerDeathListener.PlayerDeathListener;
import org.PrinzAutistimus.mCMultiHardcore.PlayerJoinListener.PlayerJoinListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.mvplugins.multiverse.core.MultiverseCoreApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

public final class MCMultiHardcore extends JavaPlugin {

    private GameState gameState = GameState.RUNNING;
    private MultiverseCoreApi coreApi;

    @Override
    public void onEnable() {
        coreApi = MultiverseCoreApi.get();

        loadConfig();
        initMultiWorldSetup();

        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        safeConfig();
    }

    private void loadConfig() {
        saveDefaultConfig();
        this.gameState = GameState.matchByString(getConfig().getString("state"));
    }

    private void safeConfig() {
        getConfig().set("state", gameState.toString());

        try {
            getConfig().save("plugins/MCMultiHardcore/config.yml");
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Couldn't save config File!");
        }
    }

    private void initMultiWorldSetup() {

    }

    public void setGameState(GameState newGameState) {
        this.gameState = newGameState;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    private void registerListeners() {
        ArrayList<Listener> listenersToRegister = new ArrayList<>();

        PlayerDeathListener pdl = new PlayerDeathListener(this);
        listenersToRegister.add(pdl);

        PlayerJoinListener pjl = new PlayerJoinListener(this);
        listenersToRegister.add(pjl);

        listenersToRegister.forEach(l -> getServer().getPluginManager().registerEvents(l, this));
    }

    private void registerCommands() {
        registerCommand("nexttry", new NextTryCommand(this));
    }
}
