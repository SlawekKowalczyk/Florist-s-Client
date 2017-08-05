package com.mycompany.florists.model;

import java.util.List;

/**
 *
 * @author Sławomir Kowalczyk
 */
public interface Customer {

    /**
     * The method adds a flower to a current customer.
     *
     * @param flower A flower to be added.
     */
    public void add(Flower flower);

    /**
     *
     * @return Returns the flower list that the customer purchased.
     */
    public List<Flower> getList();

    /**
     * The method empties the cart.
     */
    public void clear();

}
