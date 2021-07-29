package com.manuelnavarro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo15 {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name", "Manuel");
        map.put("roll", 100);
        map.put("email", "m@gmail.com");
        map.put("active", true);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
}
