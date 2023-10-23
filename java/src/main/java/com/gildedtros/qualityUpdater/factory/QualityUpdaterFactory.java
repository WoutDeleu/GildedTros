package com.gildedtros.qualityUpdater.factory;

import com.gildedtros.qualityUpdater.*;
import com.gildedtros.qualityUpdater.implementations.*;

import java.util.Arrays;

public class QualityUpdaterFactory {
    private static final String[] LEGENDARY_ITEMS = new String[] {"B-DAWG Keychain"};
    private static final String[] SMELLY_ITEMS = new String[] {"Duplicate Code", "Long Methods", "Ugly Variable Names"};
    private static final String[] BACKSTAGE_ITEMS = new String[] {"Re:Factor", "HAXX"};

    private final QualityUpdater backstage = new BackstageUpdater();
    private final QualityUpdater legendary = new LegendaryUpdater();
    private final QualityUpdater wine = new WineUpdater();
    private final QualityUpdater def = new DefaultUpdater();
    private final QualityUpdater smelly = new SmellyUpdater();

    public QualityUpdater getUpdater(String name) {
        if (isBackstagePass(name)) return this.backstage;
        if (isGoodWine(name)) return this.wine;
        if (isLegendary(name)) return this.legendary;
        if (isSmelly(name)) return this.smelly;
        return this.def;
    }


    private static boolean isBackstagePass(String name) {
        for (String backstageItem : BACKSTAGE_ITEMS) {
            if (name.matches("^Backstage passes for " + backstageItem)) return true;
        }
        return false;
    }
    private static boolean isLegendary(String name) {
        return Arrays.asList(LEGENDARY_ITEMS).contains(name);
    }
    private static boolean isGoodWine(String name) {
        return name.equals("Good Wine");
    }

    private static boolean isSmelly(String name) {
        return Arrays.asList(SMELLY_ITEMS).contains(name);
    }
}
