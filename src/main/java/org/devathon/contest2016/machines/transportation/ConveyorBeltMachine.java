package org.devathon.contest2016.machines.transportation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.items.ConveyorBeltItem;
import org.devathon.contest2016.machines.Machine;
import org.devathon.contest2016.machines.TransportationMachine;

public class ConveyorBeltMachine extends TransportationMachine {

    public ConveyorBeltMachine(DevathonPlugin instance, Location location) {
        super(instance, location, new ConveyorBeltItem(), "Conveyor Belt", 0, 3.5f, 2);
    }

    public void use(Player player) {}

    public void addItem(ItemStack item) {
        location.clone().add(0, 1, 0).getBlock().setType(item.getType());
        location.clone().add(0, 1, 0).getBlock().setData(item.getData().getData());
    }

    public void update(long tick) {
        if(tick % speed == 0) {
            for (BlockFace face : new BlockFace[] {BlockFace.NORTH, BlockFace.EAST, BlockFace.WEST, BlockFace.SOUTH}) {
                Block block = location.getBlock().getRelative(face);
                Machine machine = instance.getMachine(block.getLocation());
                if (machine == null)
                    return;
                if (machine instanceof ConveyorBeltMachine) {
                    Block carrying = machine.getLocation().clone().add(0, 1, 0).getBlock();
                    if(carrying.getType() == Material.AIR)
                        continue;
                    ((ConveyorBeltMachine) machine).addItem(new ItemStack(carrying.getType(), 1, (short) 0, carrying.getData()));
                    carrying.setType(Material.AIR);
                    break;
                }
            }
        }
    }

}
