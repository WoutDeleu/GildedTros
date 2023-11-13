package com.gildedtros.items.immutableItems;

import com.gildedtros.items.Item;
import com.gildedtros.items.ItemWrapper;

public class LegendaryItem extends ItemWrapper {
    @Override
    public void updateQuality() {
        // Legendary items do not change
    }

    public LegendaryItem(Item item) {
        super(item);
    }

}
