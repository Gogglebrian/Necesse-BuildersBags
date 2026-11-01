package builderspouches;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.miscItem.PouchItem;

public class BuildersDecorationsBag extends PouchItem {
    public BuildersDecorationsBag() {
        this.rarity = Rarity.EPIC;
        this.drawStoredItems = false;
        this.setItemCategory(ItemCategory.craftingManager, new String[]{"equipment"});
    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "buildersbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "buildersdecorationsbagtip"));
        tooltips.add(Localization.translate("itemtooltip", "rclickinvopentip"));
        tooltips.add(Localization.translate("itemtooltip", "storeditems", "items", this.getStoredItemAmounts(item)));
        return tooltips;
    }

    public static boolean isDecoration(Item item) {
        if (ItemCategory.getCategory("objects","decorations").containsItemOrInChildren(item)
            || ItemCategory.getCategory("objects","landscaping","tabledecorations").containsItemOrInChildren(item)) {
            return true;
        }
        if (ItemCategory.getCategory("objects","misc").containsItemOrInChildren(item)) {
            String stringID = item.getStringID();
            return stringID.equals("largekeg")
                || stringID.contains("utensilrack")
                || stringID.equals("merchantsbackpack")
                || stringID.equals("sack")
                || stringID.equals("sign")
                || stringID.equals("christmastree")
                || stringID.contains("crate");
        }
        if (ItemCategory.getCategory("objects").containsItemOrInChildren(item)) {
            String stringID = item.getStringID();
            return stringID.equals("vase")
                || stringID.contains("sink");
        }
        return false;
    }

    public boolean isValidPouchItem(InventoryItem item) {
        return isDecoration(item.item);
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
