package com.ccambon.checkout.offers;

import java.math.BigDecimal;

/**
 * Wrapper class to hold the quantity and the total cost of an item
 * @author ccambon
 *
 */
public class OfferResult {
	private int quantity;
	private BigDecimal totalCost;

	public OfferResult(int totalItems, BigDecimal totalCost) {
		this.quantity = totalItems;
		this.totalCost = totalCost;
	}

	public int getGetTotalItems() {
		return quantity;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

}
