package com.manuelnavarro;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo8 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Manuel");
        names.add("Sara");
        names.add("Leah");
        System.out.println(names);

        // adding element at specified position
        names.add(0, "Carlos");
        System.out.println(names);

        // adding second list
        LinkedList<String> namesNew = new LinkedList<>();
        namesNew.add("Myron");
        namesNew.add("Karina");

        //names.addAll(namesNew);
        //System.out.println(names);

        names.addAll(0, namesNew);
        System.out.println(names);

        // addFirst()
        names.addFirst("First");
        System.out.println(names);


        // addLast()
        names.addLast("Last");
        System.out.println(names);

        // remove()
        // remoteFirst()
        // removeLast()
        // removeFirstOccurrence()
        // removeLastOccurrence()

        names.add("John");
        names.add("Paul");
        System.out.println(names);

        //names.removeFirstOccurrence("John");
        names.removeLastOccurrence("John");
        System.out.println(names);

        // reverse elements
        System.out.println("\nOriginal");
        System.out.println(names);

        // traversing list element in reverse order
        Iterator iterator = names.descendingIterator();
        while(iterator.hasNext()){
            //SSystem.out.println(iterator.next());
        }

        for(int i=names.size() -1; i>0;i--){
            //System.out.println(names.get(i));
        }

    }
}
