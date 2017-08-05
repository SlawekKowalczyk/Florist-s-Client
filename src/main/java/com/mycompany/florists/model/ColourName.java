package com.mycompany.florists.model;

import java.io.Serializable;

/**
 * Base class for objects with name and colour.
 *
 * @author Sławomir Kowalczyk
 */
public abstract class ColourName implements Serializable {

    /**
     * Available colours.
     */
    public enum Colours {
        BIALY, CZERWONY, ZIELONY, NIEBIESKI, ZOLTY, FIOLETOWY, ROZOWY
    }
    /**
     * Object name.
     */
    protected String name;
    /**
     * Object colour.
     */
    protected Colours colour;

    /**
     *
     * @param name Object name.
     * @param colour Object colour.
     */
    public ColourName(String name, Colours colour) {
        this.name = name;
        this.colour = colour;
    }
}
