package com.cleartrip.casestudy.constants;

/**
 * Wait Times that can be used anywhere a wait time constant is required.
 * <li>{@link #TIME_5_SECONDS}</li>
 */
public enum WaitTimes {

    /**
     * Wait time for 5 Seconds
     */
    TIME_5_SECONDS(5),

    /**
     * Wait time for 10 Seconds
     */
    TIME_10_SECONDS(10);

    /**
     * Wait Time that can be used
     */
    private int waitTime;

    /**
     * Instantiates a new WaitTime.
     * @param waitTime value of WaitTime
     */
    WaitTimes(final int waitTime) {
        this.waitTime = waitTime;
    }

    /**
     * Getter for WaitTime
     * @return Integer representation of the wait time
     */
    public int getWaitTime() {
        return waitTime;
    }
}
