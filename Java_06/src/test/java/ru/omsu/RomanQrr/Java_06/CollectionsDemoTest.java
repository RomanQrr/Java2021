package ru.omsu.RomanQrr.Java_06;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CollectionsDemoTest {

    @Test
    public void testSymbolFilter() {
        String s1 = "Red Apples";
        String s2 = " Orange Oranges";
        String s3 = "Green Watermelon";
        String s4 = "Red Tomato";
        List<String> list = new ArrayList<>();
       Collections.addAll(list, s1,s2, s3, s4);

      assertEquals(CollectionsDemo.filterSymbol(list, 'R') , 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSymbolFilterException() throws IllegalArgumentException{
        List<String> list = new ArrayList<>();
        CollectionsDemo.filterSymbol(list, 'R');
    }


   @Test
    public void testCopyHumanFromListWrong(){
        Human one = new Human("Petrov" , "Ivan", "Ivanovich", 17);
        Human two = new Human("Akimov","Artem" , "Andreevich", 20);
        Human three = new Human("Tarasova","Anastasia" , "Alekseevna", 20);

        List<Human> people = new ArrayList<>();
        Collections.addAll(people, one, two, three);

        List<Human> newPeople = new ArrayList<>(people);

        people.get(1).setAge(24);

        assertNotEquals(newPeople.get(1).getAge(), 17);

    }

    @Test
    public void testCopyHumanFromListRight(){
        Human one = new Human("Petrov" , "Ivan", "Ivanovich", 17);
        Human two = new Human("Akimov","Artem" , "Andreevich", 20);
        Human three = new Human("Tarasova","Anastasia" , "Alekseevna", 20);
        List<Human> people = new ArrayList<>();
        Collections.addAll(people, one, two, three);

        List<Human> newPeople = new ArrayList<>();
        for(Human item: people){
            Human temp = new Human(item);
            newPeople.add(temp);
        }


        people.get(0).setAge(24);

        assertEquals(people.get(0).getAge(), 24);
        assertEquals(newPeople.get(0).getAge(), 17);
    }

    @Test
    public void testCopyOfList(){
        Human one = new Human("Petrov" , "Ivan", "Ivanovich", 17);
        Human two = new Human("Akimov","Artem" , "Andreevich", 20);
        Human three = new Human("Tarasova","Anastasia" , "Alekseevna", 20);
        List<Human> people = new ArrayList<>();
        Collections.addAll(people, one, two, three);

        List<Human> expected = new ArrayList<>();
        Collections.addAll(expected, one, three);

        assertEquals(expected, CollectionsDemo.copyOfList(people, two));

    }

    @Test
    public void testFilterBySurname(){
        Human one = new Human("Нетленко" , "Иван", "Иванович", 17);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 20);
        Human three = new Human("Тарасова","Анастасия" , "Алексеевна", 20);
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 67);
        List<Human> people = new ArrayList<>();
        Collections.addAll(people, one, two, three, four);

        List<Human> expected = new ArrayList<>();
        Collections.addAll(expected, one, two);

        Human test = new Human("Нетленко", "Маргарита", "Петровна", 64);
        assertEquals(expected, CollectionsDemo.filterBySurname(people, test));

    }
    @Test
    public void testFilterBySurnameNull(){
        Human one = new Human("Нетленко" , "Иван", "Иванович", 17);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 20);
        Human three = new Human("Тарасова","Анастасия" , "Алексеевна", 20);
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 67);
        List<Human> people = new ArrayList<>();
        Collections.addAll(people, one, two, three, four);

        List<Human> expected = new ArrayList<>();

        Human test = new Human("Герассим", "Маргарита", "Петровна", 64);
        assertEquals(expected, CollectionsDemo.filterBySurname(people, test));

    }

    @Test
    public void testSetInSet(){
        Set<Integer> setOne = new HashSet<>();
        setOne.add(1);
        setOne.add(2);
        setOne.add(3);

        Set<Integer> setTwo = new HashSet<>();
        setTwo.add(4);
        setTwo.add(5);
        setTwo.add(6);

        Set<Integer> setThree = new HashSet<>();
        setThree.add(2);
        setThree.add(3);
        setThree.add(1);

        Set<Integer> setFour = new HashSet<>();
        setFour.add(7);
        setFour.add(8);
        setFour.add(9);

        Set<Integer> setCheck = new HashSet<>();
        setCheck.add(2);
        setCheck.add(3);

        List<Set<Integer>> setList = new ArrayList<>();
        Collections.addAll(setList, setOne, setTwo, setThree, setFour);

        List<Set<Integer>> expected = new ArrayList<>();
        Collections.addAll(expected, setTwo, setFour);

        assertEquals(expected, CollectionsDemo.setInSet(setList, setCheck));
    }

    @Test
    public void testPersonMaxAge(){
        Human one = new Human("Нетленко" , "Иван", "Иванович", 17);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 20);
        Student three = new Student("Тарасова","Анастасия" , "Алексеевна", 20, "IMIT");
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 19);
        Student five = new Student("Акимова","Алина", "Александровна",20, "IMIT");
        List<Human> people = new ArrayList<>();
        Collections.addAll(people, one, two, three, four, five);

        Set<Human> peopleSet = new HashSet<>();
        peopleSet.add(two);
        peopleSet.add(three);
        peopleSet.add(five);

        assertEquals(peopleSet, CollectionsDemo.personMaxAge(people));
    }

    @Test
    public void testFilterByIdentifier(){
        Map<Integer, Human> humanSet = new HashMap<>();

        Human one = new Human("Нетленко" , "Иван", "Иванович", 17);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 20);
        Human three = new Human("Тарасова","Анастасия" , "Алексеевна", 20);
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 67);

        humanSet.put(1, one);
        humanSet.put(2, two);
        humanSet.put(3, three);
        humanSet.put(4, four);

        Set<Integer> num = new HashSet<>();
        num.add(1);
        num.add(3);

        Set<Human> expected = new HashSet<>();
        expected.add(one);
        expected.add(three);

        assertEquals(expected, CollectionsDemo.filterByIdentifier(humanSet, num));
    }

    @Test
    public void testEighteenIdentifier(){
        Human one = new Human("Нетленко" , "Иван", "Иванович", 20);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 8);
        Human three = new Human("Тарасова","Анастасия" , "Алексеевна", 10);
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 67);

        Map<Integer, Human> humanSet = new HashMap<>();
        humanSet.put(1, one);
        humanSet.put(2, two);
        humanSet.put(3, three);
        humanSet.put(4, four);

        List<Integer> listExpected = new ArrayList<>();
        Collections.addAll(listExpected, 1, 4);

        assertEquals(listExpected, CollectionsDemo.eighteenIdentifier(humanSet));
    }

    @Test
    public void testAgeIdentifier(){
        Human one = new Human("Нетленко" , "Иван", "Иванович", 20);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 8);
        Human three = new Human("Тарасова","Анастасия" , "Алексеевна", 10);
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 67);

        Map<Integer, Human> humanSet = new HashMap<>();
        humanSet.put(1, one);
        humanSet.put(2, two);
        humanSet.put(3, three);
        humanSet.put(4, four);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 20);
        expected.put(2, 8);
        expected.put(3, 10);
        expected.put(4, 67);

        assertEquals(expected, CollectionsDemo.ageIdentifier(humanSet));
    }

    @Test
    public void testMakeListOfAge(){
        Human one = new Human("Нетленко" , "Иван", "Иванович", 20);
        Human two = new Human("Нетленко","Елена" , "Андреевна", 20);
        Human three = new Human("Тарасова","Анастасия" , "Алексеевна", 10);
        Human four = new Human("Нелеева", "Ирина", "Игоревна", 10);
        Human five = new Human("Галич", "Маргарита", "Сергевна", 78);

        Set<Human> humanSet = new HashSet<>();
        humanSet.add(one);
        humanSet.add(two);
        humanSet.add(three);
        humanSet.add(four);
        humanSet.add(five);

        List<Human> first = new ArrayList<>();
        Collections.addAll(first, one, two);

        List<Human> second = new ArrayList<>();
        Collections.addAll(second, three, four);

        List<Human> third = new ArrayList<>();
        Collections.addAll(third, five);

        Map<Integer, List<Human>> expected = new HashMap<>();
        expected.put(20, first);
        expected.put(10, second);
        expected.put(78, third);

        assertEquals(expected, CollectionsDemo.makeListOfAge(humanSet));
    }
}
