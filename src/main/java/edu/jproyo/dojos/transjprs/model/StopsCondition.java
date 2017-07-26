package edu.jproyo.dojos.transjprs.model;

/**
 * The Class Stops.
 */
public class StopsCondition {

	/** The exactly. */
	private Integer stops;
	
	/** The condition. */
	private Type condition;

	/**
	 * At least.
	 *
	 * @param stop the stop
	 * @return the stops
	 */
	public static StopsCondition atLeast(Integer stop) {
		return create(stop, Type.atLeast);
	}

	/**
	 * Exactly.
	 *
	 * @param stop the stop
	 * @return the stops
	 */
	public static StopsCondition exactly(Integer stop) {
		return create(stop, Type.exactly);
	}
	
	/**
	 * Distance less.
	 *
	 * @param stops the stops
	 * @return the stops
	 */
	public static StopsCondition distanceLess(Integer stops) {
		return create(stops, Type.distanceLessThan);
	}

	/**
	 * Creates the.
	 *
	 * @param stop the stop
	 * @param type the type
	 * @return the stops condition
	 */
	private static StopsCondition create(Integer stop, Type type) {
		StopsCondition stops = new StopsCondition();
		stops.setStops(stop);
		stops.setCondition(type);
		return stops;
	}

	/**
	 * Gets the stops.
	 *
	 * @return the stops
	 */
	public Integer getStops() {
		return stops;
	}

	/**
	 * Sets the stops.
	 *
	 * @param stops the new stops
	 */
	public void setStops(Integer stops) {
		this.stops = stops;
	}

	/**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
	public Type getCondition() {
		return condition;
	}

	/**
	 * Sets the condition.
	 *
	 * @param condition the new condition
	 */
	public void setCondition(Type condition) {
		this.condition = condition;
	}

	/**
	 * The Enum Type.
	 */
	public enum Type {
		
		/** The at least. */
		atLeast,
		
		/** The exactly. */
		exactly,
		
		/** The distance less than. */
		distanceLessThan
	}

	/**
	 * Filter condition.
	 *
	 * @param stops the stops
	 * @return true, if successful
	 */
	public boolean applyCondition(Integer stops) {
		switch (condition) {
		case atLeast:
			return stops >= this.stops;
		case distanceLessThan:
			return stops < this.stops;
		case exactly:
			return stops.equals(this.stops);
		}
		return false;
	}
	
	
}
