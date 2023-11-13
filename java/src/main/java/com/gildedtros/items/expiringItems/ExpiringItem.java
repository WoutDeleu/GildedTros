package com.gildedtros.items.expiringItems;

import com.gildedtros.items.Item;
import com.gildedtros.items.ItemWrapper;

public abstract class ExpiringItem extends ItemWrapper {
    public static final int MAX_QUALITY = 50;
    public ExpiringItem(Item item) {
        super(item);
    }
    public abstract void updateQuality();
    public void decreaseSellIn() {
        this.sellIn--;
    }

    public void decreaseQualityBy(int decreaseBy) {
        this.quality -= decreaseBy;
        if (this.quality < 0) this.quality = 0;
    }

    public void increaseQualityBy(int increaseBy) {
        this.quality += increaseBy;
        if (this.quality > MAX_QUALITY) this.quality = MAX_QUALITY;
    }


    public boolean isExpired() {
        return this.sellIn < 0;
    }
    public boolean willExpire() {
        return this.sellIn < 1;
    }

}
