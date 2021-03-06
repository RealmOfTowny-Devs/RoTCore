/**
 * This class may not be used as API.
 * To get to the API please use RoTCoreAPI.getAPI()
 */

package rotcore;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import api.RoTCoreAPI;
import listeners.CommandPreventer;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class RoTCore extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    
    private static RoTCore instance = null;
    private ClassReflection classReflection;

	@Override
	public void onEnable() {
		// TODO Implement onEnable
		if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
        
        instance = this;
        
        classReflection = new ClassReflection();
        
        PluginManager pm = getServer().getPluginManager();
        
        pm.registerEvents(((CommandPreventer)classReflection.getNewInstanceOf(CommandPreventer.class)), instance);
        
        RoTCoreAPI.getAPI();//Call it ones for initialization only!
        
        log.info(String.format("[%s] Enabled Version %s", getDescription().getName(), getDescription().getVersion()));
	}
	
	@Override
	public void onDisable() {
		// TODO Implement onDisable
		log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        if (rsp == null) {
            return false;
        }
        chat = rsp.getProvider();
        return chat != null;
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        if (rsp == null) {
            return false;
        }
        perms = rsp.getProvider();
        return perms != null;
    }
    
    public static Economy getEconomy() {
        return econ;
    }
    
    public static Permission getPermissions() {
        return perms;
    }
    
    public static Chat getChat() {
        return chat;
    }
    
    public static RoTCore getInstance() {
    	return instance;
    }
}
