package com.mycompany.tests.florists.model.flowers;


import com.mycompany.florists.model.ColourName;
import com.mycompany.florists.model.accessories.Folia;
import com.mycompany.florists.model.accessories.Rafia;
import com.mycompany.florists.model.accessories.Siatka;
import com.mycompany.florists.model.accessories.Wstazka;
import com.mycompany.florists.model.flowers.Tulipan;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class TulipanTest {
    
    @Test
    public void TulipanTest() {
        Flower k1 = new Tulipan(ColourName.Colours.FIOLETOWY);
        assertEquals("Nie poprawny opis katalogowy", "Tulipan FIOLETOWY", k1.getCatalogueDescription());
        assertEquals("Nie zgadza się opis", "Tulipan FIOLETOWY" , k1.getDescription());
        k1 = new Folia(k1);
        assertEquals("Kwiatek nie został udekorowany", "Tulipan FIOLETOWY Folia" , k1.getDescription());
        assertEquals("Nie zgadza się dekoracja", " Folia" , k1.getAccessories());
        
        Flower k2 = new Tulipan(ColourName.Colours.FIOLETOWY);
        k2 = new Rafia(k2);
        k2 = new Folia(k2);
        k2 = new Siatka(k2);
        k2 = new Wstazka(k2);
        assertEquals("Kwiatek nie został udekorowany - Rafia, Folia, Siatka, Wstazka",
                "Tulipan FIOLETOWY Rafia Folia Siatka Wstazka", k2.getDescription());
        
    }
    
}
