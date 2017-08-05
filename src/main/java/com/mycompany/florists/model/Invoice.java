package com.mycompany.florists.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The class creates invoices.
 *
 * @author Sławomir Kowalczyk
 */
public class Invoice extends ProofOfPurchase implements Serializable {

    /**
     *
     * @param shop This is the shop which issues invoices.
     * @param companyName Buyer company name.
     * @param street Street name.
     * @param houseNumber House number.
     * @param flatNumber Flat number.
     * @param town Town name.
     * @param postCode Post code.
     * @param post post name
     * @param nipNumber NIP identification number.
     */
    public Invoice(Shop shop, String companyName,
            String street, int houseNumber, int flatNumber, String town,
            String postCode, String post, String nipNumber) {
        this.inscription = shop.getName() + "\n";
        inscription += new Date() + "\n\n"
                + "Faktura\n"
                + "Nazwa firmy: " + companyName + "\n"
                + "Adres: " + street + " " + houseNumber + "/" + flatNumber + "\n"
                + town + "\n"
                + postCode + " " + post + "\n"
                + "NIP: " + nipNumber + "\n"
                + "Produkty:\n";
    }
}
