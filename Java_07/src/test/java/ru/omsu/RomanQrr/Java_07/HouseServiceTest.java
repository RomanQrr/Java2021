package ru.omsu.RomanQrr.Java_07;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class HouseServiceTest {
    private Person person1 = new Person("surname1", "name1", "secondName1", "date1");
    private Person person2 = new Person("surname2", "name2", "secondName2", "date2");
    private Person person3 = new Person("surname3", "name3", "secondName3", "date3");
    private Person person4 = new Person("surname4", "name4", "secondName4", "date4");
    private Person person5 = new Person("surname5", "name5", "secondName5", "date5");
    private ArrayList<Person> ownerFlat1 = new ArrayList<>();
    private ArrayList<Person> ownerFlat2 = new ArrayList<>();
    private ArrayList<Person> ownerFlat3 = new ArrayList<>();
    private ArrayList<Flat> listFlat = new ArrayList<>();

    @Test
    public void testSerializeAndDeserializeHouse() throws IOException, ClassNotFoundException {
        Collections.addAll(ownerFlat1, person1, person2);
        Collections.addAll(ownerFlat2, person3);
        Collections.addAll(ownerFlat3, person4, person5);
        Flat flat1 = new Flat(12, 2000, ownerFlat1);
        Flat flat2 = new Flat(10, 5000, ownerFlat2);
        Flat flat3 = new Flat(5, 3000, ownerFlat3);
        Collections.addAll(listFlat, flat1, flat2, flat3);
        House house = new House("10", "address", person4, listFlat);
        HouseService.serializeHouse(house, "test.txt");
        House house1 = HouseService.deserializeHouse("test.txt");
        assertEquals(house, house1);
    }

    @Test
    public void testSerializeAndDeserializeHouseString() throws IOException {
        Collections.addAll(ownerFlat1, person1, person2);
        Collections.addAll(ownerFlat2, person3);
        Collections.addAll(ownerFlat3, person4, person5);
        Flat flat1 = new Flat(12, 2000, ownerFlat1);
        Flat flat2 = new Flat(10, 5000, ownerFlat2);
        Flat flat3 = new Flat(5, 3000, ownerFlat3);
        Collections.addAll(listFlat, flat1, flat2, flat3);
        House house = new House("10", "address", person4, listFlat);
        assertEquals(house, HouseService.deserializeHouseJSON(HouseService.serializeHouseJSON(house)));
    }

}
