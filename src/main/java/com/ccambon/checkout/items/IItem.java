package com.ccambon.checkout.items;

/**
 * Interface for all items to implement
 * 
 * @author ccambon
 *
 */
public interface IItem {
	
	/**
	 * Cost per unit 
	 * @return cost in pennies
	 */
	int getCost();

	/**
	 * Name of the item
	 * @return name 
	 */
	String getName();
	
}
