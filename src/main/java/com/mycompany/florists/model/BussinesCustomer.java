package com.mycompany.florists.model;

import java.io.Serializable;
import java.util.List;

/**
 * The class describing bussines customer who is being invoiced.
 *
 * @author Sławomir Kowalczyk
 */
public class BussinesCustomer implements Customer, Serializable {

    /**
     * The cart where the customer's flowers are stored.
     */
    private Cart cart;
    private String companyName, street, town, postCode, post, nipNumber;
    private int houseNumber, flatNumber;

    /**
     * Creates a customer with an empty shop cart.
     *
     * @param companyName Company name.
     * @param street Street Name.
     * @param houseNumber House number.
     * @param flatNumber Flat number.
     * @param town Town name.
     * @param postCode Post code.
     * @param post Post name.
     * @param nipNumber Nip number.
     */
    public BussinesCustomer(String companyName, String street,
            int houseNumber, int flatNumber, String town,
            String postCode, String post, String nipNumber) {
        cart = new Cart();
        this.companyName = companyName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.town = town;
        this.postCode = postCode;
        this.post = post;
        this.nipNumber = nipNumber;
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
     *
     * @return Returns company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * The method takes String and sets it as the company name.
     *
     * @param companyName Company name.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     * @return Returns street name.
     */
    public String getStreet() {
        return street;
    }

    /**
     * The method takes String and sets it as the street name.
     *
     * @param street Street Name.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return Return house number.
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * The method takes int and sets it as the house number.
     *
     * @param houseNumber House number.
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     *
     * @return Return flat number.
     */
    public int getFlatNumber() {
        return flatNumber;
    }

    /**
     * The method takes int and sets it as the flat number.
     *
     * @param flatNumber Flat number.
     */
    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    /**
     *
     * @return Return town name.
     */
    public String getTown() {
        return town;
    }

    /**
     * The method takes String and sets it as the town name.
     *
     * @param town Town name.
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     *
     * @return Return post code.
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * The method takes String and sets it as the post code.
     *
     * @param postCode Post code.
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     *
     * @return Return post name.
     */
    public String getPost() {
        return post;
    }

    /**
     * The method takes String and sets it as the post office name.
     *
     * @param post Post name.
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     *
     * @return Return NIP number.
     */
    public String getNipNumber() {
        return nipNumber;
    }

    /**
     * The method takes String and sets it as the NIP number.
     *
     * @param nipNumber NIP number.
     */
    public void setNipNumber(String nipNumber) {
        this.nipNumber = nipNumber;
    }

    /**
     * The method empties the cart. The cart remains empty.
     */
    @Override
    public void clear() {
        cart.clear();
    }
}
