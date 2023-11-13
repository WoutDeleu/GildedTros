package com.gildedtros.factories;

import com.gildedtros.items.Item;
import com.gildedtros.items.ItemWrapper;
import com.gildedtros.items.expiringItems.BackstageItem;
import com.gildedtros.items.expiringItems.DefaultItem;
import com.gildedtros.items.expiringItems.SmellyItem;
import com.gildedtros.items.expiringItems.WineItem;
import com.gildedtros.items.immutableItems.LegendaryItem;

import java.util.Arrays;

public class ItemFactory {
    private static final String[] LEGENDARY_ITEMS = new String[] {"B-DAWG Keychain"};
    private static final String[] SMELLY_ITEMS = new String[] {"Duplicate Code", "Long Methods", "Ugly Variable Names"};
    private static final String[] BACKSTAGE_ITEMS = new String[] {"Re:Factor", "HAXX"};
    private static final String[] DEFAULT_ITEMS = new String[] {"Ring of Cleansening Code","Elixir of the SOLID"};

    public Item create(Item item)  {
        if (isBackstagePass(item.name)) return new BackstageItem(item);
        if (isGoodWine(item.name)) return new WineItem(item);
        if (isLegendary(item.name)) return new LegendaryItem(item);
        if (isSmelly(item.name)) return new SmellyItem(item);
        return new DefaultItem(item);
    }

    private boolean isDefault(String name) {
        return Arrays.asList(DEFAULT_ITEMS).contains(name);
    }


    private static boolean isBackstagePass(String name) {
        for (String backstageItem : BACKSTAGE_ITEMS) {
            if (name.matches("^Backstage passes for " + backstageItem)) return true;
        }
        return false;
    }
    private static boolean isLegendary(String name) {
        return Arrays.asList(LEGENDARY_ITEMS).contains(name);
    }
    private static boolean isGoodWine(String name) {
        return name.equals("Good Wine");
    }

    private static boolean isSmelly(String name) {
        return Arrays.asList(SMELLY_ITEMS).contains(name);
    }
}
