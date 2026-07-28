package io.zchiye.leetcode.exercise.top150.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc380RandomList {

    static class RandomizedSet {
        List<Integer> list;
        Map<Integer,Integer> map;
        int length;

        public RandomizedSet() {
            this.length = 0;
            this.list = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.get(val) != null) {
                return false;
            }
            map.put(val, length);
            list.add(val);
            length++;
            return true;
        }

        public boolean remove(int val) {
            if (map.get(val) == null) {
                return false;
            }
            int index = map.get(val);
            if (index == length - 1) {
                list.remove((int) index);
            } else {
                int newVal = list.get(length - 1);
                list.set(index, newVal);
                list.remove((int) length - 1);
                map.put(newVal, index);
            }
            map.remove(val);
            length--;
            return true;
        }

        public int getRandom() {
            int index = (int) (length * Math.random());
            return list.get(index);
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.getRandom());
    }
}
