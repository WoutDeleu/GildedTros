package com.gildedtros;

public class ItemQualitySolution {
    // Keeps the correct quality and sellIn values for each day
    private final String name;
    private final int[] sellIn;
    private final int[] quality;

    public ItemQualitySolution(String name, int[] sellIn, int[] quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getQuality(int day) {
        return quality[day];
    }
    public int getSellIn(int day) {
        return sellIn[day];
    }

    public String getName() {
        return name;
    }
}
