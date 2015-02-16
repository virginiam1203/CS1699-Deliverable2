package com.laboon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {
	private CoffeeMaker coffeeMaker;
	
	private ByteArrayOutputStream outputStream;
	private ByteArrayOutputStream errorOutputStream;

	/*
	 * This function initializes a new CoffeeMaker instance before each test is run.
	 */
	@Before
	public void setUp() {
		coffeeMaker = new CoffeeMaker();
	}
	
	/*
	 * Test to see if the actual text outputted to the console matches the expected text when
	 * "deliverable2" is passed to the runArgs(String arg) function.
	 */
	@Test
	public void testRunArgsOutputStream() {
		outputStream = new ByteArrayOutputStream();
		errorOutputStream = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outputStream));
		System.setErr(new PrintStream(errorOutputStream));
		
		coffeeMaker.runArgs("deliverable2");
		assertTrue(outputStream.toString().contains("Instructions for Coffee Maker Quest - "));
		assertTrue(outputStream.toString().contains("You are a brave student trying to study for"
				+ " finals, but you need caffeine."));
		assertTrue(outputStream.toString().contains("The goal of the game is to collect sugar,"
				+ " coffee, and cream so that you can study."));
		
		System.setOut(null);
		System.setErr(null);
	}
	
	/*
	 * Test to see if 0 is returned when "deliverable2" is passed to the runArgs(String arg)
	 * function.
	 */
	@Test
	public void testRunArgsReturnValue() {
		assertEquals(0, coffeeMaker.runArgs("deliverable2"));
	}
}
