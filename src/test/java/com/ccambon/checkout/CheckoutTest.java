package com.ccambon.checkout;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ccambon.checkout.items.Apple;
import com.ccambon.checkout.items.Orange;

public class CheckoutTest {

	@Test
	public void totalCostOfItemsIsTheAdditionOfItsCosts () {
		List<String> itemNames = Arrays.asList(Apple.NAME, Apple.NAME, Orange.NAME, Apple.NAME);
		org.junit.Assert.assertTrue(Checkout.getTotalPrice(itemNames).equals("£2.05"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullListOfItemsThrowsException () {
		Checkout.getTotalPrice(null);
	}
	
	@Test
	public void emptyListOfItemsReturnsTotalPrice0 () {
		List<String> itemNames = Arrays.asList();
		org.junit.Assert.assertTrue(Checkout.getTotalPrice(itemNames).equals("£0.00"));
	}
}
