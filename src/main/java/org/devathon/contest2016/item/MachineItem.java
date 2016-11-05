package org.devathon.contest2016.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class MachineItem {

    private ItemStack item;

    protected String name;
    protected Material material;
    protected byte data;

    public MachineItem(String name, Material material, byte data) {
        this.name = name;
        this.material = material;
        this.data = data;

        item = new ItemStack(material, 1, (short) 0, data);
    }

    public MachineItem(String name, Material material) {
        this(name, material, (byte) 0);
    }

    public ItemStack getItem() {
        return item;
    }

}
