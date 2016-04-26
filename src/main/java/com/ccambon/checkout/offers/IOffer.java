package com.ccambon.checkout.offers;

/**
 * Interface to be implemented by any item offer passed to the Checkout system
 * @author ccambon
 *
 */
public interface IOffer {
	/**
	 * @return the name of the item that this Offer applies to
	 */
	String getItemName();
	
	/**
	 * Applies the offer to the item. This could mean either modifying the amount of Items and/or the cost.
	 * @param numberOfItems
	 * @return wrapper for the number of items and cost modified.
	 */
	OfferResult applyOffer(int numberOfItems);
}
