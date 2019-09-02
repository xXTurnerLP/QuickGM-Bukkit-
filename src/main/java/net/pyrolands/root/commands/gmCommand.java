package net.pyrolands.root.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.pyrolands.root.main;

public class gmCommand implements CommandExecutor {
	public gmCommand(main plugin) {
		plugin.getCommand("gm").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.AQUA + "Only players can use this command!");
			return true;
		} else {
			Player plr = (Player)sender;
			if (plr.getGameMode() == GameMode.ADVENTURE || plr.getGameMode() == GameMode.SPECTATOR) {
				sender.sendMessage(ChatColor.GOLD + "You have to be in either survival or creative to use this command");
				return true;
			} else {
				if (plr.getGameMode() == GameMode.CREATIVE) {
					plr.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(ChatColor.GOLD + "Set game mode " + ChatColor.RED + "survival " + ChatColor.GOLD + "for " + ChatColor.DARK_RED + plr.getName());
					return true;
				} else if (plr.getGameMode() == GameMode.SURVIVAL) {
					plr.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(ChatColor.GOLD + "Set game mode " + ChatColor.RED + "creative " + ChatColor.GOLD + "for " + ChatColor.DARK_RED + plr.getName());
					return true;
				}
				return true;
			}
		}
	}
}
