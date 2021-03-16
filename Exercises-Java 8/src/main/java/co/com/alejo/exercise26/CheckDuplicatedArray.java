package co.com.alejo.exercise26;

import java.lang.reflect.Array;
import java.util.*;

public class CheckDuplicatedArray {

    public static void main(String[] args) {

        String[] valueDuplicated1 = new String[]{"a", "b", "c", "d", "1", "e", "f", "1", "4", "z"};
        Integer[] valueDuplicated2 = new Integer[]{2, 3, 1, 4, 99, 2, 9, 7, 88, 2};
        Integer[] valueDuplicated3 = new Integer[]{2, 3, 1, 4, 99, 5, 6, 7, 88, 9};

        System.out.println( "Java 8: " + isDuplicatedWithJava8(valueDuplicated1));
        System.out.println("Java 8: " + isDuplicatedWithJava8(valueDuplicated2));
        System.out.println("Java 8: " + isDuplicatedWithJava8(valueDuplicated3));
        System.out.println("TreeSet: " + isDuplicatedWithTreeSet(valueDuplicated1));
        System.out.println("TreeSet: " + isDuplicatedWithTreeSet(valueDuplicated2));
        System.out.println("TreeSet: " + isDuplicatedWithTreeSet(valueDuplicated3));
        System.out.println("Loop: " + isDuplicatedWithLoop(valueDuplicated1));
        System.out.println("Loop: " + isDuplicatedWithLoop(valueDuplicated2));
        System.out.println("Loop: " + isDuplicatedWithLoop(valueDuplicated3));
        System.out.println("Set: " +  isDuplicatedWithSet(valueDuplicated1));
        System.out.println("Set: " +  isDuplicatedWithSet(valueDuplicated2));
        System.out.println("Set: " +  isDuplicatedWithSet(valueDuplicated3));

    }

    // Example 1 with Java 8 + distinct() + count()
    public static <T> boolean isDuplicatedWithJava8(final T[] values){
        return Arrays.stream(values).distinct().count() != values.length;
    }

    // Example 2 with TreeSet
    public static <T> boolean isDuplicatedWithTreeSet(final T[] values){
        TreeSet set = new TreeSet<T>(Arrays.asList(values));
        return set.size() != values.length;
    }

    // Example 3 with loops
    public static <T> boolean isDuplicatedWithLoop(final T[] values){
        for(int i= 0; i < values.length; i ++ ){
            for(int j = 0; j < values.length; j++){
                if (i == j ) continue; // same index position

                if (values instanceof  String[]){
                    if(values[i].equals(values[j])){
                        return true;
                    }
                } else{
                    if (values[i] == values[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Example 4 with Set
    public static <T> boolean isDuplicatedWithSet(final T[] values){
        Set set = new HashSet<T>();
        for (T s : values){
            if (set.contains(s)) return true;
            set.add(s);
        }
        return false;
    }
}
