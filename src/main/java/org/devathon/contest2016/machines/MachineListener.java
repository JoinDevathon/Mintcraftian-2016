package org.devathon.contest2016.machines;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.machines.storage.BlockDispenser;
import org.devathon.contest2016.machines.transportation.ConveyorBeltMachine;

public class MachineListener implements Listener {

    private DevathonPlugin instance;

    public MachineListener(DevathonPlugin instance) {
        this.instance = instance;

        Bukkit.getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        instance.getMachines().stream().filter(machine -> machine.getLocation().getBlockX() == block.getLocation().getBlockX()
                && machine.getLocation().getBlockY() == block.getLocation().getBlockY()
                && machine.getLocation().getBlockZ() == block.getLocation().getBlockZ()
        ).forEach(machine -> {
            event.setCancelled(true);
            machine.use(player);
        });
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        String name = event.getItemInHand().getItemMeta().getDisplayName();
        if(name == null)
            return;
        switch (ChatColor.stripColor(name.toLowerCase())) {
            case "conveyor belt":
                instance.getMachines().add(new ConveyorBeltMachine(instance, event.getBlockPlaced().getLocation()));
                break;
            case "block dispenser":
                instance.getMachines().add(new BlockDispenser(instance, event.getBlockPlaced().getLocation()));
                break;
        }
    }

}
