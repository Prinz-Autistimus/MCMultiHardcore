package org.PrinzAutistimus.mCMultiHardcore;

import io.papermc.paper.command.brigadier.BasicCommand;
import org.PrinzAutistimus.mCMultiHardcore.GameState.GameState;
import org.PrinzAutistimus.mCMultiHardcore.NextTryCommand.NextTryCommand;
import org.PrinzAutistimus.mCMultiHardcore.PlayerDeathListener.PlayerDeathListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class MCMultiHardcore extends JavaPlugin {

    private GameState gameState = GameState.RUNNING;

    @Override
    public void onEnable() {
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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

        listenersToRegister.forEach(l -> getServer().getPluginManager().registerEvents(l, this));
    }

    private void registerCommands() {
        registerCommand("nexttry", new NextTryCommand(this));
    }
}
