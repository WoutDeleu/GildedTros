package com.gildedtros.qualityUpdater;

import com.gildedtros.Item;

public interface QualityUpdater {
    int MAX_QUALITY = 50;
    void updateQuality(Item item);
}
