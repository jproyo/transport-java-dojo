package edu.jproyo.dojos.transjprs.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RouteTest {

	@Test
	public void testAsStringSuccess() {
		assertEquals("A", Route.as("AB5").get().getFrom());
		assertEquals("B", Route.as("AB5").get().getTo());
		assertEquals(new Integer(5), Route.as("AB5").get().getWeight());
	}
	
	@Test
	public void testAsStringSuccessWeightMoreThanOneDigit() {
		assertEquals("A", Route.as("AB56").get().getFrom());
		assertEquals("B", Route.as("AB57").get().getTo());
		assertEquals(new Integer(53), Route.as("AB53").get().getWeight());
	}

	@Test
	public void testAsStringFailOptionalEmpty() {
		assertFalse(Route.as("AB").isPresent());
		assertFalse(Route.as("A").isPresent());
		assertFalse(Route.as("52AB").isPresent());
		assertFalse(Route.as("ABAA5").isPresent());
		assertFalse(Route.as("ABb1").isPresent());
	}

}
