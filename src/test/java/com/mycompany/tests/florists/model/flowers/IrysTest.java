package com.mycompany.tests.florists.model.flowers;


import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.accessories.Wstazka;
import com.mycompany.florists.model.flowers.Irys;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class IrysTest {

    @Test
    public void IrysTest() {
        Flower k1 = new Irys(ColourName.Colours.NIEBIESKI);
        assertEquals("Nie poprawny opis katalogowy", "Irys NIEBIESKI", k1.getCatalogueDescription());
        assertEquals("Nie poprawny opis", "Irys NIEBIESKI", k1.getDescription());
        k1 = new Siatka(k1);
        assertEquals("Kwiatek nie został udekorowany - Rafia", "Irys NIEBIESKI Siatka", k1.getDescription());
        assertEquals("Nie zgadza się dekoracja", " Siatka", k1.getAccessories());

        Flower k2 = new Irys(ColourName.Colours.NIEBIESKI);
        k2 = new Rafia(k2);
        k2 = new Folia(k2);
        k2 = new Siatka(k2);
        k2 = new Wstazka(k2);
        assertEquals("Kwiatek nie został udekorowany - Rafia, Folia, Siatka, Wstazka",
                "Irys NIEBIESKI Rafia Folia Siatka Wstazka", k2.getDescription());
    }

}
