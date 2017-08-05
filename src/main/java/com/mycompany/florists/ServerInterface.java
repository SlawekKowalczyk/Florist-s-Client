package com.mycompany.florists;

import com.mycompany.florists.model.PriceList;
import com.mycompany.florists.model.ProofOfPurchase;
import com.mycompany.florists.model.Customer;

/**
 * Interface for server needs.
 *
 * @author Sławomir Kowalczyk
 */
public interface ServerInterface {

    /**
     * The method responsible for connecting the server.
     */
    void connect();

    /**
     * The method responsible for disconnecting the server.
     */
    void disconnect();

    /**
     *
     * @return Returns the price list of the articles in the shop.
     */
    PriceList getPriceList();

    /**
     *
     * @param customer The shop customer.
     * @return Returns a proof of purchase.
     */
    ProofOfPurchase getReceiptInvoice(Customer customer);
}
