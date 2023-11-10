package com.gildedtros;

import com.gildedtros.qualityUpdater.factories.QualityUpdaterFactory;

class GildedTros {
    ItemWrapper[] items;

    public GildedTros(Item[] items) {
        this.items = new ItemWrapper[items.length];
        for (int i=0; i<items.length; i++) {
            this.items[i] = new ItemWrapper(items[i]);
        }

    }

    public void updateQuality() {
        QualityUpdaterFactory factory = new QualityUpdaterFactory();
        for (ItemWrapper item : items) factory.getUpdater(item.getName()).updateQuality(item);
    }

}