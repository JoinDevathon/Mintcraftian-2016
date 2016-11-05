package org.devathon.contest2016.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class MachineItem {

    protected ItemStack item;

    protected String name;
    protected Material material;
    protected byte data;

    public MachineItem(String name, Material material, byte data) {
        this.name = name;
        this.material = material;
        this.data = data;

        item = new ItemStack(material, 1, (short) 0, data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + name);
        item.setItemMeta(meta);
    }

    public MachineItem(String name, Material material) {
        this(name, material, (byte) 0);
    }

    public abstract void addRecipe();

    public ItemStack getItem() {
        return item;
    }

}
