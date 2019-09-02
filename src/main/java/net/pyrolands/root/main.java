package net.pyrolands.root;

import org.bukkit.plugin.java.JavaPlugin;

import net.pyrolands.root.commands.gmCommand;

public class main extends JavaPlugin {
	public void onEnable() {
		new gmCommand(this);
	}
}
