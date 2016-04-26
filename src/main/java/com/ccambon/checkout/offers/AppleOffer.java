package com.ccambon.checkout.offers;

import java.math.BigDecimal;

import com.ccambon.checkout.items.Apple;
import com.ccambon.checkout.items.ItemFactory;

public class AppleOffer implements IOffer {

	@Override
	public String getItemName() {
		return Apple.NAME;
	}
	
	/**
	 * Modifies the number of items, offer being: "buy one, get one free on Apples"
	 * @param numberOfItems
	 * @return modified number of items 
	 */
	@Override
	public OfferResult applyOffer(int numberOfItems) {
		BigDecimal totalCost = BigDecimal.ZERO;
		int itemCost = ItemFactory.createItem(getItemName()).getCost();
		totalCost = totalCost.add(new BigDecimal(itemCost * numberOfItems ));
		return new OfferResult(numberOfItems * 2, totalCost);
	}

}
