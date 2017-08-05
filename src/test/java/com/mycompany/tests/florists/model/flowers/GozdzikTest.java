package com.mycompany.tests.florists.model.flowers;

import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.accessories.Wstazka;
import com.mycompany.florists.model.flowers.Gozdzik;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class GozdzikTest {

    @Test
    public void GozdzikTest() {
        Flower k1 = new Gozdzik(ColourName.Colours.CZERWONY);
        assertEquals("Nie poprawny opis katalogowy", "Gozdzik CZERWONY", k1.getCatalogueDescription());
        assertEquals("Nie poprawny opis", "Gozdzik CZERWONY", k1.getDescription());
        k1 = new Rafia(k1);
        assertEquals("Kwiatek nie został udekorowany - Rafia", "Gozdzik CZERWONY Rafia", k1.getDescription());
        assertEquals("Nie zgadza się dekoracja", " Rafia", k1.getAccessories());

        Flower k2 = new Gozdzik(ColourName.Colours.CZERWONY);
        k2 = new Rafia(k2);
        k2 = new Folia(k2);
        k2 = new Siatka(k2);
        k2 = new Wstazka(k2);
        assertEquals("Kwiatek nie został udekorowany - Rafia, Folia, Siatka, Wstazka",
                "Gozdzik CZERWONY Rafia Folia Siatka Wstazka", k2.getDescription());
    }

}
