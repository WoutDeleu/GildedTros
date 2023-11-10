package com.gildedtros.qualityUpdater.impl;

import com.gildedtros.Item;
import com.gildedtros.ItemWrapper;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class DefaultUpdater implements QualityUpdater {

    public void updateQuality(ItemWrapper item) {
        item.decreaseSellIn();
        if (item.isExpired()) item.decreaseQualityBy(2);
        else item.decreaseQualityBy(1);
    }
}
