package com.laboon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Player mockPlayer;
	private House mockHouse;
	private Game game;
	
	/*
	 * This function initializes a new Game instance before each test is run. The
	 * Game instance is initialized with a mock Player and a mock House.
	 */
	@Before
	public void setUp() {
		mockPlayer = mock(Player.class);
		mockHouse = mock(House.class);
		game = new Game(mockPlayer, mockHouse);
	}
	
	/*
	 * Test to see if the Game constructor returns a non-null value.
	 */
	@Test 
	public void testGameConstructor() {
		game = null;
		game = new Game(mockPlayer, mockHouse);
		assertNotNull(game);
	}
	
	/*
	 * Test to see if the House moves North when "n" is passed to the Game.
	 * FUN-INPUT-CAPS - The system shall be case-insensitive in regards to input 
	 * values; that is, it shall accept capital and lower-case letters and treat 
	 * them as equivalent. DEFECT FOUND!
	 */
	@Test
	public void testMoveNorthLower() {
		game.doSomething("n");
		verify(mockHouse).moveNorth();
	}
	
	/*
	 * Test to see if the House moves North when "N" is passed to the Game.
	 */
	@Test
	public void testMoveNorthUpper() {
		game.doSomething("N");
		verify(mockHouse).moveNorth();
	}
	
	/*
	 * Test to see if the House moves South when "s" is passed to the Game.
	 */
	@Test
	public void testMoveSouthLower() {
		game.doSomething("s");
		verify(mockHouse).moveSouth();
	}
	
	/*
	 * Test to see if the House moves South when "S" is passed to the Game.
	 */
	@Test
	public void testMoveSouthUpper() {
		game.doSomething("S");
		verify(mockHouse).moveSouth();
	}
	
	/*
	 * Test to see if the House looks when "L" is passed to the Game.
	 */
	@Test
	public void testLook() {
		game.doSomething("L");
		verify(mockHouse).look(mockPlayer, null);
	}
	
	/*
	 * Test to see if the Player shows inventory when "I" is passed to the Game.
	 */
	@Test
	public void testShowInventory() {
		game.doSomething("I");
		verify(mockPlayer).showInventory();
	}
	
	/*
	 * Test to see if the help menu is shown when a user sends the command "H".
	 * FUN-ITERATION - At each iteration of the game, the user shall be able enter 
	 * one of six commands - "N" to go North, "S" to go South, "L" to Look for items, 
	 * "I" for Inventory, "H" for Help, or "D" to Drink. DEFECT FOUND!
	 */
	@Test
	public void testShowMenu() {
		fail("Non-programmed help menu in Game.java prevents this method from being tested!");
		// game.doSomething("H");
		// verify(mockPlayer).showMenu();
	}
	
	/*
	 * Test to see if the Player drinks when "D" is passed to the Game.
	 */
	@Test
	public void testDrink() {
		game.doSomething("D");
		verify(mockPlayer).drink();
	}
	
	/*
	 * Test to see if 0 is returned when "N" is passed to the Game.
	 */
	@Test
	public void testMoveNorthReturnValue() {
		assertEquals(0, game.doSomething("N"));
	}
	
	/*
	 * Test to see if 0 is returned when "S" is passed to the Game.
	 */
	@Test
	public void testMoveSouthReturnValue() {
		assertEquals(0, game.doSomething("S"));
	}
	
	/*
	 * Test to see if 0 is returned when "L" is passed to the Game.
	 */
	@Test
	public void testLookReturnValue() {
		assertEquals(0, game.doSomething("L"));
	}
	
	/*
	 * Test to see if 0 is returned when "I" is passed to the Game.
	 */
	@Test
	public void testShowInventoryReturnValue() {
		assertEquals(0, game.doSomething("I"));
	}
	
	/*
	 * Test to see if -1 is returned when "D" is passed to the Game and the Player inventory is empty.
	 */
	@Test
	public void testDrinkEmptyInventoryReturnValue() {
		when(mockPlayer.drink()).thenReturn(false);
		assertEquals(-1, game.doSomething("D"));
	}
	
	/*
	 * Test to see if 1 is returned when "D" is passed to the Game and the Player inventory is full.
	 */
	@Test
	public void testDrinkFullInventoryReturnValue() {
		when(mockPlayer.drink()).thenReturn(true);
		assertEquals(1, game.doSomething("D"));
	}
	
	/*
	 * Test to see if 0 is returned when a non-valid command is passed to the Game.
	 */
	@Test
	public void testInvalidCommand() {
		assertEquals(0, game.doSomething("deliverable2"));
	}
	
	/*
	 * Test to see if 0 is returned when a Player loses the game.
	 */
	@Test
	public void testRunWin() {
		fail("Scanner initialization on line 41 of Game.java prevents this method from being tested!");
		// when(mockPlayer.drink()).thenReturn(true);
		// assertEquals(0, game.run());
	}
	
	/*
	 * Test to see if 1 is returned when a Player wins the game.
	 */
	@Test
	public void testRunLose() {
		fail("Scanner initialization on line 41 of Game.java prevents this method from being tested!");
		// when(mockPlayer.drink()).thenReturn(false);
		// assertEquals(1, game.run());
	}
}
