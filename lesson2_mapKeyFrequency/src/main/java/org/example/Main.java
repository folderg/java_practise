package org.example;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = List.of("a","a","aeq","a","b","qwea","asad","ac");
        HashMap answer = processArray(arrayList);
        System.out.println(answer);
    }

    public static <K> HashMap processArray(List<K> arrayList){
        HashMap<K, Integer> hashMap = new HashMap<>();
        arrayList.forEach(x -> {
            Integer value = hashMap.getOrDefault(x,0);
            value+=1;
            hashMap.put(x, value);
        }
        );
        return hashMap;
    }
}