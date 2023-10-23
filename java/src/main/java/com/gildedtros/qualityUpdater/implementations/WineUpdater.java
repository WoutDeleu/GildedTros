package com.gildedtros.qualityUpdater.implementations;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class WineUpdater implements QualityUpdater {
    public void updateQuality(Item item) {
        int factor = --item.sellIn < 0 ? 2 : 1;
        item.quality += factor;

        if (item.quality > MAX_QUALITY)  item.quality = MAX_QUALITY;

    }
}
