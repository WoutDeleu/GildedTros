package com.gildedtros.qualityUpdater.implementations;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class DefaultUpdater implements QualityUpdater {

    public void updateQuality(Item item) {
        int factor = --item.sellIn < 0 ? 2 : 1;
        item.quality -= factor;
        if (item.quality < 0) item.quality = 0;
    }
}
