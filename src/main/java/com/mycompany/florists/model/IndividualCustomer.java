package com.mycompany.florists.model;

import java.io.Serializable;
import java.util.List;

/**
 * The class describing individual customer who a receipt is issued for.
 *
 * @author Sławomir Kowalczyk
 */
public class IndividualCustomer implements Customer, Serializable {

    /**
     * The cart where the customer's flowers are stored.
     */
    private Cart cart;

    /**
     *
     * Creates a customer with an empty cart.
     */
    public IndividualCustomer() {
        cart = new Cart();
    }

    /**
     * The method adds flower object to cart.
     *
     * @param flower A flower to be added to the cart.
     */
    @Override
    public void add(Flower flower) {
        cart.add(flower);
    }

    /**
     *
     * @return Returns the list of added flowers.
     */
    @Override
    public List<Flower> getList() {
        return cart.getLista();
    }

    /**
     * The method empties the cart. The cart remains empty.
     */
    @Override
    public void clear() {
        cart.clear();
    }
}
