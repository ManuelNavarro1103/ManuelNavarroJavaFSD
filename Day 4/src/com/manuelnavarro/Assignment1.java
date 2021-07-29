package com.manuelnavarro;

import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>();
        colors.add("pink");
        colors.add("teal");
        colors.add("magenta");
        colors.add("coral");
        colors.add("amber");

        System.out.println("\nPrinting collection.");
        System.out.println("*********************");
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nIterating through array list to print all colors.");
        System.out.println("****************************************************");
        Iterator iterator = colors.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //adding in the first position of arraylist
        colors.add(0, "jade");
        System.out.println("\nAdded color to first index.");
        System.out.println("****************************");
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nElement at index 3.");
        System.out.println("********************");
        System.out.println(colors.get(3));

        System.out.println("\nUpdate array list.");
        System.out.println("*******************");
        colors.set(colors.indexOf("amber"), "black");
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nRemoving third element.");
        System.out.println("************************");
        colors.remove(2);
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nArray search.");
        System.out.println("**************");
        String colorSearch = "pink";
        if (colors.contains(colorSearch)) {
            System.out.println(colorSearch+" is at index "+ colors.indexOf(colorSearch));
        }
        else {
            System.out.println("Color does not exist.");
        }

        System.out.println("\nSorting array.");
        System.out.println("***************");
        Collections.sort(colors);
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nCopy array list into another array list.");
        System.out.println("*****************************************");
        ArrayList<String> newColors = new ArrayList();
        newColors.add("red");
        newColors.add("green");
        newColors.add("purple");
        colors.addAll(0, newColors);
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nShuffle array elements.");
        System.out.println("************************");
        Collections.shuffle(colors);
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nArray reversed.");
        System.out.println("****************");
        Collections.reverse(colors);
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nArray extraction.");
        System.out.println("******************");
        List<String> colorsSub = colors.subList(2, 5);
        for (String color : colorsSub) {
            System.out.println(color);
        }

        System.out.println("\nSwapping elements in an array.");
        System.out.println("*******************************");
        Collections.swap(colors, 1, 4);
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("\nHashMap key with value.");
        System.out.println("************************");
        Map colorsMap = new HashMap();
        colorsMap.put(1, "Red");
        colorsMap.put(2, "Blue");
        colorsMap.put(3, "Yellow");

        Iterator iterator1 = colorsMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator1.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        System.out.println("\nKey value count.");
        System.out.println("*****************");
        System.out.println(colorsMap.size());

        System.out.println("\nCopying map to another map.");
        System.out.println("****************************");
        Map copyColorsMap = new HashMap();
        copyColorsMap.putAll(colorsMap);

        Iterator iterator2 = copyColorsMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
