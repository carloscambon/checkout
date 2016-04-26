package com.ccambon.checkout;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import com.ccambon.checkout.items.ItemFactory;
import com.ccambon.checkout.offers.IOffer;
import com.ccambon.checkout.offers.OfferResult;

/**
 * Represents shop checkout system.
 * 
 * @author ccambon
 *
 */
public class Checkout {
	/**
	 * default locale for the currency used.
	 */
	private static Locale locale = Locale.UK;
	private Map<String, Integer> checkoutItems = new HashMap<String, Integer>();
	private Map<String, IOffer> offers = new HashMap<String, IOffer>();

	public Checkout(List<String> itemNames, List<IOffer> iOffers) {
		if (itemNames == null) {
			throw new IllegalArgumentException("Checkout: List of item names was null !!");
		}

		// Storing the quantity of each item name
		for (String itemameName : itemNames) {
			if (!checkoutItems.containsKey(itemameName)) {
				checkoutItems.put(itemameName, 1);
			} else {
				checkoutItems.put(itemameName, checkoutItems.get(itemameName) + 1);
			}
		}

		// Validating that the item names are correct
		for (String itemName : checkoutItems.keySet()) {
			// Will throw IllegalArgumentException if item name is wrong
			ItemFactory.createItem(itemName);
		}

		// Storing the offers mapped to the item name. This is for later apply
		// the appropriate offer to its item
		if (iOffers != null) {
			for (IOffer iOffer : iOffers) {
				offers.put(iOffer.getItemName(), iOffer);
			}
		}

	}

	/**
	 * Returns the quantity of the item name passed in
	 * 
	 * @param itemName
	 * @return quantity of the item
	 */
	public int getItemQuantity(String itemName) {
		return checkoutItems.get(itemName);
	}

	/**
	 * Returns the total cost of all the items passed in.
	 * 
	 * @param List
	 *            of checkout item names
	 * @return currency-formatted total cost
	 */
	public String getTotalPrice() {

		BigDecimal result = BigDecimal.ZERO;

		// Adding the cost of all items passed in
		for (Entry<String, Integer> entry : checkoutItems.entrySet()) {
			String itemName = entry.getKey();
			Integer quantity = entry.getValue();
			if (offers.containsKey(itemName)) {
				// Applying the offer. This could mean changing the quantity of
				// items or the total cost
				IOffer itemOffer = offers.get(itemName);
				OfferResult offerResult = itemOffer.applyOffer(checkoutItems.get(itemName));
				checkoutItems.put(itemName, offerResult.getGetTotalItems());
				result = result.add(offerResult.getTotalCost());
			} else {
				// No offer for that item. Multiplying normal cost by the
				// quantity
				int itemCost = ItemFactory.createItem(itemName).getCost();
				result = result.add(new BigDecimal(itemCost * quantity));
			}
		}

		// Taking into account that the cost is in pennies
		result = result.divide(BigDecimal.valueOf(100));

		// Formatting as per the currency used
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(result);
	}

}
