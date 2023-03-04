package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<City>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(listSize + 1,list.getCount());
    }

    @Test
    public void testDelete(){
        list = MockCityList();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Edmonton", "Alberta");
        City city3 = new City("Toronto", "Ontario");
        list.add(city1);
        list.add(city2);
        list.delete(city1);

        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(city3); });



        assertTrue(list.hasCity(city1));

        assertTrue(list.hasCity(city2));



    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City test_city = new City("Estevan", "SK");
        list.addCity(test_city);

        assertEquals(list.hasCity(test_city),true);
//        assertEquals(true,test_city);


    }
}
