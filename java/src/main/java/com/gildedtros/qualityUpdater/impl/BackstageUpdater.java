package com.gildedtros.qualityUpdater.impl;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class BackstageUpdater implements QualityUpdater {
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        if (item.isExpired()) {
            item.quality = 0;
            return;
        }
        if (item.closerThanToEvent(5)) item.increaseQualityBy(3);
        else if (item.closerThanToEvent(10)) item.increaseQualityBy(2);
        else item.increaseQualityBy(1);

        item.sellIn--;
    }
}
