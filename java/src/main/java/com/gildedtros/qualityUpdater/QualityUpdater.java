package com.gildedtros.qualityUpdater;

import com.gildedtros.Item;
import com.gildedtros.ItemWrapper;

public interface QualityUpdater {
    int MAX_QUALITY = 50;
    void updateQuality(ItemWrapper item);
}
