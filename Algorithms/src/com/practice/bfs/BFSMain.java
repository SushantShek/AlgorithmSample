package com.practice.bfs;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class BFSMain {

    public static void main(String[] s){
        List<String> lst = new ArrayList<String>();
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("c","5");
        map.put("a","1");
        map.put("b","2");
        System.out.println(" Size.." + map.size());
        Collection set = map.values();
//        List<String> result
        
        List<Object> result  = (List<Object>) set.stream().collect(toList());
        System.out.println("Set :" + result);
        HashSet<String> set1 = new HashSet(set);

    }
}
