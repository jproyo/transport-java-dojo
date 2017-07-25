package edu.jproyo.dojos.transjprs.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RoutePathTest {
	
	private RoutePath target;
	
	@Before
	public void setup(){
		target = new RoutePath();
	}

	@Test
	public void testGetSegments() {
		target.getRoutePath().addAll(Arrays.asList(new String[]{"A","B","C"}));
		Optional<Set<Route>> segments = target.getSegments();
		assertTrue(segments.isPresent());
		Iterator<Route> iterator = segments.get().iterator();
		assertEquals(Route.as("A","B",null), iterator.next());
		assertEquals(Route.as("B","C",null), iterator.next());
		assertFalse(iterator.hasNext());
	}

}
