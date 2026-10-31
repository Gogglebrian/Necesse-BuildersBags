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

public class BuildersMiscBag extends PouchItem {
    public BuildersMiscBag() {
        this.rarity = Item.Rarity.QUEST;
        this.drawStoredItems = false;
        this.setItemCategory(ItemCategory.craftingManager, new String[]{"equipment"});
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "buildersmiscbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "rclickinvopentip"));
        tooltips.add(Localization.translate("itemtooltip", "storeditems", "items", this.getStoredItemAmounts(item)));
        return tooltips;
    }

    public static boolean isMiscConstructionItem(String itemID) {
        return itemID.contains("door") || itemID.contains("fence") || itemID.contains("window") || itemID.contains("column");
    }

    public boolean isValidPouchItem(InventoryItem item) {
        return item.item.isPlaceable() && item.item instanceof ObjectItem && isMiscConstructionItem(item.item.getStringID());
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
