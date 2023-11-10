package com.gildedtros;

import static com.gildedtros.qualityUpdater.QualityUpdater.MAX_QUALITY;

public class ItemWrapper extends Item {

    public ItemWrapper(Item item) {
        super(item);
    }

    public void decreaseQualityBy(int decreaseBy) {
        this.quality -= decreaseBy;
        if (this.quality < 0) this.quality = 0;
    }

    public void increaseQualityBy(int increaseBy) {
        this.quality += increaseBy;
        if (this.quality > MAX_QUALITY) this.quality = MAX_QUALITY;
    }

   @Override
   public String toString() {
        return this.toString();
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public boolean isExpired() {
        return this.sellIn < 0;
    }

    public boolean closerToEventThan(int days) {
        return this.sellIn <= days;
    }

    public boolean willExpire() {
        return this.sellIn < 1;
    }

    public void setQualityToZero() {
        this.quality = 0;
    }

    public String getName() {
        return this.name;
    }
}
