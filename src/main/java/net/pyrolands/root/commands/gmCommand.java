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
			sender.sendMessage(ChatColor.BLUE + "Error> " + ChatColor.GRAY + "Only players can execute this command.");
			return true;
		} else {
			Player plr = (Player)sender;
			if (plr.getGameMode() == GameMode.ADVENTURE || plr.getGameMode() == GameMode.SPECTATOR) {
				sender.sendMessage(ChatColor.BLUE + "Error> " + ChatColor.GRAY + "You must be in either survival or creative to execute this command.");
				return true;
			} else {
				if (plr.getGameMode() == GameMode.CREATIVE) {
					plr.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(ChatColor.BLUE + "Moderation> " + ChatColor.GRAY + "Your game mode has been set to " + ChatColor.YELLOW + "survival" + ChatColor.GRAY + ".");
					return true;
				} else if (plr.getGameMode() == GameMode.SURVIVAL) {
					plr.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(ChatColor.BLUE + "Moderation> " + ChatColor.GRAY + "Your game mode has been set to " + ChatColor.YELLOW + "creative" + ChatColor.GRAY + ".");
					return true;
				}
				return true;
			}
		}
	}
}
