package edu.jproyo.dojos.transjprs.model;

/**
 * The Class Point.
 */
public class Point {

	/** The type. */
	private Type type;
	
	/** The stop. */
	private String stop;

	/**
	 * Start.
	 *
	 * @param start the start
	 * @return the point
	 */
	public static Point start(String start) {
		return create(start, Type.start);
	}
	

	/**
	 * Finish.
	 *
	 * @param finish the finish
	 * @return the point
	 */
	public static Point finish(String finish) {
		return create(finish, Type.finish);
	}


	/**
	 * Creates the.
	 *
	 * @param stop the stop
	 * @param type the type
	 * @return the point
	 */
	private static Point create(String stop, Type type) {
		Point point = new Point();
		point.setStop(stop);
		point.setType(type);
		return point;
	}

	/**
	 * Sets the type.
	 *
	 * @param start the new type
	 */
	public void setType(Type start) {
		this.type = start;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the stop.
	 *
	 * @param start the new stop
	 */
	public void setStop(String start) {
		this.stop = start;
	}
	
	/**
	 * Gets the stop.
	 *
	 * @return the stop
	 */
	public String getStop() {
		return stop;
	}

	/**
	 * The Enum Type.
	 */
	public enum Type {
		
		/** The start. */
		start,
		
		/** The finish. */
		finish
	
	}


}
