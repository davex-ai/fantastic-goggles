package Show;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;   //(*) means all classes in the library this line is importing the library

public class LambdaRunnable {
    public static void main(String[] args) {
        List <String> name = Arrays.asList("Will","Xena","Tyler");
        name.sort((a,b)-> a.compareTo(b));
        System.out.println(name);

//        Runnable r = () -> System.out.println( "Lambda expression running!" );
//        new Thread(r).start();
    }
}
// Briefly analyse and explain this code