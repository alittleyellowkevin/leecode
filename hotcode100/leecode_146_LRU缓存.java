package hotcode100;

import java.util.*;
import java.util.stream.Collectors;

public class leecode_146_LRU缓存 {
    public static void main(String[] args) {
        leecode_146_LRU缓存 lRUCache = new leecode_146_LRU缓存(2);
        lRUCache.put(1, 1); // 缓存：{1=1}
        lRUCache.put(2, 2); // 缓存：{1=1, 2=2}
        lRUCache.get(1);
        System.out.println(lRUCache.get(1));    // 返回1，缓存变为{2=2, 1=1}
        lRUCache.put(3, 3); // 容量满，移除最久未用的2，缓存：{1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回-1（已被移除）
        lRUCache.put(4, 4); // 容量满，移除最久未用的1，缓存：{3=3, 4=4}
        System.out.println(lRUCache.get(1));    // 返回-1（已被移除）
        System.out.println(lRUCache.get(3));    // 返回3，缓存变为{4=4, 3=3}
        System.out.println(lRUCache.get(4));    // 返回4，缓存变为{3=3, 4=4}
    }
    int maxCapacity;
    int count=0;
    LinkedHashMap<Integer, Integer> linkedHashMap;

    public leecode_146_LRU缓存(int capacity) {
        maxCapacity = capacity;
        linkedHashMap = new LinkedHashMap<>(1000, 0.75f, true);
    }

    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(linkedHashMap.containsKey(key)){
            linkedHashMap.put(key, value);
            return;
        }
        if(count == maxCapacity){
            for (Integer keyset : linkedHashMap.keySet()) {
                linkedHashMap.remove(keyset);
                break;
            }
            linkedHashMap.put(key, value);
        }else {
            linkedHashMap.put(key, value);
            count++;
        }
    }
}
