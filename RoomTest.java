package com.laboon;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoomTest {
	private Room room;
	
	/*
	 * This function is called before each test is run. Initialize room instance to null.
	 */
	@Before
	public void setUp() {
		room = null;
	}
	
	/*
	 * This function is called after each test is run.
	 */
	@After
	public void tearDown() {}
	
	/*
	 * Test to see if True is returned when hasItem() function is called when Room has Coffee,
	 * cream, and sugar.
	 */
	@Test
	public void testHasItem() {
		room = new Room(true, true, true, true, true);
		assertTrue(room.hasItem());
	}
	
	/*
	 * Test to see if False is returned when hasItem() function is called when Room no items.
	 */
	@Test
	public void testHasNoItems() {
		room = new Room(false, false, false, false, false);
		assertFalse(room.hasItem());
	}
	
	/*
	 * Test to see if True is returned when hasSugar() function is called when Room has Sugar.
	 */
	@Test
	public void testHasSugar() {
		room = new Room(false, false, true, false, false);
		assertTrue(room.hasSugar());
	}
	
	/*
	 * Test to see if True is returned when hasCream() function is called when Room has Cream.
	 */
	@Test
	public void testHasCream() {
		room = new Room(false, true, false, false, false);
		assertTrue(room.hasCream());
	}
	
	/*
	 * Test to see if True is returned when hasCoffee() function is called when Room has coffee.
	 */
	@Test
	public void testHasCoffee() {
		room = new Room(true, false, false, false, false);
		assertTrue(room.hasCoffee());
	}

	/*
	 * Test to see if True is returned when northExit() function is called when Room has a North Exit.
	 */
	@Test
	public void testHasNorthExit() {
		room = new Room(false, false, false, true, false);
		assertTrue(room.northExit());
	}
	
	/*
	 * Test to see if True is returned when southExit() function is called when Room has a South Exit.
	 */
	@Test
	public void testHasSouthExit() {
		room = new Room(false, false, false, false, true);
		assertTrue(room.southExit());
	}
	
	/*
	 * Test to see if True is returned when getDescription() function is called.
	 */
	@Test
	public void testGetDescription() {
		room = new Room(false, false, false, false, false);
		assertTrue(room.getDescription().contains("You see a"));
		assertTrue(room.getDescription().contains("It has a"));
	}
}
