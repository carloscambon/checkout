package com.ccambon.checkout.offers;

import java.math.BigDecimal;

import com.ccambon.checkout.items.ItemFactory;
import com.ccambon.checkout.items.Orange;

public class OrangeOffer implements IOffer {

	@Override
	public String getItemName() {
		return Orange.NAME;
	}
	
	/**
	 * Modifies the cost, offer being: "3 for the price of 2 on Oranges"
	 * @param numberOfItems
	 * @return modified price
	 */
	@Override
	public OfferResult applyOffer(int numberOfItems) {
		// For every 3 items we get 1 free
		int freeItems = numberOfItems/3;
		
		BigDecimal totalCost = BigDecimal.ZERO;
		int itemCost = ItemFactory.createItem(getItemName()).getCost();
		totalCost = totalCost.add(new BigDecimal(itemCost * (numberOfItems - freeItems) ));
		return new OfferResult(numberOfItems, totalCost);
	}

}
