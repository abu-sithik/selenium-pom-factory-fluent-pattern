package com.cleartrip.casestudy.constants;

/**
 * Cites that can be used in tests for Origin and Destination.
 * <li>{@link #BANGALORE}<li/>
 * <li>{@link #Delhi}</li>
 */
public enum Cities {

    /**
     * Bangalore City
     */
    BANGALORE("Bangalore"),

    /**
     * Delhi City
     */
    Delhi("Delhi");

    /**
     * City to be used
     */
    private String city;

    /**
     * Instantiates a new City
     *
     * @param city Value of City
     */
    Cities(final String city) {
        this.city = city;
    }

    /**
     * Getter for City
     *
     * @return String representation of the city
     */
    public String getCity() {
        return city;
    }
}
