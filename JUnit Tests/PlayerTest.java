package com.laboon;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private Player player;
	
	/*
	 * This function initializes a Player instance to null before each test is run.
	 */
	@Before
	public void setUp() {
		player = null;
	}
	
	/*
	 * Test to see if a non-null value is returned when the Player() constructor is called.
	 */
	@Test
	public void testPlayerConstructorNoParameters() {
		player = new Player();
		assertNotNull(player);
	}
	
	/*
	 * Test to see if a non-null value is returned when the Player(boolean sugar, boolean 
	 * cream, boolean coffee) constructor is called.
	 */
	@Test
	public void testPlayerConstructorYesParameters() {
		player = new Player(true, true, true);
		assertNotNull(player);
	}
	
	/*
	 * Test to see if True is returned after the getSugar() function has been called.
	 */
	@Test
	public void testGetSugar() {
		player = new Player(false, true, true);
		player.getSugar();
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if True is returned after the getCream() function has been called.
	 */
	@Test
	public void testGetCream() {
		player = new Player(true, false, true);
		player.getCream();
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if True is returned after the getCoffee() function has been called.
	 */
	@Test
	public void testGetCoffee() {
		player = new Player(true, true, false);
		player.getCoffee();
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if True is returned after the all items have been collected.
	 */
	@Test
	public void testHasAllItems() {
		player = new Player(true, true, true);
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if True is returned when the drink() function is called when Player has sugar,
	 * cream, and coffee.
	 */
	@Test
	public void testDrinkAll() {
		player = new Player(true, true, true);
		assertTrue(player.drink());		
	}
	
	/*
	 * Test to see if True is returned when the drink() function is called when Player has coffee.
	 */
	@Test
	public void testDrinkCoffee() {
		player = new Player();
		player.getCoffee();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if True is returned when the drink() function is called when Player has coffee
	 * and cream.
	 */
	@Test
	public void testDrinkCoffeeAndCream() {
		player = new Player();
		player.getCoffee();
		player.getCream();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if True is returned when the drink() function is called when Player has cream.
	 */
	@Test
	public void testDrinkCream() {
		player = new Player();
		player.getCream();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if True is returned when the drink() function is called when Player has cream
	 * and sugar.
	 */
	@Test
	public void testDrinkCreamAndSugar() {
		player = new Player();
		player.getCream();
		player.getSugar();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if True is returned when the drink() function is called when Player has sugar.
	 */
	@Test
	public void testDrinkSugar() {
		player = new Player();
		player.getSugar();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if False is returned when the drink() function is called when Player has no items.
	 */
	@Test
	public void testDrinkEmptyInventory() {
		player = new Player();
		assertFalse(player.drink());		
	}
}
