package com.mycompany.florists.model;

import java.io.Serializable;

/**
 * Interface created to decorate flowers.
 *
 * @author Sławomir Kowalczyk
 */
public abstract class FlowerAccessories implements Flower, Serializable {

    /**
     * A reference to the flower to be decorated with a suitable decorator.
     */
    protected Flower flower;

    /**
     * Decorates a flower with a suitable decorator.
     *
     * @param flower A flower to be decorated.
     */
    public FlowerAccessories(Flower flower) {
        this.flower = flower;
    }

    /**
     *
     * @return Returns catalogue description of flower object.
     */
    @Override
    public String getCatalogueDescription() {
        return flower.getCatalogueDescription();
    }

    /**
     *
     * @return Returns catalogue description together with decorative
     * accessories.
     */
    @Override
    public String getDescription() {
        return getCatalogueDescription() + getAccessories();
    }
}
