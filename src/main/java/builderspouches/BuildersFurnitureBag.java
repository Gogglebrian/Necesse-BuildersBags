package builderspouches;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.miscItem.PouchItem;
import necesse.inventory.item.placeableItem.objectItem.ObjectItem;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.ProcessingForgeObject;
import necesse.level.gameObject.container.CampfireObject;
import necesse.level.gameObject.container.MusicPlayerObject;
import necesse.level.gameObject.furniture.CarpetObject;
import necesse.level.gameObject.furniture.FlowerObject;
import necesse.level.gameObject.furniture.FurnitureObject;
import necesse.level.gameObject.happinessObject.WitchCauldronObject;

public class BuildersFurnitureBag extends PouchItem {
    public BuildersFurnitureBag() {
        this.rarity = Rarity.EPIC;
        this.drawStoredItems = false;
        this.setItemCategory(ItemCategory.craftingManager, new String[]{"equipment"});
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "buildersbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "buildersfurniturebagtip"));
        tooltips.add(Localization.translate("itemtooltip", "rclickinvopentip"));
        tooltips.add(Localization.translate("itemtooltip", "storeditems", "items", this.getStoredItemAmounts(item)));
        return tooltips;
    }

    public boolean isLightObject(GameObject object) {
        return object.roomProperties.contains("lights");
    }
    public boolean isFurniture(GameObject object) {
        return object instanceof FurnitureObject && !(object instanceof FlowerObject) && !(object instanceof CarpetObject);
    }
    public boolean isValidObject(GameObject object) {
        return isFurniture(object)
            || isLightObject(object)
            || object instanceof ProcessingForgeObject
            || object instanceof MusicPlayerObject
            || object instanceof CampfireObject
            || object instanceof WitchCauldronObject;
    }

    public boolean isValidPouchItem(InventoryItem item) {
        return item.item.isPlaceable() && item.item instanceof ObjectItem && isValidObject(((ObjectItem) item.item).getObject());
    }

    public boolean isValidRequestItem(Item item) {
        return this.isValidRequestType(item.type);
    }

    public boolean isValidRequestType(Item.Type type) {
        return false;
    }

    public int getInternalInventorySize() {
        return 20;
    }
}
