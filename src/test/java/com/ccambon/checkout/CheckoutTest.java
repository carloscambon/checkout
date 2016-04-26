package com.ccambon.checkout;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ccambon.checkout.items.Apple;
import com.ccambon.checkout.items.Orange;
import com.ccambon.checkout.offers.AppleOffer;
import com.ccambon.checkout.offers.OrangeOffer;

public class CheckoutTest {

	@Test
	public void totalCostOfItemsIsTheAdditionOfItsCosts() {
		List<String> itemNames = Arrays.asList(Apple.NAME, Apple.NAME, Orange.NAME, Apple.NAME);
		Checkout checkout = new Checkout(itemNames, null);
		org.junit.Assert.assertTrue(checkout.getTotalPrice().equals("£2.05"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullListOfItemsThrowsException() {
		new Checkout(null, null).getTotalPrice();
	}

	@Test
	public void emptyListOfItemsReturnsTotalPrice0() {
		List<String> itemNames = Arrays.asList();
		Checkout checkout = new Checkout(itemNames, null);
		org.junit.Assert.assertTrue(checkout.getTotalPrice().equals("£0.00"));
	}

	@Test
	public void buyOneAppleGetTwoOfferDoublesQuantity() {
		List<String> itemNames = Arrays.asList(Apple.NAME);
		List offers = Arrays.asList(new AppleOffer());
		Checkout checkout = new Checkout(itemNames, offers);
		org.junit.Assert.assertTrue(checkout.getTotalPrice().equals("£0.60"));
		org.junit.Assert.assertTrue(checkout.getItemQuantity(Apple.NAME) == 2);
	}

	@Test
	public void threeForThePriceOfTwoModifiesPrice() {
		List<String> itemNames = Arrays.asList(Orange.NAME, Orange.NAME, Orange.NAME);
		List offers = Arrays.asList(new OrangeOffer());
		Checkout checkout = new Checkout(itemNames, offers);
		org.junit.Assert.assertTrue(checkout.getTotalPrice().equals("£0.50"));
		org.junit.Assert.assertTrue(checkout.getItemQuantity(Orange.NAME) == 3);
	}

	@Test
	public void twoOffersOnDiferentItemsAreAppliedCorrectly() {
		List<String> itemNames = Arrays.asList(Orange.NAME, Orange.NAME, Orange.NAME, Orange.NAME, Orange.NAME,
				Orange.NAME, Orange.NAME, Apple.NAME, Apple.NAME);
		List offers = Arrays.asList(new OrangeOffer(), new AppleOffer());
		Checkout checkout = new Checkout(itemNames, offers);
		org.junit.Assert.assertTrue(checkout.getTotalPrice().equals("£2.45"));
		org.junit.Assert.assertTrue(checkout.getItemQuantity(Orange.NAME) == 7);
		org.junit.Assert.assertTrue(checkout.getItemQuantity(Apple.NAME) == 4);
	}
}
