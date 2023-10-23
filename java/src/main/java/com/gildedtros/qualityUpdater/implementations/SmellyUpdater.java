package com.gildedtros.qualityUpdater.implementations;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class SmellyUpdater implements QualityUpdater {

    public void updateQuality(Item item) {
        int factor = --item.sellIn < 0 ? 4 : 2;
        item.quality -= factor;
        if (item.quality < 0) item.quality = 0;
    }
}
