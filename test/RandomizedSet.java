package test;

import java.util.*;

class RandomizedSet {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    Random random = new Random();
    public RandomizedSet() {
    }
    
    public boolean insert(int val) {
        if(this.hashMap.containsKey(val)){
            return false;
        }else {
            list.add(val);
            hashMap.put(val,list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(this.hashMap.containsKey(val)){
            int index = this.hashMap.get(val);
            list.set(index, list.get(list.size()-1));
            list.remove(list.size()-1);
            this.hashMap.remove(val);
            this.hashMap.put(list.get(index), index);
            return true;
        }else {
            return false;
        }
    }
    
    public int getRandom() {
        int randomNumber = random.nextInt(list.size()-1);
        return list.get(randomNumber);
    }
}