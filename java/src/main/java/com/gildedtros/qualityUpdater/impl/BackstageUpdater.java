package com.gildedtros.qualityUpdater.impl;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class BackstageUpdater implements QualityUpdater {
    public void updateQuality(Item item) {
        if (--item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        if (item.sellIn <= 5) item.increaseQualityBy(3);
        else if (item.sellIn <= 10) item.increaseQualityBy(2);
        else item.increaseQualityBy(1);

        item.sellIn--;
    }
}
