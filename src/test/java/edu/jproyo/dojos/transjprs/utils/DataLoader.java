package edu.jproyo.dojos.transjprs.utils;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import edu.jproyo.dojos.transjprs.model.Route;

public class DataLoader {
	
	/**
	 * Default routes.
	 *
	 * @return the sets the
	 */
	public static Set<Route> defaultRoutes() {
		Set<Route> routes = new LinkedHashSet<>();
		String routesUnparsed = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
		Arrays.stream(routesUnparsed.split(",")).forEach(c -> routes.add(Route.as(c).orElseThrow(() -> new RuntimeException("Error parsing value "+c))));
		return routes;
	}

}
