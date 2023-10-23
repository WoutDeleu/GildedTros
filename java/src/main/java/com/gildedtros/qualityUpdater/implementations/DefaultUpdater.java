package com.gildedtros.qualityUpdater.implementations;

import com.gildedtros.Item;
import com.gildedtros.qualityUpdater.QualityUpdater;

public class DefaultUpdater implements QualityUpdater {
    public static boolean isSmelly(String name) {
        return name.equals("Duplicate Code") || name.equals("Long Methods") || name.equals("Ugly Variable Names");
    }

    public void updateQuality(Item item) {
        int factor = --item.sellIn < 0 ? 2 : 1;
        if (isSmelly(item.name)) factor *= 2;

        item.quality -= factor;

        if (item.quality < 0) item.quality = 0;
    }

}
