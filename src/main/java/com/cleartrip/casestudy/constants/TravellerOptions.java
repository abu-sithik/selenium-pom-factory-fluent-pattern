package com.cleartrip.casestudy.constants;

/**
 * Traveller Options that can be used for selecting the traveller option type when searching hotels.
 * <li>{@link #ROOM_1_ADULT_1}</li>
 * <li>{@link #ROOM_1_ADULT_2}</li>
 * <li>{@link #ROOM_2_ADULT_4}</li>
 * <li>{@link #OTHER}</li>
 */
public enum TravellerOptions {

    /**
     * One room and an adult
     */
    ROOM_1_ADULT_1("1 room, 1 adult"),

    /**
     * One room and two adults
     */
    ROOM_1_ADULT_2("1 room, 2 adults"),

    /**
     * Two rooms and 4 adults
     */
    ROOM_2_ADULT_4("2 rooms, 4 adults"),

    /**
     * More Options
     */
    OTHER("More travellers...");

    /**
     * Travel option to be used
     */
    private String travellerOption;

    /**
     * Instantiates a new TravellerOption
     *
     * @param travellerOption Value of Traveller option
     */
    TravellerOptions(final String travellerOption) {
        this.travellerOption = travellerOption;
    }

    /**
     * Getter for traveller option
     *
     * @return String Representation of traveller option
     */
    public String getTravellerOption() {
        return travellerOption;
    }
}
