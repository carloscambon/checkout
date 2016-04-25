package com.ccambon.checkout.items;

import org.junit.Test;

public class ItemFactoryTest {

	private static final String UNKNOWNITEM = "WRONG_ITEM_NAME";

	@Test(expected=IllegalArgumentException.class)
	public void unknownItemThrowsException () {
		ItemFactory.createItem(UNKNOWNITEM);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullItemThrowsException () {
		ItemFactory.createItem(null);
	}
	
	@Test
	public void orangeItemCreatesSucessfully () {
		IItem orange = ItemFactory.createItem(Orange.NAME);
		org.junit.Assert.assertTrue(orange.getName().equals(Orange.NAME));
		org.junit.Assert.assertTrue(orange.getCost() == 25);
	}
	
	@Test
	public void appleItemCreatesSucessfully () {
		IItem apple = ItemFactory.createItem(Apple.NAME);
		org.junit.Assert.assertTrue(apple.getName().equals(Apple.NAME));
		org.junit.Assert.assertTrue(apple.getCost() == 60);
	}
}
