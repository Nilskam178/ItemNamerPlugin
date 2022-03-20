package itemnamer.itemnamer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ItemCommand implements CommandExecutor {

    public String color(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String name;
        Player player = (Player) sender;

        if(args.length > 0) {
            if(args[0] != null) {
                name = args[0];

                ItemStack itemInHand = player.getInventory().getItemInMainHand();

                if(!itemInHand.equals(new ItemStack(Material.AIR))) {
                    ItemMeta meta = itemInHand.getItemMeta();
                    meta.setDisplayName(color(name));
                    itemInHand.setItemMeta(meta);
                }
            }
            else {
                player.sendMessage("Set a name");
            }
        }

        return false;
    }
}
