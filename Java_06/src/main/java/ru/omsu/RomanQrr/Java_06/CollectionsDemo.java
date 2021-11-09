package ru.omsu.RomanQrr.Java_06;

import java.util.*;

public class CollectionsDemo {

    public static int filterSymbol(List<String> stringList, char symbol){
        if(stringList == null || stringList.size() == 0){
            throw new IllegalArgumentException("Empty string");
        }
        int count = 0;
        for(String item: stringList){
            if(item != null && item.charAt(0) == symbol ){
                count ++;
            }
        }
        return count;
    }

    public static List<Human> filterBySurname(List<Human> humanObjects, Human human){
        if(humanObjects == null || humanObjects.size() == 0 || human == null){
            throw new IllegalArgumentException("Null or empty argument.");
        }
        List<Human> newList = new ArrayList<>();
        for(Human item: humanObjects){
            if(item.getSurName().equals(human.getSurName())){
                newList.add(item);
            }
        }
        return newList;
    }

    public static List<Human> copyOfList(List<Human> humanObjects, Human human){
        if(humanObjects == null || humanObjects.size() == 0 || human == null){
            throw new IllegalArgumentException("Null or empty argument.");
        }
        List<Human> newList = new ArrayList<>();
        for(Human item: humanObjects){
            Human temp = new Human(item);
            newList.add(temp);
        }
        newList.removeAll(Collections.singleton(human));
        return newList;
    }

    public static List<Set<Integer>> setInSet(List<Set<Integer>>intNum, Set<Integer> num){
        if(intNum == null || intNum.size() == 0 || num == null){
            throw new IllegalArgumentException("Null or empty argument.");
        }
        List<Set<Integer>> newList = new ArrayList<>();
        for (Set<Integer> item: intNum){
            if(Collections.disjoint(item, num)){
                newList.add(item);
            }
        }
        return newList;
    }

    public static <T extends Human> Set<T> personMaxAge( List<T> list){
        if(list == null || list.size() == 0){
            throw new IllegalArgumentException("Null or empty argument.");
        }
        Set<T> set = new HashSet<>();
        int maxAge = 0;
        for(T item: list){
            if (item.getAge() > maxAge){
                maxAge = item.getAge();
            }
        }
        for(T item: list){
            if (item.getAge() == maxAge){
                maxAge = item.getAge();
                set.add(item);
            }
        }
        return set;
    }


    public static Set<Human> filterByIdentifier(Map<Integer, Human> humanSet,Set<Integer> num){
        if(humanSet == null || humanSet.size() == 0 || num.size()==0){
            throw new IllegalArgumentException("Wrong parameters");
        }
        Set<Human> set = new HashSet<>();
        for(Integer item: num){
            if(humanSet.containsKey(item)){
                set.add(humanSet.get(item));
            }
        }
        return set;
    }

    public static List<Integer> eighteenIdentifier(Map<Integer, Human> humanSet){
        if (humanSet == null || humanSet.size() == 0){
            throw new IllegalArgumentException("Wrong parameters");
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Human> item: humanSet.entrySet()){
            if(item.getValue().getAge()>=18){
                list.add(item.getKey());
            }
        }
        return list;
    }

    public static Map<Integer, Integer> ageIdentifier(Map<Integer, Human> humanSet){
        if (humanSet == null || humanSet.size() == 0){
            throw new IllegalArgumentException("Wrong parameters");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Human> item: humanSet.entrySet()){
            map.put(item.getKey(), item.getValue().getAge());
        }
        return map;
    }

    public static Map<Integer, List<Human>> makeListOfAge(Set<Human> set){
        if (set.size()==0){
            throw new IllegalArgumentException("Wrong parameters");

        }
        Map <Integer, List<Human>> map = new HashMap<>();
        for(Human item: set){
           if (!map.containsKey(item.getAge())){
               List<Human> list = new ArrayList<>();
               list.add(new Human(item));
               map.put(item.getAge(), list);
           }else
           {
               map.get(item.getAge()).add(new Human(item));
           }
        }
        return map;
    }
}
