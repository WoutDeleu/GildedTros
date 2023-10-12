package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void nullSellIn_nullQuality() {
        Item[] items = new Item[] {
                new Item("foo", 1, 25),
                new Item("foo", 2, 1)
        };
        GildedTros gildedTros = new GildedTros(items);
        gildedTros.updateQuality();
        assertEquals(0, gildedTros.items[0].sellIn);
        assertEquals(24, gildedTros.items[0].quality);

        assertEquals(1, gildedTros.items[1].sellIn);
        assertEquals(0, gildedTros.items[1].quality);

        gildedTros.updateQuality();
        assertEquals(-1, gildedTros.items[0].sellIn);
        assertEquals(22, gildedTros.items[0].quality);

        assertEquals(0, gildedTros.items[1].sellIn);
        assertEquals(0, gildedTros.items[1].quality);
    }

    @Test
    void goodWineIncrease() {
        Item[] items = new Item[] {
                new Item("Good Wine", 20, 49),
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(gildedTros.items[0].quality, 50);
    }
    @Test
    void qualityNotHigherThan50() {
        Item[] items = new Item[] {
                new Item("Good Wine", 20, 50),
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(gildedTros.items[0].quality, 50);
        gildedTros.updateQuality();
        assertEquals(gildedTros.items[0].quality, 50);
    }

    @Test
    void legendaryItemNoSellIn() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 10, 80)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(gildedTros.items[0].sellIn, 10);
    }

    @Test
    void backstagePassesDecreasing() {
        // todo
    }

    @Test
    void legendaryItemNoQualityDrop() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 10, 80)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(gildedTros.items[0].quality, 80);
    }
    @Test
    void goldenStandardTest() {
        Item[] items = new Item[]{
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 0),
                new Item("Elixir of the SOLID", 5, 7),
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80),
                new Item("Backstage passes for Re:Factor", 15, 20),
                new Item("Backstage passes for Re:Factor", 10, 49),
                new Item("Backstage passes for HAXX", 5, 49),
                new Item("Duplicate Code", 3, 6),
                new Item("Long Methods", 3, 6),
                new Item("Ugly Variable Names", 3, 6)
        };

        ItemQualitySolution[] solutions = new ItemQualitySolution[] {
                new ItemQualitySolution("Ring of Cleansening Code", new int[] {10, 9, 8, 7}, new int[] {20, 19, 18, 17}),
                new ItemQualitySolution("Good Wine", new int[] {2, 1, 0, -1}, new int[] {0, 1, 2, 4}),
                new ItemQualitySolution("Elixir of the SOLID", new int[] {5, 4, 3, 2}, new int[] {7, 6, 5, 4}),
                new ItemQualitySolution("B-DAWG Keychain", new int[] {0, 0, 0, 0}, new int[] {80, 80, 80, 80}),
                new ItemQualitySolution("B-DAWG Keychain", new int[] {-1, -1, -1, -1}, new int[] {80, 80, 80, 80}),
                new ItemQualitySolution("Backstage passes for Re:Factor", new int[] {15, 14, 13, 12}, new int[] {20, 21, 22, 23}),
                new ItemQualitySolution("Backstage passes for Re:Factor", new int[] {10, 9, 8, 7}, new int[] {49, 50, 50, 50}),
                new ItemQualitySolution("Backstage passes for HAXX", new int[] {5, 4, 3, 2}, new int[] {49, 50, 50, 50}),
                // todo: Remove, and replace with correct solution
                new ItemQualitySolution("Duplicate Code", new int[] {3, 2, 1, 0}, new int[] {6, 5, 4, 3}),
                new ItemQualitySolution("Long Methods", new int[] {3, 2, 1, 0}, new int[] {6, 5, 4, 3}),
                new ItemQualitySolution("Ugly Variable Names", new int[] {3, 2, 1, 0}, new int[] {6, 5, 4, 3})
                // new ItemQualitySolution(new int[] {3, 2, 1, 0}, new int[] {6, 4, 2, 0}),
                // new ItemQualitySolution(new int[] {3, 2, 1, 0}, new int[] {6, 4, 2, 0}),
                // new ItemQualitySolution(new int[] {3, 2, 1, 0}, new int[] {6, 4, 2, 0})
        };
        GildedTros gildedTros = new GildedTros(items);
        int days = 4;

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < items.length; j++) {
                assertEquals(solutions[j].getName(), gildedTros.items[j].name);
                assertEquals(solutions[j].getSellIn(i), gildedTros.items[j].sellIn);
                assertEquals(solutions[j].getQuality(i), gildedTros.items[j].quality);
            }
            gildedTros.updateQuality();
        }
    }
}

