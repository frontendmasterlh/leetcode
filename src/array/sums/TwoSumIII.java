package array.sums;

import java.util.HashMap;
import java.util.Map;

/*
* Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*
* */
public class TwoSumIII {
    Map<Integer, Integer> map = new HashMap<>();

    public void add(int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    public boolean find(int num) {
        for (Integer key : map.keySet()) {
            int left = num - key;
            if (map.containsKey(left)) {
                if (left == key && map.get(key) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIII twoSumIII = new TwoSumIII();
        twoSumIII.add(1);
        twoSumIII.add(2);
        System.out.println(twoSumIII.find(4));
        twoSumIII.add(2);
        System.out.println(twoSumIII.find(4));
    }
}
