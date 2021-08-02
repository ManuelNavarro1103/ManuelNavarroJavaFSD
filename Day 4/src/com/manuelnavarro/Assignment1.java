package com.manuelnavarro;

import java.util.*;

public class Assignment1 {

    public static void main(String[] args) {

        System.out.println("\n************");
        System.out.println("Linked List");
        System.out.println("************");

        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Hamster");
        animals.add("Goat");
        animals.add("Fish");

        System.out.println("\nOriginal List");
        System.out.println("--------------");
        System.out.println(animals);

        System.out.println("\n1.");
        //System.out.println("---");
        animals.addLast("Cow");
        System.out.println(animals);

        System.out.println("\n2.");
        //System.out.println("---");
        Iterator<String> iterator = animals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n3.");
        ListIterator listIterator = animals.listIterator(3);
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("\n4.");
        Collections.reverse(animals);
        Iterator iterator1 = animals.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("\n5.");
        animals.add(3, "Horse");
        System.out.println(animals);

        System.out.println("\n********");
        System.out.println("HashSet");
        System.out.println("********");

        LinkedHashSet colors = new LinkedHashSet();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Pink");
        colors.add("Yellow");
        colors.add("Green");

        System.out.println("\nOriginal List");
        System.out.println("--------------");
        System.out.println(colors);

        System.out.println("\n1.");
        colors.add("Black");
        System.out.println(colors);

        System.out.println("\n2.");
        Iterator iterator2 = colors.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("\n3.");
        System.out.println(colors.size());

        System.out.println("\n4.");
        colors.removeAll(colors);
        System.out.println(colors);

        System.out.println("\n********");
        System.out.println("TreeSet");
        System.out.println("********");

        TreeSet colors1 = new TreeSet();
        colors1.add("Blue");
        colors1.add("Red");
        colors1.add("Green");
        colors1.add("Purple");
        colors1.add("White");

        System.out.println("\nOriginal List");
        System.out.println("--------------");
        System.out.println(colors1);

        System.out.println("\n1.");
        System.out.println(colors1);

        System.out.println("\n2.");
        Iterator iterator3 = colors1.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }

        System.out.println("\n3.");
        TreeSet colorCopy = new TreeSet();
        colorCopy.addAll(colors1);
        System.out.println(colorCopy);

        System.out.println("\n4.");
        Set<String> reverse = colors1.descendingSet();
        System.out.println(reverse);

        System.out.println("\n5.");
        System.out.println(colors1.first());
        System.out.println(colors1.last());
    }
}
