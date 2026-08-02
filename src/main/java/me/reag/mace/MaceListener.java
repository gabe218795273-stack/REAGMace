package me.reag.mace;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MaceListener implements Listener {

    @EventHandler
    public void onMaceHit(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() != Material.DIAMOND_AXE) {
            return;
        }

        ItemMeta meta = item.getItemMeta();

        if (meta == null || !meta.hasDisplayName()) {
            return;
        }

        if (!meta.getDisplayName().equals(ChatColor.AQUA + "REAG Mace")) {
            return;
        }

        Entity victim = event.getEntity();

        event.setDamage(event.getDamage() + 5);

        victim.getWorld().strikeLightningEffect(victim.getLocation());

        player.sendMessage(ChatColor.YELLOW + "⚡ REAG Mace hit!");
    }
}
