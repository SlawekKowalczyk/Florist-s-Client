package com.mycompany.tests.florists.model;

import com.mycompany.florists.model.PriceList;
import com.mycompany.florists.model.ProofOfPurchase;
import com.mycompany.florists.model.BussinesCustomer;
import com.mycompany.florists.model.IndividualCustomer;
import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.Shop;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.flowers.Gozdzik;
import com.mycompany.florists.model.flowers.Tulipan;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.florists.model.Customer;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class CustomerTest {

    @Test
    public void InvidualCustomerTest() {
        Shop shop = new Shop("Kwieciarnia");
        Customer invidualCustomer = new IndividualCustomer();

        Flower gozdzik = new Gozdzik(ColourName.Colours.ZOLTY);
        PriceList.getInstance().setPrice(gozdzik.getCatalogueDescription(), 5.5);
        invidualCustomer.add(gozdzik);

        Flower k1 = new Folia(gozdzik);
        k1 = new Rafia(k1);
        invidualCustomer.add(k1);

        PriceList.getInstance().setPrice("Folia", 2.0);
        PriceList.getInstance().setPrice("Rafia", 1.5);
        ProofOfPurchase receipt = shop.toCashBox(invidualCustomer);
        assertEquals("Nie zgadza się kwota paragonu", 14.5, receipt.getSum(), 0.001);

        String receiptReady = "Paragon\nProdukty:\nGozdzik ZOLTY\t5.5zł\nGozdzik ZOLTY Folia Rafia\t9.0zł\n";
        assertEquals("Paragon nie został prawidłowo wydrukowany", receiptReady, receipt.getInscription().split("\n\n")[1]);
    }

    @Test
    public void CompanyCustomerTest() {
        Shop shop = new Shop("Kwieciarnia");
        Customer companyCustomer = new BussinesCustomer("Moja Firma", "Szkolna", 15, 5, "Miasto", "12-123", "Poczta", "0123456789");
        Flower tulipan = new Tulipan(ColourName.Colours.FIOLETOWY);
        PriceList.getInstance().setPrice(tulipan.getCatalogueDescription(), 6.5);
        companyCustomer.add(tulipan);

        Flower k2 = new Siatka(tulipan);
        companyCustomer.add(k2);

        PriceList.getInstance().setPrice("Siatka", 1.5);
        ProofOfPurchase invoice = shop.toCashBox(companyCustomer);
        assertEquals("Nie zgadza się kwota na paragonie", 14.5, invoice.getSum(), 0.001);
    }
}
