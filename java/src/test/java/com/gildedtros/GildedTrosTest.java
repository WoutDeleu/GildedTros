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
        assertEquals(0, items[0].sellIn);
        assertEquals(24, items[0].quality);

        assertEquals(1, items[1].sellIn);
        assertEquals(0, items[1].quality);

        gildedTros.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(22, items[0].quality);

        assertEquals(0, items[1].sellIn);
        assertEquals(0, items[1].quality);
    }

    @Test
    void goodWineIncrease() {
        Item[] items = new Item[] {
                new Item("Good Wine", 20, 48),
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(items[0].quality, 49);
    }

    @Test
    void goodWineIncreaseTwiceAsFast() {
        Item[] items = new Item[] {
                new Item("Good Wine", 1, 10),
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(items[0].quality, 11);
        gildedTros.updateQuality();
        assertEquals(items[0].quality, 13);
    }
    @Test
    void qualityNotHigherThan50() {
        Item[] items = new Item[] {
                new Item("Good Wine", 20, 50),
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(50, items[0].quality);
        gildedTros.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void legendaryItemNoSellIn() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 10, 80)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(10, items[0].sellIn);
    }

    @Test
    void backstagePassesDecrease() {
        Item[] items = new Item[] {
                new Item("Backstage passes for HAXX", 13, 30),
                new Item("Backstage passes for Re:Factor", 13, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        for (int i = 0; i < 3; i++) {
            gildedTros.updateQuality();
        }
        assertEquals(33, items[0].quality, "Fault backstage passes for more than 10 days");
        assertEquals(23, items[1].quality, "Fault backstage passes for 10 days or more");

        for (int i = 0; i < 5; i++) {
            gildedTros.updateQuality();
        }
        assertEquals(43, items[0].quality, "Fault backstage passes for 10 days or less");
        assertEquals(33, items[1].quality, "Fault backstage passes for 10 days or less");

        gildedTros.updateQuality();
        assertEquals(46, items[0].quality, "Fault backstage passes for 5 days or less");
        assertEquals(36, items[1].quality, "Fault backstage passes for 5 days or less");

        for(int i = 0; i < 4; i++) {
            gildedTros.updateQuality();
        }
        assertEquals(50, items[0].quality, "Fault backstage passes for 5 days or less");
        assertEquals(48, items[1].quality, "Fault backstage passes for 5 days or less");

        gildedTros.updateQuality();
        assertEquals(0, items[0].quality, "Fault backstage passes when conference has passed");
        assertEquals(0, items[1].quality, "Fault backstage passes when conference has passed");

    }

    @Test
    void legendaryItemNoQualityDrop() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 10, 80)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(80, items[0].quality);
    }

    @Test
    void smellyItems() {
        Item[] items = new Item[] {
                new Item("Duplicate Code", 1, 20),
                new Item("Long Methods", 1, 20),
                new Item("Ugly Variable Names", 1, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();
        assertEquals(18, items[0].quality);
        assertEquals(18, items[1].quality);
        assertEquals(18, items[2].quality);

        gildedTros.updateQuality();
        assertEquals(14, items[0].quality);
        assertEquals(14, items[1].quality);
        assertEquals(14, items[2].quality);
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
                new ItemQualitySolution("Duplicate Code", new int[] {3, 2, 1, 0}, new int[] {6, 4, 2, 0}),
                new ItemQualitySolution("Long Methods", new int[] {3, 2, 1, 0}, new int[] {6, 4, 2, 0}),
                new ItemQualitySolution("Ugly Variable Names", new int[] {3, 2, 1, 0}, new int[] {6, 4, 2, 0})
        };
        GildedTros gildedTros = new GildedTros(items);
        int days = 4;

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < items.length; j++) {
                assertEquals(solutions[j].getName(), items[j].name, "Name " + items[j].name  + " is not correct" + " (Correct: " + solutions[j].getName() +")");
                assertEquals(solutions[j].getSellIn(i), items[j].sellIn, "SellIn value " + items[j].sellIn + " of " + items[j].name + " is not correct" + " (Correct: " + solutions[j].getSellIn(i) +")");
                assertEquals(solutions[j].getQuality(i), items[j].quality, "Quality value " + items[j].quality + " of " + items[j].name + " is not correct" + " (Correct: " + solutions[j].getQuality(i) +")");
            }
            gildedTros.updateQuality();
        }
    }
}

