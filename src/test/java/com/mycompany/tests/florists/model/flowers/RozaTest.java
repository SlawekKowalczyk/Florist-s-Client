package com.mycompany.tests.florists.model.flowers;


import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.accessories.Wstazka;
import com.mycompany.florists.model.flowers.Roza;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class RozaTest {

    @Test
    public void RozaTest() {
        Flower k1 = new Roza(ColourName.Colours.BIALY);
        assertEquals("Nie poprawny opis katalogowy", "Roza BIALY", k1.getCatalogueDescription());
        assertEquals("Nie poprawny opis", "Roza BIALY", k1.getDescription());
        k1 = new Rafia(k1);
        assertEquals("Kwiatek nie został udekorowany - Rafia", "Roza BIALY Rafia", k1.getDescription());
        assertEquals("Nie zgadza się dekoracja", " Rafia", k1.getAccessories());

        Flower k2 = new Roza(ColourName.Colours.BIALY);
        k2 = new Rafia(k2);
        k2 = new Folia(k2);
        k2 = new Siatka(k2);
        k2 = new Wstazka(k2);
        assertEquals("Kwiatek nie został udekorowany - Rafia, Folia, Siatka, Wstazka",
                "Roza BIALY Rafia Folia Siatka Wstazka", k2.getDescription());
    }

}
