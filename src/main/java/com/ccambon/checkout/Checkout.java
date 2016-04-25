package com.ccambon.checkout;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import com.ccambon.checkout.items.ItemFactory;

/**
 * Represents shop checkout system. 
 * @author ccambon
 *
 */
public class Checkout {
	/**
	 * default locale for the currency used.
	 */
	private static Locale locale = Locale.UK;

	/**
	 * Returns the total cost of all the items passed in.
	 * @param List of checkout item names
	 * @return currency-formatted total cost 
	 */
	public static String getTotalPrice(List<String> itemNames) {
		if (itemNames == null) {
			throw new IllegalArgumentException("Checkout: List of item names was null !!");
		}

		BigDecimal result = BigDecimal.ZERO;

		// Adding the cost of all items passed in
		for (String itemName : itemNames) {
			int itemCost = ItemFactory.createItem(itemName).getCost();
			result = result.add(new BigDecimal(itemCost));
		}
		
		// Taking into account that cost is in pennies
		result = result.divide(BigDecimal.valueOf(100));
		
		// Formatting as per the currency used
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(result);
	}
}
