package org.devathon.contest2016.machines;

import org.devathon.contest2016.DevathonPlugin;

import java.util.HashSet;
import java.util.Set;

public class MachineManager {

    private Set<Machine> machines = new HashSet<>();

    private DevathonPlugin instance;

    public MachineManager(DevathonPlugin instance) {
        this.instance = instance;
    }

    public void loadMachines() {

    }

    public void saveMachineData(Machine machine) {

    }

}
