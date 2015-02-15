package com.laboon;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private Player player;
	
	/*
	 * This function is called before each test is run. Initialize player instance to null.
	 */
	@Before
	public void setUp() {
		player = null;
	}
	
	/*
	 * This function is called after each test is run.
	 */
	@After
	public void tearDown() {}
	
	/*
	 * Test to see if a non-null value is returned when Player() constructor is called.
	 */
	@Test
	public void testPlayerConstructorNoParameters() {
		player = null;
		assertNotNull(player = new Player());
	}
	
	/*
	 * Test to see if a non-null value is returned when Player(boolean sugar, boolean 
	 * cream, boolean coffee) constructor is called.
	 */
	@Test
	public void testPlayerConstructorYesParameters() {
		player = null;
		assertNotNull(player = new Player(true, true, true));
	}
	
	/*
	 * Test to see if getSugar() function works.
	 */
	@Test
	public void testGetSugar() {
		player = new Player(false, true, true);
		player.getSugar();
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if getCream() function works.
	 */
	@Test
	public void testGetCream() {
		player = new Player(true, false, true);
		player.getCream();
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if getCoffee() function works.
	 */
	@Test
	public void testGetCoffee() {
		player = new Player(true, true, false);
		player.getCoffee();
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if hasAllItems() function works.
	 */
	@Test
	public void testHasAllItems() {
		player = new Player(true, true, true);
		assertTrue(player.hasAllItems());
	}
	
	/*
	 * Test to see if True is returned when drink() function is called when Player has Sugar,
	 * Cream, and coffee.
	 */
	@Test
	public void testDrinkAll() {
		player = new Player(true, true, true);
		assertTrue(player.drink());		
	}
	
	/*
	 * Test to see if False is returned when drink() function is called when Player has Coffee
	 */
	@Test
	public void testDrinkCoffee() {
		player = new Player();
		player.getCoffee();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if False is returned when drink() function is called when Player has Coffee
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
	 * Test to see if False is returned when drink() function is called when Player has cream.
	 */
	@Test
	public void testDrinkCream() {
		player = new Player();
		player.getCream();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if False is returned when drink() function is called when Player has Cream
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
	 * Test to see if False is returned when drink() function is called when Player has sugar.
	 */
	@Test
	public void testDrinkSugar() {
		player = new Player();
		player.getSugar();
		assertFalse(player.drink());		
	}
	
	/*
	 * Test to see if False is returned when drink() function is called when Player has no items.
	 */
	@Test
	public void testDrinkEmptyInventory() {
		player = new Player();
		assertFalse(player.drink());		
	}
}
