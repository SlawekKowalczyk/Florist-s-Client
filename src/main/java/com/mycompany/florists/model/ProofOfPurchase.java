package com.mycompany.florists.model;

import java.io.Serializable;

/**
 * The abstract class creates proof of purchases.
 *
 * @author Sławomir Kowalczyk
 */
public abstract class ProofOfPurchase implements Serializable {

    /**
     * The variable specifies the content of the proof of purchase.
     */
    protected String inscription;

    /**
     * The variable specifies the purchase value.
     */
    protected double sum;

    /**
     * Adds a single flower to the proof of purchase.
     *
     * @param flower The flower to be added to the proof of purchase.
     */
    public void addArticle(Flower flower) {
        double sum = PriceList.getInstance().getPrice(flower.getCatalogueDescription());
        String accessories = flower.getAccessories();
        String[] array = accessories.split(" ");
        for (int i = 1; i < array.length; i++) {
            sum += PriceList.getInstance().getPrice(array[i]);
        }
        inscription += flower.getDescription() + "\t" + sum + "zł\n";
        this.sum += sum;
    }

    /**
     *
     * @return Returns the content of the proof of purchase.
     */
    public String getInscription() {
        return inscription;
    }

    /**
     *
     * @return Returns the value of all purchases added to the proof of
     * purchase.
     */
    public double getSum() {
        return sum;
    }
}
