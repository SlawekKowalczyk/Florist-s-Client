package com.mycompany.florists.model;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for creating new flower objects.
 *
 * @author Sławomir Kowalczyk
 */
public class FactoryFlyweight implements Serializable {

    /**
     * A map that keeps flower objects as values while key is catalogue
     * description. Flowers of the same type and colour cannot be repeated.
     */
    private static Map<String, Flower> map = new HashMap<>();

    /**
     * Responsible for creating new flower objects. Searches map contents with
     * existing objects, if there is not the one in question, it creates a new
     * object, if there is the one-returns existing flower object.
     *
     * @param name Flower name.
     * @param colour Flower colour.
     * @return Returns instance of flower class. In case of duplication it
     * returns already existing flower. If there is not a class describing the
     * flower, null will be returned.
     */
    public static Flower factoryFlyweight(String name, ColourName.Colours colour) {
        String catalogueDescription = name + " " + colour;
        Flower flowerr = map.get(catalogueDescription);
        if (flowerr == null) {
            try {
                Class classFlowerr = Class.forName("com.mycompany.florists.model.flowers." + name);
                Constructor constructor = classFlowerr.getConstructors()[0];
                Flower flower = (Flower) constructor.newInstance(colour);
                map.put(catalogueDescription, flower);
                return flower;
            } catch (Exception ex) {
                return null;
            }
        } else {
            return flowerr;
        }
    }
}
