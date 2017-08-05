package com.mycompany.florists.model;

/**
 *
 * @author Sławomir Kowalczyk
 */
public interface Flower {

    /**
     *
     * @return Returns flower name and colour(catalogue description).
     */
    public String getCatalogueDescription();

    /**
     *
     * @return Returns catalogue description with decorating accessories.
     */
    public String getDescription();

    /**
     * The default method returns flower accessories. If not overwritten, it
     * will be an empty String.
     *
     * @return Returns empty String.
     */
    public default String getAccessories() {
        return "";
    }
}
