package com.ccambon.checkout.offers;

import java.math.BigDecimal;

import org.junit.Test;

public class OrangeOfferTest {
	@Test
	public void threeForThePriceOfTwoOnOrangesOfferDoesNotModifyQuantityOfOranges() {
		for (int i = 0; i < 10; i++) {
			org.junit.Assert.assertTrue(new OrangeOffer().applyOffer(i).getGetTotalItems() == i);
		}
	}
	
	@Test
	public void threeForThePriceOfTwoOnOrangesOfferModifiesCost() {
		for (int i = 0; i < 10; i++) {
			int freeItems = i/3;
			org.junit.Assert.assertTrue(new OrangeOffer().applyOffer(i).getTotalCost().compareTo(new BigDecimal((i-freeItems)*25)) == 0);
		}
	}
}
