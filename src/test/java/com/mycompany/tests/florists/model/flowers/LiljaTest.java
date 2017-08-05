package com.mycompany.tests.florists.model.flowers;


import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.accessories.Wstazka;
import com.mycompany.florists.model.flowers.Lilja;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class LiljaTest {

    @Test
    public void LiljaTest() {
        Flower k1 = new Lilja(ColourName.Colours.ROZOWY);
        assertEquals("Nie poprawny opis katalogowy", "Lilja ROZOWY", k1.getCatalogueDescription());
        assertEquals("Nie poprawny opis", "Lilja ROZOWY", k1.getDescription());
        k1 = new Wstazka(k1);
        assertEquals("Kwiatek nie został udekorowany - Rafia", "Lilja ROZOWY Wstazka", k1.getDescription());
        assertEquals("Nie zgadza się dekoracja", " Wstazka", k1.getAccessories());

        Flower k2 = new Lilja(ColourName.Colours.ROZOWY);
        k2 = new Rafia(k2);
        k2 = new Folia(k2);
        k2 = new Siatka(k2);
        k2 = new Wstazka(k2);
        assertEquals("Kwiatek nie został udekorowany - Rafia, Folia, Siatka, Wstazka",
                "Lilja ROZOWY Rafia Folia Siatka Wstazka", k2.getDescription());
    }

}
