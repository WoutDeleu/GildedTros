package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    // todo: aanpassen
    void nullQuality_nullSellIn() {
        Item[] items = new Item[]{
                new Item("foo", 0, 0),
                new Item("foo", 0, 0)
        };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    // todo aanpassen
    void nullSellIn_nullQuality() {
        Item[] items = new Item[] {
                new Item("foo", 0, 25),
                new Item("foo", 1, 0)
        };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void goldenStandard() {
        Item[] items = new Item[]{
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 0),
                new Item("Elixir of the SOLID", 5, 7),
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80),
                new Item("Backstage passes for Re:Factor", 15, 20),
                new Item("Backstage passes for Re:Factor", 10, 49),
                new Item("Backstage passes for HAXX", 5, 49),
                // todo
                // these smelly items do not work properly yet
                new Item("Duplicate Code", 3, 6),
                new Item("Long Methods", 3, 6),
                new Item("Ugly Variable Names", 3, 6)
        };

        ItemQualitySolution[] solutions = new ItemQualitySolution[] {
                new ItemQualitySolution(new int[] {10, 9, 8, 7}, new int[] {20, 19, 18, 17}),
                new ItemQualitySolution(new int[] {2, 1, 0, -1}, new int[] {0, 1, 2, 4}),
                new ItemQualitySolution(new int[] {5, 4, 3, 2}, new int[] {7, 6, 5, 4}),
                new ItemQualitySolution(new int[] {0, 0, 0, 0}, new int[] {80, 80, 80, 80}),
                new ItemQualitySolution(new int[] {-1, -1, -1, -1}, new int[] {80, 80, 80, 80}),
                new ItemQualitySolution(new int[] {15, 14, 13, 12}, new int[] {20, 21, 22, 23}),
                new ItemQualitySolution(new int[] {10, 9, 8, 7}, new int[] {49, 50, 50, 50}),
                new ItemQualitySolution(new int[] {5, 4, 3, 2}, new int[] {49, 50, 50, 50}),
                //todo
                new ItemQualitySolution(new int[] {3, 2, 1, 0}, new int[] {6, 5, 4, 3}),
                new ItemQualitySolution(new int[] {3, 2, 1, 0}, new int[] {6, 5, 4, 3}),
                new ItemQualitySolution(new int[] {3, 2, 1, 0}, new int[] {6, 5, 4, 3})
        };
        GildedTros gildedTros = new GildedTros(items);
        int days = 4;

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < items.length; j++) {
                assertEquals(solutions[j].getSellIn(i), gildedTros.items[j].sellIn);
                assertEquals(solutions[j].getQuality(i), gildedTros.items[j].quality);
            }
            gildedTros.updateQuality();
        }
    }
}

