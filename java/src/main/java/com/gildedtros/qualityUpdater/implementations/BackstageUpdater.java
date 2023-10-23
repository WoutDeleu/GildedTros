package com.gildedtros.qualityUpdater.implementations;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class BackstageUpdater implements QualityUpdater {
    public void updateQuality(Item item) {
        if (item.sellIn - 1 < 0) {
            item.quality = 0;
            return;
        }

        int factor = 1;
        if (item.sellIn <= 10) factor = 2;
        if (item.sellIn <= 5) factor = 3;

        item.quality += factor;
        if (item.quality > MAX_QUALITY) item.quality = MAX_QUALITY;
        item.sellIn--;
    }
}
