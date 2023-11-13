package com.gildedtros.items.expiringItems;

import com.gildedtros.items.Item;

public class DefaultItem extends ExpiringItem {
    public DefaultItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        this.decreaseSellIn();
        if (this.isExpired()) this.decreaseQualityBy(2);
        else this.decreaseQualityBy(1);
    }
}
