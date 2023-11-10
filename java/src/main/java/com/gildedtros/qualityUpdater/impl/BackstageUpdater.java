package com.gildedtros.qualityUpdater.impl;

import com.gildedtros.Item;
import com.gildedtros.ItemWrapper;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class BackstageUpdater implements QualityUpdater {
    public void updateQuality(ItemWrapper item) {
        if (item.willExpire()) {
            item.setQualityToZero();
            return;
        }

        if (item.closerToEventThan(5)) item.increaseQualityBy(3);
        else if (item.closerToEventThan(10)) item.increaseQualityBy(2);
        else item.increaseQualityBy(1);

        item.decreaseSellIn();
    }
}
