package gemesil.consoleonlyop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConsoleOnlyOP extends JavaPlugin implements CommandExecutor, Listener {

    FileConfiguration config = getConfig();
    String prefix, NoPermissionsMessage, NoBypassMessage;

    @Override
    public void onEnable() {

        // Save config settings as default
        config.options().copyDefaults(true);
        saveConfig();

        // Get values from config
        prefix = ChatColor.translateAlternateColorCodes('&',config.getString("prefix"));
        NoPermissionsMessage = ChatColor.translateAlternateColorCodes('&',config.getString("NoPermissionsMessage"));
        NoBypassMessage = ChatColor.translateAlternateColorCodes('&',config.getString("NoBypassMessage"));

        // Register command
        getCommand("op").setExecutor(this);

        // Register events
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // If a player name was entered
        if (args.length > 0) {

            // Check if sender has permission for command and is a console
            if (sender.hasPermission("op.use_command") && !(sender instanceof Player)) {

                // Execute op command
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "minecraft:op " + args[0]);
                return true;
            }

            // If the sender is a player or without permissions
            else {
                // Cast to player
                Player p = (Player) sender;

                // Send no permissions error to the player that ran the command
                p.sendMessage(prefix + NoPermissionsMessage.replace("{player_name}", args[0]));
                return true;
            }
        }

        // If a player name wasn't entered
        return false;
    }

    /*
    Cancels any command that tries to bypass the default usage.
    For example -> minecraft:op Gemesil (This will be blocked by the eventHandler!)
    For example -> vortexcustomitems:vitem get (This will be blocked by the eventHandler!)
    */
    @EventHandler
    public void onPlayerCommand (PlayerCommandPreprocessEvent e) {

        if (e.getMessage().contains(":")) {
            e.setCancelled(true);

            String originalCommand = e.getMessage().replace(e.getMessage().substring(0, e.getMessage().indexOf(':') + 1), "");
            e.getPlayer().sendMessage(prefix + NoBypassMessage.replace("{original_command}", "/" + originalCommand));
        }
    }
}
