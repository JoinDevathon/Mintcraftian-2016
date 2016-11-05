package org.devathon.contest2016.machines;

import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.DevathonPlugin;

public abstract class StorageMachine extends Machine {

    protected ItemStack[] items;

    public StorageMachine(DevathonPlugin instance, ItemStack item, String name, int id, int rows) {
        super(instance, item, name, id);

        items = new ItemStack[rows * 9];
    }

}
