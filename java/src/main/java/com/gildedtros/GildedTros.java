package com.gildedtros;

import com.gildedtros.qualityUpdater.factories.QualityUpdaterFactory;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        for (int i=0; i<items.length; i++) {
            items[i] = new ItemWrapper(items[i]);
        }
        this.items = items;
    }

    public void updateQuality() {
        QualityUpdaterFactory factory = new QualityUpdaterFactory();
        for (Item item : items) {
            factory.getUpdater(((ItemWrapper) item).getName()).updateQuality((ItemWrapper) item);
        }
    }
}