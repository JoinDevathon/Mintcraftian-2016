package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.MachineItem;

public abstract class Machine {

    private DevathonPlugin instance;
    private Location location;
    private MachineItem item;
    private String name;
    private int id;

    public Machine(DevathonPlugin instance, Location location, MachineItem item, String name, int id) {
        this.instance = instance;
        this.location = location;
        this.item = item;
        this.name = name;
        this.id = id;

        build();
    }

    public abstract void build();

    public abstract void use(Player player);

    public abstract void destroy();

    public Location getLocation() {
        return location;
    }
}
