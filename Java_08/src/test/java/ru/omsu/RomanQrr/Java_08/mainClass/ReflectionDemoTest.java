package ru.omsu.RomanQrr.Java_08.mainClass;

import org.junit.Assert;
import org.junit.Test;

import ru.omsu.RomanQrr.Java_08.usingClass.*;

import java.util.*;

import static org.junit.Assert.*;

public class ReflectionDemoTest {
    class A extends UseHuman {};

    @Test
    public void testUseHuman() {
        ArrayList<Object> list = new ArrayList<>();
        Collections.addAll(list,
                new Bla(1,1),
                new ArrayList<Bla>(),
                new UseHuman(),
                new A(),
                100);
        assertEquals(2, ReflectionDemo.numberObjectsOfType(list));
    }

    @Test
    public void namesOfPublicMethodsTest() throws ClassNotFoundException {
        ReflectionDemo a = new ReflectionDemo();
        Bla bla = new Bla(2, 2);
        List<String> answer = a.namesOfPublicMethods(bla);
        List<String> exp = new LinkedList<>();
        exp.add("getB");
        exp.add("getA");
        exp.add("vs");
        exp.sort(String.CASE_INSENSITIVE_ORDER);
        answer.sort(String.CASE_INSENSITIVE_ORDER);
        assertEquals(exp, answer);
    }

    @Test
    public void superClass() {
        ReflectionDemo c = new ReflectionDemo();
        Bla bla = new Bla(2, 2);
        List<String> answer = c.superClass(bla);
        String[] expected = new String[]{"ru.omsu.RomanQrr.Java_08.usingClass.Exsec", "java.lang.Object"};
        assertArrayEquals(expected, answer.toArray());
    }
    @Test
    public void superClassA() {
        ReflectionDemo c = new ReflectionDemo();
        List<String> answer = c.superClass(new A());
        String[] expected = new String[]{"ru.omsu.RomanQrr.Java_08.usingClass.UseHuman", "ru.omsu.RomanQrr.Java_08.usingClass.UsingHuman", "ru.omsu.RomanQrr.Java_08.usingClass.Human", "java.lang.Object"};
        System.out.println(Arrays.toString(answer.toArray()));
        assertArrayEquals(expected, answer.toArray());
    }

    @Test
    public void implementingTheInterfaceTest() {
        ReflectionDemo d = new ReflectionDemo();
        Bla bla = new Bla(11, 22);
        Exsec exsec = new Exsec();
        Human human = new Human();
        List<Object> list = new ArrayList<>();
        list.add(bla);
        list.add(exsec);
        list.add(human);
        int answer = d.implementingTheInterface(list);
        int exp = 2;
        Assert.assertEquals(exp, answer);
    }

    @Test
    public void getSetTest(){
        
    }

}
