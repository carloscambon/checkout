package com.ccambon.checkout.offers;

import java.math.BigDecimal;

import org.junit.Test;

public class AppleOfferTest {
	@Test
	public void payOneAppleGetTwoApplesOfferModifiesQuantityOfApples() {
		for (int i = 0; i < 10; i++) {
			org.junit.Assert.assertTrue(new AppleOffer().applyOffer(i).getGetTotalItems() == i*2);
		}
	}
	
	@Test
	public void payOneAppleGetTwoApplesOfferDoesNotModifyCost() {
		for (int i = 0; i < 10; i++) {
			org.junit.Assert.assertTrue(new AppleOffer().applyOffer(i).getTotalCost().compareTo(new BigDecimal(i*60)) == 0);
		}
	}
}
