package org.PrinzAutistimus.mCMultiHardcore.PlayerJoinListener;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.PrinzAutistimus.mCMultiHardcore.GameState.GameState;
import org.PrinzAutistimus.mCMultiHardcore.MCMultiHardcore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    private MCMultiHardcore plugin;

    public PlayerJoinListener(MCMultiHardcore _plugin) {
        this.plugin = _plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(plugin.getGameState() == GameState.END){
            new BukkitRunnable() {
                @Override
                public void run() {
                    e.getPlayer().setGameMode(GameMode.SPECTATOR);
                }
            }.runTaskLater(plugin, 5L); // 1 Tick warten
        }
    }

}
