package org.devathon.contest2016.machines;

import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.DevathonPlugin;

public abstract class TransportationMachine extends Machine {

    protected float speed;
    protected int maxCapacity;

    public TransportationMachine(DevathonPlugin instance, ItemStack item, String name, int id, float speed, int maxCapacity) {
        super(instance, item, name, id);

        this.speed = speed;
        this.maxCapacity = maxCapacity;
    }

    public abstract boolean move();
}
