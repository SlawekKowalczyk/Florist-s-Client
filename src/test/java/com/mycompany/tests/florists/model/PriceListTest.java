package com.mycompany.tests.florists.model;


import com.mycompany.florists.model.PriceList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class PriceListTest {
    
    @Test
    public void singletonTest() {
        PriceList  c1 = PriceList.getInstance();
        PriceList  c2 = PriceList.getInstance();
        
        assertSame("Singleton Cennik powinien mieć jedną instancję", c1, c2);
    }
    
    @Test
    public void sizeTest(){
        PriceList priceList  = PriceList.getInstance();
        priceList.clear();
        assertEquals("Cennik nie jest pusty", 0, priceList.getSize());
        priceList.setPrice("p1", 2.12);
        priceList.setPrice("p2", 3.12);
        priceList.setPrice("p3", 4.12);
        priceList.setPrice("p4", 5.12);
        assertEquals("Cennik nie zawiera 4 produktów", 4, priceList.getSize());
        priceList.setPrice("p3", 12.12);
        assertEquals("Cennik nie zawiera 4 produktów", 4, priceList.getSize());
        priceList.clear();
        assertEquals("Cennik po clear nie jest pusty", 0, priceList.getSize());
    }
    
    @Test
    public void setPriceTest(){
        PriceList priceList = PriceList.getInstance();
        priceList.clear();
        priceList.setPrice("p1", 2.12);
        priceList.setPrice("p2", 3.12);
        priceList.setPrice("p3", 4.12);
        priceList.setPrice("p4", 5.12);
        
        assertEquals("Funkcja setCena nie ustawia nowej ceny",2.12 , priceList.getPrice("p1"), 0.0001);
        assertEquals("Funkcja setCena nie ustawia nowej ceny",3.12 , priceList.getPrice("p2"), 0.0001);
        assertEquals("Funkcja setCena nie ustawia nowej ceny",4.12 , priceList.getPrice("p3"), 0.0001);
        assertEquals("Funkcja setCena nie ustawia nowej ceny",5.12 , priceList.getPrice("p4"), 0.0001);
        
        assertNull("Cennik nie zawiera tego produktu", priceList.getPrice("p5"));
        
        priceList.setPrice("p1", 10.15);
        assertEquals("Nowa cena nie została ustawiona",10.15, priceList.getPrice("p1"), 0.0001);
    }
}
