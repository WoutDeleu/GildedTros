package com.gildedtros.qualityUpdater.impl;

import com.gildedtros.Item;
import com.gildedtros.ItemWrapper;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class WineUpdater implements QualityUpdater {
    public void updateQuality(ItemWrapper item) {
        item.decreaseSellIn();
        if (item.isExpired()) item.increaseQualityBy(2);
        else item.increaseQualityBy(1);
    }
}
