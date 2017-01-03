package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetRandomBigOOne {
    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomBigOOne() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, map.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            Integer idx = map.remove(val);
            if (idx < list.size() - 1) {
                list.set(idx, list.get(list.size() - 1));
                map.put(list.get(list.size() - 1), idx);
            }
            list.remove(list.size() - 1);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomBigOOne i = new InsertDeleteGetRandomBigOOne();
        System.out.println(i.insert(1));
        System.out.println(i.getRandom());
        System.out.println(i.insert(1));
        System.out.println(i.insert(2));
        System.out.println(i.getRandom());
        System.out.println(i.remove(2));
        System.out.println(i.getRandom());
    }
}
