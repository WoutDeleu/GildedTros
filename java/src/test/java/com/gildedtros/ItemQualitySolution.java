package com.gildedtros;

public class ItemQualitySolution {
    // Keeps the correct quality and sellIn values for each day
    private int[] sellIn;
    private int[] quality;

    public ItemQualitySolution(int[] sellIn, int[] quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getQuality(int day) {
        return quality[day];
    }
    public int getSellIn(int day) {
        return sellIn[day];
    }
}
