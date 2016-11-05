package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.item.items.BlockDispenserItem;
import org.devathon.contest2016.item.items.ConveyorBeltItem;
import org.devathon.contest2016.machines.Machine;
import org.devathon.contest2016.machines.MachineListener;

import java.util.HashSet;
import java.util.Set;

public class DevathonPlugin extends JavaPlugin {

    private long tick = 0;
    private Set<Machine> machines = new HashSet<>();

    public void onEnable() {
        new BlockDispenserItem().addRecipe();
        new ConveyorBeltItem().addRecipe();

        new MachineListener(this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> machines.forEach(machine -> {
            machine.update(tick);
            tick++;
        }), 0l, 1l);
    }

    public void onDisable() {}

    public Machine getMachine(Location location) {
        for (Machine machine : machines) {
            if(machine.getLocation().getBlockX() == location.getBlockX() && machine.getLocation().getBlockY() == location.getBlockY() && machine.getLocation().getBlockZ() == location.getBlockZ()) {
                return machine;
            }
        }
        return null;
    }

    public boolean isMachine(Location location) {
        return getMachine(location) != null;
    }

    public Set<Machine> getMachines() {
        return machines;
    }
}

