package builderspouches;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.miscItem.PouchItem;
import necesse.inventory.item.placeableItem.tileItem.TileItem;

public class BuildersFloorsBag extends PouchItem {
    public BuildersFloorsBag() {
        this.rarity = Rarity.EPIC;
        this.drawStoredItems = false;
        this.setItemCategory(ItemCategory.craftingManager, new String[]{"equipment"});
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "buildersbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "buildersfloorsbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "rclickinvopentip"));
        tooltips.add(Localization.translate("itemtooltip", "storedtiles", "items", this.getStoredItemAmounts(item)));
        return tooltips;
    }

    public static boolean isFloor(Item item) {
        return ItemCategory.getCategory("tiles","floors").containsItemOrInChildren(item);
    }

    public boolean isValidPouchItem(InventoryItem item) {
        return item.item.isPlaceable() && item.item instanceof TileItem && (isFloor(item.item));
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
