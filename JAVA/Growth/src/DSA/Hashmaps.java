package DSA;

import Qwin.Solve;

import java.util.*;
 //A HashMap stores items in key/value pairs, where each key maps to a specific value.
//It is part of the java.util package and implements the Map interface.

public class Hashmaps {
    public String nonRepeat(String input){
        int i = 0;
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (Character c : input.toCharArray()){
            characterIntegerHashMap.put(c,i);
            i++;
        }
        for (int j = 0; ;){}
    }


    public static void main(String[] args) {
            Hashmaps hmd = new Hashmaps();
       ArrayList<String> arrayList = new ArrayList<>();
       arrayList.add("");
//       arrayList.forEach(System.out::println);

//
//    HashMap<Integer, String> map = new HashMap<>();
////        To add items to a HashMap, use the put() method:
//        map.put(9,"Game");
//        map.put(8,"bade");
//        map.put(7,"ups");
//        map.put(7,"un");
////Note: In the example above, if the same key (like line 18 and 19)
////is added more than once, the latest value will overwrite
////the previous one, because keys in a HashMap must be unique.
//// To access a value in the HashMap, use the get() method and refer to its key:
//        map.get(7);
//        System.out.println(map.get(7));
//// To remove a value in the HashMap, use the remove() method and refer to its key:
//        map.remove(7);
//        System.out.println(map.remove(7));
//
//// To remove all items in the HashMap, use the clear() method
////        map.clear();
//
////        To find out how many items there are, use the size() method:
////      System.out.println(map.size());
//// Loop through the items of a HashMap with a for-each loop.
//// Note: Use the keySet() method if you only want the keys,
//// and use the values() method if you only want the values:
////        for (int i : map.keySet()) {
////            System.out.println(i);
////        }
////        for (int i : map.keySet()){
////            System.out.println("Key: " + i + " values: "+ map.get(i));
////        }
//        HashMap<String, Integer> people = new HashMap<>();
//        people.put("Mike", 34);
//        people.put("John", 32);
//        people.put("Steve", 30);
//        people.put("Angie", 33);
////
//
//        for (String i: people.keySet()){
//            System.out.println("name: " + i + " age: " + people.get(i));
//        }
        HashMap<String, ArrayList<String>> imh = new HashMap<>();
//     HashMap(int initialCapacity, float loadFactor): It creates a HashMap instance with a specified initial capacity and specified load factor.
        HashMap<Integer, String> ih = new HashMap<>(3, 0.75f);


        // initialize a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add elements using put method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

//        System.out.println(map.entrySet());
//        System.out.println(map.keySet());
//        System.out.println(map.values());
//        System.out.println(map.hashCode());
//        System.out.println(map);

//        Using a Custom Object as the Value: A custom class can be defined to encapsulate multiple related values.

        class UserInfo {
            String address;
            String email;
            int sm = Integer.MAX_VALUE;
            public UserInfo(String s, String mail) {
            }
            // ... other fields
        }
        HashMap<String, UserInfo> userMap = new HashMap<>();
        userMap.put("JohnDoe", new UserInfo("123 Main St", "john@example.com"));

//        Using a Collection as the Value: The most common method involves storing a collection, such as an ArrayList, List, Set, or Queue, as the value for each key.
        HashMap<String, List<String>> multiValueMap = new HashMap<>();
        multiValueMap.put("Fruits", new ArrayList<>(Arrays.asList("Apple", "Banana")));
        multiValueMap.get("Fruits").add("Orange");
        //    𝗠𝗮𝗽 𝗡𝗼𝘁 𝗜𝘁𝗲𝗿𝗮𝗯𝗹𝗲 𝗶𝗻 𝗝𝗮𝘃𝗮
//    therefore we have to be explicit in what we wanna iterate (keys or values)
        // Iterate the map using for-each loop4. Traversal of Java HashMap
        //We can use the Iterator interface to traverse over any structure of the Collection Framework.
        // Since Iterators work with one type of data we use Entry< ? , ? > resolve the two separate types into a compatible format.
        // Then using the next() method we print the entries of HashMap.
        HashMap<String, Integer> myHashMap = new HashMap<>();
         myHashMap.put("Vannessa", 1);
        myHashMap.put("Eric", 5);
        for (Map.Entry<String, Integer> entry : myHashMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Values: " + entry.getValue());
            // Process key and value
        }
    }
   }
                        

