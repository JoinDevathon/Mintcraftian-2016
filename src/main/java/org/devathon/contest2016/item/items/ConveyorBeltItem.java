package org.devathon.contest2016.item.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.devathon.contest2016.item.MachineItem;

public class ConveyorBeltItem extends MachineItem {

    public ConveyorBeltItem() {
        super("Conveyor Belt", Material.WOOL, (byte) 15);
    }

    public void addRecipe() {
        ItemStack item = this.item.clone();
        item.setAmount(16);
        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("SSS", " I ");
        recipe.setIngredient('S', Material.WOOL, 15);
        recipe.setIngredient('I', Material.IRON_BLOCK);

        Bukkit.getServer().addRecipe(recipe);
    }
}
