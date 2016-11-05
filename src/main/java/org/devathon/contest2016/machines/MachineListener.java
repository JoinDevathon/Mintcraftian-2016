package org.devathon.contest2016.machines;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
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

        instance.getMachines().stream().filter(machine -> block != null && instance.getMachine(block.getLocation()) != null).forEach(machine -> machine.use(player));
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        String name = event.getItemInHand().getItemMeta().getDisplayName();
        if(name == null)
            return;
        switch (ChatColor.stripColor(name.toLowerCase())) {
            case "conveyor belt":
                new ConveyorBeltMachine(instance, event.getBlock().getLocation());
                break;
            case "block dispenser":
                new BlockDispenser(instance, event.getBlock().getLocation());
                break;
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(instance.isMachine(event.getBlock().getLocation())) {
            instance.getMachines().remove(instance.getMachine(event.getBlock().getLocation()));
        }
    }

}
