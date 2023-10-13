package com.gildedtros;

class GildedTros {
    Item[] items;
    private final int MAX_QUALITY = 50;

    public GildedTros(Item[] items) {
        this.items = items;
    }
    public static boolean isBackstagePass(String name) {
        return name.matches("^Backstage passes for (Re:Factor|HAXX)");
    }
    private static boolean isLegendary(String name) {
        return name.equals("B-DAWG Keychain");
    }
    public static boolean isGoodWine(String name) {
        return name.equals("Good Wine");
    }

    public static boolean isSmelly(String name) {
        return name.equals("Duplicate Code") || name.equals("Long Methods") || name.equals("Ugly Variable Names");
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isGoodWine(item.name)) {
                updateWine(item);
            }
            else if (isBackstagePass(item.name)) {
                updateBackstage(item);
            }
            else if (!isLegendary(item.name)) {
                updateDefault(item, isSmelly(item.name));
            }

        }
    }

    private void updateDefault(Item item, boolean isSmelly) {
        int factor = --item.sellIn < 0 ? 2 : 1;
        if (isSmelly) factor *= 2;

        item.quality -= factor;

        if (item.quality < 0) item.quality = 0;
    }

    private void updateWine(Item item) {
        int factor = --item.sellIn < 0 ? 2 : 1;
        item.quality += factor;

        if (item.quality > MAX_QUALITY)  item.quality = MAX_QUALITY;
    }

    private void updateBackstage(Item item) {
        if (item.sellIn - 1 < 0) {
            item.quality = 0;
            return;
        }

        int factor = 1;
        if (item.sellIn <= 10) factor = 2;
        if (item.sellIn <= 5) factor = 3;

        item.quality += factor;
        if (item.quality > MAX_QUALITY) item.quality = MAX_QUALITY;
        item.sellIn--;
    }
}