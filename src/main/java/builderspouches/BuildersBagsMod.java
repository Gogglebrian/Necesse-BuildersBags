package builderspouches;

import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

@ModEntry
public class BuildersBagsMod {
    public void init() {
        ItemRegistry.registerItem("buildersbagowalls", new BuildersWallsBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagofloors", new BuildersFloorsBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagomiscellany", new BuildersMiscBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagofurniture", new BuildersFurnitureBag(), 500.0F, true);
    }

    public void postInit() {
        Recipes.registerModRecipe(new Recipe(
                "buildersbagowalls",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("stonewall",50),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagofloors",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("stonefloor",50),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagomiscellany",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("stonedoor",10),
                        new Ingredient("wallwindow",10),
                        new Ingredient("stonecolumn",10),
                        new Ingredient("stonefence",10),
                        new Ingredient("stonefencegate",10),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagofurniture",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("oakchair",10),
                        new Ingredient("oakdinnertable",10),
                        new Ingredient("oakbed",10),
                        new Ingredient("oakdresser",10),
                        new Ingredient("oakclock",10),
                }));
    }
}