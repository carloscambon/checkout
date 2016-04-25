package com.ccambon.checkout.items;

public class Apple implements IItem {

	public static final String NAME = "Apple";
	private static final int PRICE_PER_UNIT = 60;

	@Override
	public int getCost() {
		return PRICE_PER_UNIT;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
