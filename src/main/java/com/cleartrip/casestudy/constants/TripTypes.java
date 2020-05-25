package com.cleartrip.casestudy.constants;

/**
 * Trip Types that can be used when searching for fights.
 * <li>{@link #ONE_WAY}</li>
 * <li>{@link #ROUND_TRIP}</li>
 * <li>{@link #MULTI_CITY}</li>
 */
public enum TripTypes {

    /**
     * One Way trip
     */
    ONE_WAY("OneWay"),

    /**
     * Round Trip
     */
    ROUND_TRIP("RoundTrip"),

    /**
     * Multi-city trip
     */
    MULTI_CITY("MultiCity");

    /**
     * Trip Type that can be used
     */
    private String tripType;

    /**
     * Instantiates a new TripType
     *
     * @param tripType Value of Trip Type
     */
    TripTypes(final String tripType) {
        this.tripType = tripType;
    }

    /**
     * Getter for Trip Type
     *
     * @return String representation of the value attribute of Trip Type
     */
    public String getTripType() {
        return tripType;
    }
}
