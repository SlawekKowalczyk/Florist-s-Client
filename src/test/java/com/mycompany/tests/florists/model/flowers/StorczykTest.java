package com.mycompany.tests.florists.model.flowers;


import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.accessories.Wstazka;
import com.mycompany.florists.model.flowers.Storczyk;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class StorczykTest {

    @Test
    public void StorczykTest() {
        Flower k1 = new Storczyk(ColourName.Colours.ZIELONY);
        assertEquals("Nie poprawny opis katalogowy", "Storczyk ZIELONY", k1.getCatalogueDescription());
        assertEquals("Nie poprawny opis", "Storczyk ZIELONY", k1.getDescription());
        k1 = new Rafia(k1);
        assertEquals("Kwiatek nie został udekorowany - Rafia", "Storczyk ZIELONY Rafia", k1.getDescription());
        assertEquals("Nie zgadza się dekoracja", " Rafia", k1.getAccessories());

        Flower k2 = new Storczyk(ColourName.Colours.ZIELONY);
        k2 = new Rafia(k2);
        k2 = new Folia(k2);
        k2 = new Siatka(k2);
        k2 = new Wstazka(k2);
        assertEquals("Kwiatek nie został udekorowany - Rafia, Folia, Siatka, Wstazka",
                "Storczyk ZIELONY Rafia Folia Siatka Wstazka", k2.getDescription());
    }

}
