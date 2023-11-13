package com.gildedtros;

import com.gildedtros.items.Item;
import com.gildedtros.items.ItemWrapper;
import com.gildedtros.factories.ItemFactory;

class GildedTros {
    Item[] items;
    private final ItemFactory itemFactory;

    public GildedTros(Item[] items) {
        this.itemFactory = new ItemFactory();

        for (int i=0; i<items.length; i++) {
            items[i] = this.itemFactory.create(items[i]);
        }
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ((ItemWrapper) item).updateQuality();
        }
    }
}