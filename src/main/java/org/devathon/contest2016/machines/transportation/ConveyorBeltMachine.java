package org.devathon.contest2016.machines.transportation;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.item.items.ConveyorBeltItem;
import org.devathon.contest2016.machines.TransportationMachine;

public class ConveyorBeltMachine extends TransportationMachine {

    public ConveyorBeltMachine(DevathonPlugin instance) {
        super(instance, new ConveyorBeltItem().getItem(), "Conveyor Belt", 0, 0.5f, 2);
    }

    public boolean move() {
        return false;
    }

    public void use(Player player) {

    }

    public void destroy() {

    }

    public void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new ConveyorBeltItem().getItem());
        recipe.shape("SS");
        recipe.setIngredient('S', Material.WOOL, (byte) 16);
        Bukkit.addRecipe(recipe);
    }
}
