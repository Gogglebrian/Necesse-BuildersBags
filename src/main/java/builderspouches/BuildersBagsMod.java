package builderspouches;

import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

@ModEntry
public class BuildersBagsMod {
    public void registerItems() {
        ItemRegistry.registerItem("buildersbagowalls", new BuildersWallsBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagofloors", new BuildersFloorsBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagomiscellany", new BuildersMiscBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagofurniture", new BuildersFurnitureBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagodecorations", new BuildersDecorationsBag(), 500.0F, true);
        ItemRegistry.registerItem("buildersbagolandscaping", new BuildersLandscapingBag(), 500.0F, true);
    }
    public void registerRecipes() {
        Recipes.registerModRecipe(new Recipe(
                "buildersbagowalls",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("stonewall",10),
                        new Ingredient("woodwall",10),
                        new Ingredient("brickwall",10),
                        new Ingredient("snowstonewall",10),
                        new Ingredient("dungeonwall",10),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagofloors",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("stonefloor",10),
                        new Ingredient("woodfloor",10),
                        new Ingredient("granitebrickfloor",10),
                        new Ingredient("swampstonepathtile",10),
                        new Ingredient("snowstonefloor",10),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagomiscellany",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("granitedoor",10),
                        new Ingredient("wallwindow",10),
                        new Ingredient("stonecolumn",10),
                        new Ingredient("woodfence",10),
                        new Ingredient("ironfencegate",10),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagofurniture",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("oakchair",10),
                        new Ingredient("mapledinnertable",10),
                        new Ingredient("willowbed",10),
                        new Ingredient("palmdresser",10),
                        new Ingredient("pineclock",10),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagodecorations",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("flowerpot",10),
                        new Ingredient("woolcarpet",10),
                        new Ingredient("eggcellentbanner",10),
                        new Ingredient("mug",10),
                        new Ingredient("tableclock",10),
                }));
        Recipes.registerModRecipe(new Recipe(
                "buildersbagolandscaping",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[] {
                        new Ingredient("voidpouch",1),
                        new Ingredient("buildingpotion",10),
                        new Ingredient("rock",10),
                        new Ingredient("sandtile",10),
                        new Ingredient("grassseed",10),
                        new Ingredient("landfill",10),
                        new Ingredient("angelicstatue",10),
                }));
    }

    public void init() {
        registerItems();
    }

    public void postInit() {
        registerRecipes();
    }
}