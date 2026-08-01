package me.reag.mace;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MaceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        ItemStack mace = new ItemStack(Material.DIAMOND_AXE);

        ItemMeta meta = mace.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "REAG Mace");
        meta.setLore(java.util.Arrays.asList(
                ChatColor.GRAY + "A powerful custom mace!",
                ChatColor.RED + "Created by REAG"
        ));

        mace.setItemMeta(meta);

        player.getInventory().addItem(mace);

        player.sendMessage(ChatColor.GREEN + "You received the REAG Mace!");

        return true;
    }
}
