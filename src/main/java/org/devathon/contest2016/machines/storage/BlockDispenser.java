package org.devathon.contest2016.machines.storage;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Directional;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.items.BlockDispenserItem;
import org.devathon.contest2016.machines.Machine;
import org.devathon.contest2016.machines.StorageMachine;
import org.devathon.contest2016.machines.TransportationMachine;

public class BlockDispenser extends StorageMachine {

    private static final float DISPENSE_SPEED = 5.0f;

    public BlockDispenser(DevathonPlugin instance, Location location) {
        super(instance, location, new BlockDispenserItem(), "Block Dispenser", 1, 3);
    }

    public void use(Player player) {}

    public void update(long tick) {
        if(tick % DISPENSE_SPEED == 0) {
            Inventory inventory = ((Dispenser) location.getBlock().getState()).getInventory();
            for (int i = 0; i < inventory.getContents().length; i++) {
                ItemStack item = inventory.getContents()[i];
                if(item != null) {
                    BlockFace face = ((Directional) location.getBlock().getState().getData()).getFacing();
                    Block block = location.clone().subtract(0, 1, 0).getBlock().getRelative(face);
                    Machine machine = instance.getMachine(block.getLocation());
                    if(machine != null && machine instanceof TransportationMachine) {
                        ((TransportationMachine) machine).addItem(item);
                    }
                    if(item.getAmount() > 1)
                        item.setAmount(item.getAmount() - 1);
                    else
                        inventory.getContents()[i] = null;
                    break;
                }
            }
        }
    }


}
