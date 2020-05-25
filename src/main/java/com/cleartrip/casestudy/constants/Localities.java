package com.cleartrip.casestudy.constants;

/**
 * Localities that can be used.
 * <li>{@link #INDIRANAGAR_BANGALORE}</li>
 */
public enum Localities {

    /**
     * Indiranagar Locality
     */
    INDIRANAGAR_BANGALORE("Indiranagar, Bangalore");

    /**
     * Locality to be used
     */
    private String locality;

    /**
     * Instantiates a new locality
     *
     * @param locality Value of locality
     */
    Localities(final String locality) {
        this.locality = locality;
    }

    /**
     * Getter for Locality
     *
     * @return String representation of locality
     */
    public String getLocality() {
        return locality;
    }
}
