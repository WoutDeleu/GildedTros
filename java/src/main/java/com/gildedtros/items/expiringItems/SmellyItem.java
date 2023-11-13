package com.gildedtros.items.expiringItems;

import com.gildedtros.items.Item;

public class SmellyItem extends ExpiringItem {
    public SmellyItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        this.decreaseSellIn();
        if (this.isExpired()) this.decreaseQualityBy(4);
        else this.decreaseQualityBy(2);
    }
}
