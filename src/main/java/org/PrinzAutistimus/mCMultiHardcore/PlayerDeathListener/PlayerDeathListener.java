package org.PrinzAutistimus.mCMultiHardcore.PlayerDeathListener;

import org.PrinzAutistimus.mCMultiHardcore.GameState.GameState;
import org.PrinzAutistimus.mCMultiHardcore.MCMultiHardcore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

public class PlayerDeathListener implements Listener {

    private final MCMultiHardcore plugin;

    public PlayerDeathListener(MCMultiHardcore _plugin) {
        this.plugin = _plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        ArrayList<Player> currentPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        currentPlayers.forEach(p -> p.setGameMode(GameMode.SPECTATOR));
        plugin.setGameState(GameState.END);
    }

}
