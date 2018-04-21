package listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import rotcore.RoTCore;

public class CommandPreventer implements Listener {

private String pluginsMessage;
	
	public CommandPreventer() {
		pluginsMessage = ChatColor.translateAlternateColorCodes('&', "Plugins (1): &a"+RoTCore.getInstance().getDescription().getName());
	}
	
	@EventHandler
	public void onPluginCmd(PlayerCommandPreprocessEvent e) {
		String message = e.getMessage();
		if (message.equalsIgnoreCase("/pl") || message.equalsIgnoreCase("/plugins")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(pluginsMessage);
			return;
		}
	}
}
