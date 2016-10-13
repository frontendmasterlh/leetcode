package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class InsertDeleteGetRandomBigOOneDuplicatesAllowed {

    HashMap<Integer, Set<Integer>> map;
    List<Integer> nums;
    int size;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomBigOOneDuplicatesAllowed() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        size = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        if (map.containsKey(val)) {
            res = false;
        } else {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(size);
        nums.add(val);
        size += 1;
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.isEmpty() || !map.containsKey(val)) {
            return false;
        }

        size -= 1;
        int lastNum = nums.get(size);
        Set<Integer> idxSet = map.get(val);
        if (lastNum != val) {
            int idx = idxSet.iterator().next();
            Set<Integer> lastNumIdxSet = map.get(lastNum);
            lastNumIdxSet.remove(size);
            lastNumIdxSet.add(idx);
            nums.set(idx, lastNum);
        }

        if (idxSet.size() == 1) {
            map.remove(val);
        } else {
            idxSet.remove(size);
        }

        nums.remove(size);
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(size));
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
