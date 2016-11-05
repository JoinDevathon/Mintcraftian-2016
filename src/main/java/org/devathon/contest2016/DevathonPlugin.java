package org.devathon.contest2016;

import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.item.items.BlockDispenserItem;
import org.devathon.contest2016.item.items.ConveyorBeltItem;
import org.devathon.contest2016.machines.Machine;
import org.devathon.contest2016.machines.MachineListener;

import java.util.HashSet;
import java.util.Set;

public class DevathonPlugin extends JavaPlugin {

    private Set<Machine> machines = new HashSet<>();

    public void onEnable() {
        new BlockDispenserItem().addRecipe();
        new ConveyorBeltItem().addRecipe();

        new MachineListener(this);
    }

    public void onDisable() {}

    public Set<Machine> getMachines() {
        return machines;
    }
}

