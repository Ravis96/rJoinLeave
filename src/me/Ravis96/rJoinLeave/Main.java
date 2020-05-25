package me.Ravis96.rJoinLeave;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
	    Bukkit.getServer().getPluginManager().registerEvents(this, (Plugin)this);
	    saveDefaultConfig();
	  }
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.hasPlayedBefore()) {
		if (p.hasPermission("rjl.admin")) {
			e.setJoinMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Adminjoin")).replace("%player%", e.getPlayer().getDisplayName()));
		} else if (p.hasPermission("rjl.vip")) {
			e.setJoinMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("VIPjoin")).replace("%player%", e.getPlayer().getDisplayName()));
		} else {
			e.setJoinMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Playerjoin")).replace("%player%", e.getPlayer().getDisplayName()));
		}
		} else {
			e.setJoinMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("PlayerFirstjoin")).replace("%player%", e.getPlayer().getDisplayName()));
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("rjl.admin")) {
			e.setQuitMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Adminleft")).replace("%player%", e.getPlayer().getDisplayName()));
		} else if (p.hasPermission("rjl.vip")) {
			e.setQuitMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("VIPleft")).replace("%player%", e.getPlayer().getDisplayName()));
		} else {
			e.setQuitMessage(null);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Playerleft")).replace("%player%", e.getPlayer().getDisplayName()));
		}
	}
}
