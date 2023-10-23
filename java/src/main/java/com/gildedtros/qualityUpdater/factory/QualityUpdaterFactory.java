package com.gildedtros.qualityUpdater.factory;

import com.gildedtros.qualityUpdater.*;
import com.gildedtros.qualityUpdater.implementations.BackstageUpdater;
import com.gildedtros.qualityUpdater.implementations.DefaultUpdater;
import com.gildedtros.qualityUpdater.implementations.WineUpdater;

public class QualityUpdaterFactory {
    private final QualityUpdater backstage = new BackstageUpdater();
    private final QualityUpdater legendary = new UpdateLegendary();
    private final QualityUpdater wine = new WineUpdater();
    private final QualityUpdater def = new DefaultUpdater();

    public QualityUpdater getUpdater(String name) {
        if (isBackstagePass(name)) return this.backstage;
        if (isGoodWine(name)) return this.wine;
        if (isLegendary(name)) return this.legendary;
        return this.def;
    }


    private static boolean isBackstagePass(String name) {
        return name.matches("^Backstage passes for (Re:Factor|HAXX)");
    }
    private static boolean isLegendary(String name) {
        return name.equals("B-DAWG Keychain");
    }
    private static boolean isGoodWine(String name) {
        return name.equals("Good Wine");
    }


}
