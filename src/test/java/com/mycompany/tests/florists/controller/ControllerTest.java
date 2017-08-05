package com.mycompany.tests.florists.controller;

import com.mycompany.florists.controller.Controller;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sławomir Kowalczyk
 */
public class ControllerTest {

    @Test
    public void sortTest() {
        List<String> list = new ArrayList();
        list.add("Roza CZERWONY");
        list.add("Tulipan ZOLTY");
        list.add("Gozdzik ZIELONY");
        list.add("Lilja FIOLETOWY");
        list.add("Storczyk NIEBIESKI");
        list.add("Irys BIALY");

        Controller.sortList(list);
        assertEquals("Pierwszym elementem tablicy powinien być Gozdzik ZIELONY", "Gozdzik ZIELONY", list.get(0));
        assertEquals("Drugim elementem tablicy powinien być Irys BIALY", "Irys BIALY", list.get(1));
        assertEquals("Trzecim elementem tablicy powinna być Lilja FIOLETOWY", "Lilja FIOLETOWY", list.get(2));
        assertEquals("Czwartym elementem tablicy powinna być Roza CZERWONY", "Roza CZERWONY", list.get(3));
        assertEquals("Piątym elementem tablicy powinien być Storczyk NIEBIESKI", "Storczyk NIEBIESKI", list.get(4));
        assertEquals("Szóstym elementem tablicy powinien być Tulipan ZOLTY", "Tulipan ZOLTY", list.get(5));
    }
}
