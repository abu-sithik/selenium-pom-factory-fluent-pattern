package com.cleartrip.casestudy.constants;

/**
 * Indices that can be substituted where an index is substituted.
 * <li>{@link #INDEX_0}</li>
 * <li>{@link #INDEX_1}</li>
 */
public enum Indices {

    /**
     * Index 0
     */
    INDEX_0(0),

    /**
     * Index 1
     */
    INDEX_1(1);

    /**
     * Index to be used
     */
    private int index;

    /**
     * Instantiates a new Index
     *
     * @param index Value of Index
     */
    Indices(final int index) {
        this.index = index;
    }

    /**
     * Getter for Index Value
     *
     * @return Int representation of the Index
     */
    public int getIndexValue() {
        return index;
    }
}
