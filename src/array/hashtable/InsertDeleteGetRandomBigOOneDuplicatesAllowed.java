package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class InsertDeleteGetRandomBigOOneDuplicatesAllowed {

    Map<Integer, HashSet<Integer>> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomBigOOneDuplicatesAllowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        HashSet<Integer> set = map.get(val);
        if (set == null) {
            set = new LinkedHashSet<>();
            map.put(val, set);
        }
        set.add(list.size());
        map.put(val, set);
        list.add(val);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) return false;
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if (loc < list.size() - 1) {
            int lastone = list.get(list.size() - 1);
            list.set(loc, lastone);
            map.get(lastone).remove(list.size() - 1);
            map.get(lastone).add(loc);
        }
        list.remove(list.size() - 1);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomBigOOneDuplicatesAllowed i = new InsertDeleteGetRandomBigOOneDuplicatesAllowed();
        System.out.println(i.insert(1));
        System.out.println(i.insert(1));
        System.out.println(i.insert(2));
        System.out.println(i.insert(2));
        System.out.println(i.insert(3));
        System.out.println(i.insert(3));
        System.out.println(i.remove(1));
        System.out.println(i.remove(1));
        System.out.println(i.remove(3));
        System.out.println(i.remove(3));
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
        System.out.println(i.getRandom());
    }

}
