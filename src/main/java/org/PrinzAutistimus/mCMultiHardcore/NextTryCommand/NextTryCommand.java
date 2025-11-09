package org.PrinzAutistimus.mCMultiHardcore.NextTryCommand;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.PrinzAutistimus.mCMultiHardcore.GameState.GameState;
import org.PrinzAutistimus.mCMultiHardcore.MCMultiHardcore;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NextTryCommand implements BasicCommand {
    private final MCMultiHardcore plugin;

    public NextTryCommand(MCMultiHardcore _plugin) {
        this.plugin = _plugin;
    }

    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] strings) {
        if(plugin.getGameState() == GameState.RUNNING) {
          commandSourceStack.getSender().sendMessage("The Game is still running and cant be skipped!");
          return;
        }

        Bukkit.broadcast(MiniMessage.miniMessage().deserialize("This is a test"));
    }

    @Override
    public boolean canUse(CommandSender sender) {
        return (sender instanceof Player) && (sender.isOp());
    }
}
