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

}
