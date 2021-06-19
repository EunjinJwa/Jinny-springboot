package com.jinny.java.springboot.lottery.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LuckyNumberType {

    String key;
    int count;
    HashMap<Integer, List<Integer>> numberMap;

    public LuckyNumberType(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public HashMap<Integer, List<Integer>> getNumberMap() {
        return numberMap;
    }

    public void setNumberMap(HashMap<Integer, List<Integer>> numberMap) {
        this.numberMap = numberMap;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuffer resultString = new StringBuffer("Good luck for you !! \n");
        Iterator<Integer> keys = numberMap.keySet().iterator();
        while (keys.hasNext()) {
            Integer key = keys.next();
            List<Integer> numberList = numberMap.get(key);

            resultString.append(String.format("%d set : %s\n", key, Constants.convertListToString(numberList)));
        }

        return resultString.toString();
    }


}
