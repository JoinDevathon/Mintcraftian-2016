package org.devathon.contest2016.machines;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.MachineItem;

public abstract class StorageMachine extends Machine {

    protected Inventory inventory;

    public StorageMachine(DevathonPlugin instance, Location location, MachineItem item, String name, int id, int rows) {
        super(instance, location, item, name, id);

        inventory = Bukkit.createInventory(null, rows * 9, name);
    }

}
