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
import necesse.level.gameObject.furniture.CarpetObject;
import necesse.level.gameObject.furniture.FurnitureObject;
import necesse.level.gameObject.furniture.RoomFurniture;

public class BuildersFurnitureBag extends PouchItem {
    public BuildersFurnitureBag() {
        this.rarity = Rarity.QUEST;
        this.setItemCategory(ItemCategory.craftingManager, new String[]{"equipment"});
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "buildersfurniturebagtip"));
        tooltips.add(Localization.translate("itemtooltip", "rclickinvopentip"));
        tooltips.add(Localization.translate("itemtooltip", "storeditems", "items", this.getStoredItemAmounts(item)));
        return tooltips;
    }

    public boolean isValidPouchItem(InventoryItem item) {
        return item.item.isPlaceable() && item.item instanceof ObjectItem && ((ObjectItem) item.item).getObject() instanceof RoomFurniture;
    }

    public boolean isValidRequestItem(Item item) {
        return this.isValidRequestType(item.type);
    }

    public boolean isValidRequestType(Item.Type type) {
        return type == Item.Type.MISC;
    }

    public int getInternalInventorySize() {
        return 20;
    }
}
