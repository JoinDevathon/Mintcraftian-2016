package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.MachineItem;

public abstract class Machine {

    protected DevathonPlugin instance;
    protected Location location;
    protected MachineItem item;
    protected String name;
    private int id;

    public Machine(DevathonPlugin instance, Location location, MachineItem item, String name, int id) {
        this.instance = instance;
        this.location = location;
        this.item = item;
        this.name = name;
        this.id = id;

        build();
        instance.getMachines().add(this);
    }

    public void build() {}

    public abstract void use(Player player);

    public void destroy() {
        instance.getMachines().remove(this);
    }

    // Updates every tick
    public abstract void update(long tick);

    public Location getLocation() {
        return location;
    }
}
