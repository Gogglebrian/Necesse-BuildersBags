package builderspouches;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.miscItem.PouchItem;
import necesse.inventory.item.placeableItem.tileItem.GrassSeedItem;
import necesse.inventory.item.placeableItem.tileItem.LandfillItem;
import necesse.inventory.item.placeableItem.tileItem.TileItem;

public class BuildersLandscapingBag extends PouchItem {
    public BuildersLandscapingBag() {
        this.rarity = Rarity.EPIC;
        this.drawStoredItems = false;
        this.setItemCategory(ItemCategory.craftingManager, new String[]{"equipment"});
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "buildersbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "builderslandscapingbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "rclickinvopentip"));
        tooltips.add(Localization.translate("itemtooltip", "storeditems", "items", this.getStoredItemAmounts(item)));
        return tooltips;
    }

    public boolean isValidPouchItem(InventoryItem item) {
        if (!(item.item.isPlaceable())) {
            return false;
        }

        if (item.item instanceof GrassSeedItem
            || item.item instanceof LandfillItem
            || (item.item instanceof TileItem && !BuildersFloorsBag.isFloor(item.item))) {
            return true;
        }

        if (ItemCategory.getCategory("objects","landscaping").containsItemOrInChildren(item.item)) {
            return !ItemCategory.getCategory("objects","landscaping", "tabledecorations").containsItem(item.item);
        }
        return ItemCategory.getCategory("tiles","liquids").containsItem(item.item);
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
