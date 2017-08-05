package com.mycompany.florists.model.accessories;

import com.mycompany.florists.model.FlowerAccessories;
import java.io.Serializable;
import com.mycompany.florists.model.Flower;

/**
 * Represents flower accessory.
 *
 * @author Sławomir Kowalczyk
 */
public class Rafia extends FlowerAccessories implements Serializable {

    /**
     * Equips a flower with Rafia accessory.
     *
     * @param flower A flower to be decorated.
     */
    public Rafia(Flower flower) {
        super(flower);
    }

    /**
     *
     * @return Returns String describing the flower object decoration.
     */
    @Override
    public String getAccessories() {
        return flower.getAccessories() + " Rafia";
    }
}
