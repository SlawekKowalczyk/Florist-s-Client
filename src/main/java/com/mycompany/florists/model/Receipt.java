package com.mycompany.florists.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The class creates receipt.
 *
 * @author Sławomir Kowalczyk
 */
public class Receipt extends ProofOfPurchase implements Serializable {

    /**
     * Creates a receipt related to the shop instance.
     *
     * @param shop The shop which issues the receipt.
     */
    public Receipt(Shop shop) {
        this.inscription = shop.getName() + "\n";
        inscription += new Date() + "\n\n"
                + "Paragon\n"
                + "Produkty:\n";
    }
}
