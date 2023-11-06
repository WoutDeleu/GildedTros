package com.gildedtros.qualityUpdater.impl;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class SmellyUpdater implements QualityUpdater {

    public void updateQuality(Item item) {
        if (--item.sellIn < 0) {
            item.decreaseQualityBy(4);
        } else {
            item.decreaseQualityBy(2);
        }
    }
}
