package org.devathon.contest2016.machines;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.DevathonPlugin;

public abstract class Machine {

    protected DevathonPlugin instance;
    protected ItemStack item;
    protected String name;
    protected int id;

    public Machine(DevathonPlugin instance, ItemStack item, String name, int id) {
        this.instance = instance;
        this.item = item;
        this.name = name;
        this.id = id;
    }

    public abstract void use(Player player);

    public abstract void destroy();

    public abstract void addRecipe();

}
