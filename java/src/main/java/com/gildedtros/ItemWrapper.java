package com.gildedtros;

import static com.gildedtros.qualityUpdater.QualityUpdater.MAX_QUALITY;

public class ItemWrapper {
    private Item item;
    public ItemWrapper(Item item) {
        this.item = item;
    }

    public void decreaseQualityBy(int decreaseBy) {
        this.item.quality -= decreaseBy;
        if (this.item.quality < 0) this.item.quality = 0;
    }

    public void increaseQualityBy(int increaseBy) {
        this.item.quality += increaseBy;
        if (this.item.quality > MAX_QUALITY) this.item.quality = MAX_QUALITY;
    }

   @Override
   public String toString() {
        return this.item.toString();
    }

    public void decreaseSellIn() {
        this.item.sellIn--;
    }

    public boolean isExpired() {
        return this.item.sellIn < 0;
    }

    public boolean closerToEventThan(int days) {
        return this.item.sellIn <= days;
    }

    public boolean willExpire() {
        return this.item.sellIn < 1;
    }

    public void setQualityToZero() {
        this.item.quality = 0;
    }

    public String getName() {
        return this.item.name;
    }
}
