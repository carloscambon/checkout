package com.ccambon.checkout.items;

public class ItemFactory {
	public static IItem createItem(String itemName) {
		if (itemName == null) {
			throw new IllegalArgumentException("ItemFactory: item name cannot be null !!");
		}
		switch (itemName) {
			case "Apple":
				return new Apple();
			case "Orange":
				return new Orange();
			default:
				throw new IllegalArgumentException("ItemFactory: The item " + itemName + " does not exist");
		}
	}
}
