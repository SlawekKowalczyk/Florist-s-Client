package com.mycompany.florists.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * It is constructed as Singleton. It stores commodity prices.
 *
 * @author Sławomir Kowalczyk
 */
public class PriceList implements Serializable {

    /**
     * The map the key of which is the name of the commodity, and the value is
     * its price.
     */
    private Map<String, Double> priceList;

    /**
     * The private variable that stores of price list instance.
     */
    private static PriceList instance = new PriceList();

    /**
     * Creates an empty price list.
     */
    private PriceList() {
        priceList = new HashMap<>();
    }

    /**
     * The method returns price list instance.
     *
     * @return Returns price list instance.
     */
    public static PriceList getInstance() {
        return instance;
    }

    /**
     * The method takes the price of the product with the given name.
     *
     * @param name The product name the price of which we need to return.
     * @return Returns the price of the product with the given name.
     */
    public Double getPrice(String name) {
        return priceList.get(name);
    }

    /**
     * The method adds a product with the its name and price to the price list.
     *
     * @param name The product name to be added to the price list.
     * @param price The product price to be added to the price list.
     */
    public void setPrice(String name, double price) {
        priceList.put(name, price);
    }

    /**
     * The method empties the price list. The price list remains empty.
     */
    public void clear() {
        priceList.clear();
    }

    /**
     *
     * @return Returns a map containing the price list. The key is the name of
     * the commodity, and the value is its price.
     */
    public Map<String, Double> getPriceList() {
        return priceList;
    }

    /**
     *
     * @return Returns products number in price list.
     */
    public int getSize() {
        return priceList.size();
    }
}
