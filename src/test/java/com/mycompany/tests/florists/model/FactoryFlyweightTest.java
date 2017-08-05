package com.mycompany.tests.florists.model;


import com.mycompany.florists.model.FactoryFlyweight;
import com.mycompany.florists.model.ColourName;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.florists.model.Flower;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class FactoryFlyweightTest {
    
    @Test
    public void factoryFlyweightTest() {
        Flower a1 = FactoryFlyweight.factoryFlyweight("Gozdzik", ColourName.Colours.ZOLTY);
        assertNotNull("Obiektu nie znalazł w mapie", a1);
        Flower a2 = FactoryFlyweight.factoryFlyweight("Mieta", ColourName.Colours.BIALY);
        assertNull("Fabryka nie zwróciła null", a2);
        Flower a3 = FactoryFlyweight.factoryFlyweight("Gozdzik", ColourName.Colours.ZOLTY);
        assertSame("Obiekty są różne", a1, a3);
        Flower a4 = FactoryFlyweight.factoryFlyweight("Gozdzik", ColourName.Colours.NIEBIESKI);
        assertNotSame("Obiekty są takie same", a1, a4);
    }
    
}
