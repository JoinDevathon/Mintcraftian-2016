package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.MachineItem;

public abstract class TransportationMachine extends Machine {

    protected float speed;
    protected int maxCapacity;

    public TransportationMachine(DevathonPlugin instance, Location location, MachineItem item, String name, int id, float speed, int maxCapacity) {
        super(instance, location, item, name, id);

        this.speed = speed;
        this.maxCapacity = maxCapacity;
    }

    public abstract void addItem(ItemStack item);

}
