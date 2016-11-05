package org.devathon.contest2016.item.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.devathon.contest2016.item.MachineItem;

public class BlockDispenserItem extends MachineItem {

    public BlockDispenserItem() {
        super("Block Dispenser", Material.DISPENSER);
    }

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("IDI", " F ");
        recipe.setIngredient('I', Material.IRON_BLOCK);
        recipe.setIngredient('D', Material.DISPENSER);
        recipe.setIngredient('F', Material.FURNACE);

        Bukkit.getServer().addRecipe(recipe);
    }
}
