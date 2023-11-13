package com.gildedtros.items.expiringItems;

import com.gildedtros.items.Item;

public class WineItem extends ExpiringItem {
    public WineItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        this.decreaseSellIn();
        if (this.isExpired()) this.increaseQualityBy(2);
        else this.increaseQualityBy(1);
    }
}
