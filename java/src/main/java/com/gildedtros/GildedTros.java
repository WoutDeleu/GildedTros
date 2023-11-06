package com.gildedtros;

import com.gildedtros.qualityUpdater.factories.QualityUpdaterFactory;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        QualityUpdaterFactory factory = new QualityUpdaterFactory();
        for (Item item : items) {
            factory.getUpdater(item.name).updateQuality(item);
        }
    }

}