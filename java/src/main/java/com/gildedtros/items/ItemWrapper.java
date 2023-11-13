package com.gildedtros.items;

public abstract class ItemWrapper extends Item {
    public abstract void updateQuality();

    public ItemWrapper(Item item) {
        super(item);
    }
}
