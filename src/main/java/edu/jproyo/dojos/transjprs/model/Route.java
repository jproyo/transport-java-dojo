package edu.jproyo.dojos.transjprs.model;

import java.util.Optional;

/**
 * The Class Route.
 */
public class Route {
	
	/** The from. */
	private String from;
	
	/** The to. */
	private String to;
	
	/** The weight. */
	private Integer weight;

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 *
	 * @param to the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
	/**
	 * As.
	 *
	 * @param from the from
	 * @param to the to
	 * @param weight the weight
	 * @return the route
	 */
	public static Route as(String from, String to, Integer weight){
		Route route = new Route();
		route.setFrom(from);
		route.setTo(to);
		route.setWeight(weight);
		return route;
	}

	/**
	 * As.
	 *
	 * @param joined the joined
	 * @return the optional
	 */
	public static Optional<Route> as(String joined) {
		return Optional.ofNullable(joined)
			.flatMap(Route::validate)
			.flatMap(Route::split);
	}
	
	/**
	 * Split.
	 *
	 * @param joined the joined
	 * @return the optional
	 */
	private static Optional<String> validate(String joined){
		if(joined.isEmpty() || joined.length() < 3){
			return Optional.empty();
		}else{
			return Optional.ofNullable(joined);
		}
	}
	
	/**
	 * Split.
	 *
	 * @param joined the joined
	 * @return the optional
	 */
	private static Optional<Route> split(String joined){
		char[] charArray = joined.toCharArray();
		char fromChar = charArray[0];
		if(!Character.isLetter(fromChar)) return Optional.empty();
		char toChar = charArray[1];
		if(!Character.isLetter(toChar)) return Optional.empty();
		String from = Character.toString(fromChar);
		String to = Character.toString(toChar);
		Integer weight = null;
		try {
			weight = Integer.parseInt(joined.substring(2, joined.length()));
		} catch (NumberFormatException e) {	
			return Optional.empty();
		}
		return Optional.ofNullable(Route.as(from, to, weight));
	}

}
