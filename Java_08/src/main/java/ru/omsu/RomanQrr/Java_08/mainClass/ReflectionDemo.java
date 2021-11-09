package ru.omsu.RomanQrr.Java_08.mainClass;

import ru.omsu.RomanQrr.Java_08.usingClass.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReflectionDemo {

    public static int numberObjectsOfType(List<?> list) {
        int count = 0;
        for (Object o : list) {
            if (o instanceof Human) {
                count++;
            }
        }
        return count;
    }

    public LinkedList<String> namesOfPublicMethods(Object object) {
        Class<?> cls = object.getClass();
        LinkedList<String> methodNames = new LinkedList<>();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            int mod = method.getModifiers();
            if(Modifier.isPublic(mod)){
                methodNames.add(method.getName());
            }
        }
        return methodNames;
    }

    public List<String> superClass(Object object) {
        List<String> superClassList = new ArrayList<>();
        Class<?> clazz = object.getClass().getSuperclass();
        while (clazz != null) {
            superClassList.add(clazz.getName());
            clazz = clazz.getSuperclass();
        }
        return superClassList;
    }

    public int implementingTheInterface(List<?> list) {
        int count = 0;
        for (Object o:list) {
            if (o instanceof Executable) {
                count++;
                ((Executable) o).execute();

            }
        }
        return count;
    }

    public List<String> getSet(Object object){
        List<String> getterSetters = new ArrayList<>();
        for (Method method: object.getClass().getMethods()){
            if(!Modifier.isStatic(method.getModifiers()) &&
                    (method.getName().indexOf("get") == 0 &&
                            method.getParameterCount() == 0 &&
                            !method.getReturnType().getName().equals("void")
                    ||
                    method.getName().indexOf("set") == 0 &&
                            method.getParameterCount() == 1 &&
                            method.getReturnType().getName().equals("void")
                    )
            )
            {
             getterSetters.add(method.getName());
            }
        }
        return getterSetters;
    }
}
