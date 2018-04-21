package listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import rotcore.RoTCore;

public class CommandPreventer implements Listener {

private String pluginsMessage;
	
	private CommandPreventer() {
		pluginsMessage = ChatColor.translateAlternateColorCodes('&', "Plugins (1): &a"+RoTCore.getInstance().getDescription().getName());
	}
	
	@EventHandler
	public void onPluginsCommand(PlayerCommandPreprocessEvent e) {
		String message = e.getMessage();
		if (message.contains("/pl")
				|| message.contains("/plugins")
				|| message.contains("/bukkit:pl")
				|| message.contains("/bukkit:plugins")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(pluginsMessage);
			return;
		}
	}
}
