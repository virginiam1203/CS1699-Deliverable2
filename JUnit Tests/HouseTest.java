package com.laboon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class HouseTest {
	private Room[] rooms;
	private House house;
	
	/*
	 * This function initializes a new House instance that has three mock Rooms before each test is run.
	 * The first mock Room will have the description Room1, the second mock Room will have the 
	 * description Room2, and the third mock Room will have the description Room3.
	 */
	@Before
	public void setUp() {
		rooms = new Room[3];
		rooms[0] = mock(Room.class);
		rooms[1] = mock(Room.class);
		rooms[2] = mock(Room.class);
		when(rooms[0].getDescription()).thenReturn("Room1");
		when(rooms[1].getDescription()).thenReturn("Room2");
		when(rooms[2].getDescription()).thenReturn("Room3");
		house = new House(rooms);
	}
	
	/*
	 * Test to see if a non-null value is returned when 6 is passed to the House(int numRooms) constructor.
	 */
	@Test
	public void testHouseConstructorNumRooms() {
		House house = null;
		house = new House(6);
		assertNotNull(house);
	}
	
	/*
	 * Test to see if a non-null value is returned when rooms is passed to the House(Room[] rooms) constructor.
	 */
	@Test
	public void testHouseConstructorRooms() {
		House house = null;
		house = new House(rooms);
		assertNotNull(house);
	}
	
	/*
	 * Test to see if "Room1" is returned when getCurrentRoomInfo() function is called on the first room.
	 */
	@Test
	public void testGetRoom1Info() {
		assertEquals("Room1", house.getCurrentRoomInfo());
	}
	
	/*
	 * Test to see if "Room2" is returned when getCurrentRoomInfo() function is called on the second room.
	 */
	@Test
	public void testGetRoom2Info() {
		house.moveNorth();
		assertEquals("Room2", house.getCurrentRoomInfo());
	}
	
	/*
	 * Test to see if "Room3" is returned when getCurrentRoomInfo() function is called on the third room.
	 */
	@Test
	public void testGetRoom3Info() {
		house.moveNorth();
		house.moveNorth();
		assertEquals("Room3", house.getCurrentRoomInfo());
	}
	
	/*
	 * Test to see if "You are in a magical land!  But you are returned to the beginning!" is returned when
	 * getCurrentRoomInfo() function is called on the room South of the first room.
	 * FUN-MOVE - The system shall allow a player to move North only if a door exists going North, and South 
	 * only if a door exists going South. DEFECT FOUND!
	 * 
	 */
	@Test
	public void testOutOfBoundsSouth() {
		house.moveSouth();
		assertEquals("You are in a magical land!  But you are returned to the beginning!", house.getCurrentRoomInfo());
	}
	
	/*
	 * Test to see if "You are in a magical land!  But you are returned to the beginning!" is returned when
	 * getCurrentRoomInfo() function is called on the room North of the third room.
	 * FUN-MOVE - The system shall allow a player to move North only if a door exists going North, and South 
	 * only if a door exists going South. DEFECT FOUND!
	 */
	@Test
	public void testOutOfBoundsNorth() {
		house.moveNorth();
		house.moveNorth();
		house.moveNorth();
		assertEquals("You are in a magical land!  But you are returned to the beginning!", house.getCurrentRoomInfo());
	}
	
	/*
	 * Test to see if the Player is able to find coffee.
	 */
	@Test
	public void testLookGetCoffee() {
		Player mockPlayer = mock(Player.class);
		Room mockRoom = mock(Room.class);
		when(mockRoom.hasItem()).thenReturn(true);
		when(mockRoom.hasCoffee()).thenReturn(true);
		house.look(mockPlayer, mockRoom);
		verify(mockPlayer).getCoffee();
	}
	
	/*
	 * Test to see if the Player is able to find cream.
	 */
	@Test
	public void testLookGetCream() {
		Player mockPlayer = mock(Player.class);
		Room mockRoom = mock(Room.class);	
		when(mockRoom.hasItem()).thenReturn(true);
		when(mockRoom.hasCream()).thenReturn(true);
		house.look(mockPlayer, mockRoom);
		verify(mockPlayer).getCream();
	}
	
	/*
	 * Test to see if the Player is able to find sugar.
	 */
	@Test
	public void testLookGetSugar() {
		Player mockPlayer = mock(Player.class);
		Room mockRoom = mock(Room.class);	
		when(mockRoom.hasItem()).thenReturn(true);
		when(mockRoom.hasSugar()).thenReturn(true);
		house.look(mockPlayer, mockRoom);
		verify(mockPlayer).getSugar();
	}
	
	/*
	 * Test to see if a non-null value is returned when 6 is passed to the generateRooms(int numRooms) function.
	 */
	@Test
	public void testGenerateRooms() {
		Room[] rooms = null;
		rooms = house.generateRooms(6);
		assertNotNull(rooms);
	}
}