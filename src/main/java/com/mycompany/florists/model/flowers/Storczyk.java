package com.mycompany.florists.model.flowers;

import com.mycompany.florists.model.ColourName;
import java.io.Serializable;
import com.mycompany.florists.model.Flower;

/**
 * Storczyk represents a flower.
 *
 * @author Sławomir Kowalczyk
 */
public class Storczyk extends ColourName implements Flower, Serializable {

    /**
     *
     * @param colour The colour of the flower being created.
     */
    public Storczyk(Colours colour) {
        super("Storczyk", colour);
    }

    /**
     *
     * @return Returns flower catalogue description composed of a name and a
     * colour.
     */
    @Override
    public String getCatalogueDescription() {
        return name + " " + colour;
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
