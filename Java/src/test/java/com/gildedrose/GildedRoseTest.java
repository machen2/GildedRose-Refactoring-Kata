package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void afterOneDayANormalItemsSellInNumberIsDecreasedByOne(){
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0,gildedRose.items[0].sellIn);
    }

    @Test
    public void afterOneDayANormalItemsQualityIsDecreasedByOne(){
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void afterNormalItemExpiresQualityDecreasesByTwo(){
        Item[] items = new Item[] { new Item("foo", -1, 2) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void givenNormalItemWithQuality0AfterOneDayQualityIsStill0(){
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void givenAgedBrieWithQuality0AfterOneDayQualityIs1(){
        Item[] items = new Item[] { new Item("Aged Brie", 1, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    public void givenAgedBrieWithQuality50AfterOneDayQualityIsStill50(){
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void givenBackStagePassesWithQuality50AfterOneDayQualityIsStill50(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void givenSulfurasHandWithASellInDateOf5After1DayTheSellInDateIsStill5(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(5, gildedRose.items[0].sellIn);
    }

    @Test
    public void givenSulfurasHandWithQuality80After1DayTheQualityIsStill80(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    public void givenBackstagePassesWithQuality0AndSellInDate10After1DayTheQualityIs2(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    public void givenBackstagePassesWithQuality0AndSellInDate8After1DayTheQualityIs2(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    public void givenBackstagePassesWithQuality0AndSellInDate5After1DayTheQualityIs3(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(3, gildedRose.items[0].quality);
    }

    @Test
    public void givenBackstagePassesWithQuality0AndSellInDate3After1DayTheQualityIs3(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(3, gildedRose.items[0].quality);
    }

    @Test
    public void givenBackstagePassesWithQuality10AndSellInDateIs0After1DayTheQualityIs0(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }



}
