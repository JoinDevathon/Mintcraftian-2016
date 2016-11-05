package org.devathon.contest2016.machines.transportation;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.items.ConveyorBeltItem;
import org.devathon.contest2016.machines.TransportationMachine;

public class ConveyorBeltMachine extends TransportationMachine {

    public ConveyorBeltMachine(DevathonPlugin instance, Location location) {
        super(instance, location, new ConveyorBeltItem(), "Conveyor Belt", 0, 0.5f, 2);
    }

    public void build() {}

    public boolean move() {
        return false;
    }

    public void use(Player player) {

    }

    public void destroy() {

    }

}
