package com.mycompany.florists.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class responsible for storing purchased articles.
 *
 * @author Sławomir Kowalczyk
 */
public class Cart implements Serializable {

    /**
     * The cart for purchased flowers.
     */
    private List<Flower> cart;

    /**
     * Creates an empty cart.
     */
    public Cart() {
        cart = new ArrayList<>();
    }

    /**
     * Adds a flower to the cart.
     *
     * @param flower A flower to be added.
     */
    public void add(Flower flower) {
        cart.add(flower);
    }

    /**
     *
     * @return Returns a flower list in the cart.
     */
    public List<Flower> getLista() {
        return cart;
    }

    /**
     * Empties the cart. The cart remains empty.
     */
    public void clear() {
        cart.clear();
    }
}
