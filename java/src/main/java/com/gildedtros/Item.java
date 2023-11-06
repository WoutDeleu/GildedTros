package com.gildedtros;

import static com.gildedtros.qualityUpdater.QualityUpdater.MAX_QUALITY;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
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
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public boolean isExpired() {
        return this.sellIn < 0;
    }

    public boolean closerThanToEvent(int days) {
        return this.sellIn < days;
    }
}
