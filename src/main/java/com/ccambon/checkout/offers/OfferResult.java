package com.ccambon.checkout.offers;

import java.math.BigDecimal;

public class OfferResult {
	private int totalItems;
	private BigDecimal totalCost;

	public OfferResult(int totalItems, BigDecimal totalCost) {
		this.totalItems = totalItems;
		this.totalCost = totalCost;
	}

	public int getGetTotalItems() {
		return totalItems;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

}
