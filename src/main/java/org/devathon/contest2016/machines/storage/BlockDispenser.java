package org.devathon.contest2016.machines.storage;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.items.BlockDispenserItem;
import org.devathon.contest2016.machines.StorageMachine;

public class BlockDispenser extends StorageMachine {

    public BlockDispenser(DevathonPlugin instance, Location location) {
        super(instance, location, new BlockDispenserItem(), "Block Dispenser", 1, 3);
    }

    public void build() {}

    public void use(Player player) {
        player.openInventory(inventory);
    }

    public void destroy() {

    }
}
