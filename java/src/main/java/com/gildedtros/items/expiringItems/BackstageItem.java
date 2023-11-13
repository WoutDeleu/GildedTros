package com.gildedtros.items.expiringItems;

import com.gildedtros.items.Item;

public class BackstageItem extends ExpiringItem {
    public BackstageItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        if (this.willExpire()) {
            this.setQualityToZero();
            return;
        }

        if (this.closerToEventThan(5)) this.increaseQualityBy(3);
        else if (this.closerToEventThan(10)) this.increaseQualityBy(2);
        else this.increaseQualityBy(1);

        this.decreaseSellIn();
    }

    private void setQualityToZero() {
        this.quality = 0;
    }

    public boolean closerToEventThan(int days) {
        return this.sellIn <= days;
    }

}
