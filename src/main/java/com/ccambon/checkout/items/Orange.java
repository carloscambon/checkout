package com.ccambon.checkout.items;

public class Orange implements IItem {
	public static final String NAME = "Orange";
	private static final int PRICE_PER_UNIT = 25;

	@Override
	public int getCost() {
		return PRICE_PER_UNIT;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
