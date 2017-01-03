package array.queueandstack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.

 For example, Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Flatten2DVector {
    private List<Iterator<Integer>> list;
    private int cur;

    // Time: O(N) Space: O(N)
    public Flatten2DVector(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        for (List<Integer> vec : vec2d) {
            if (vec.size() > 0) {
                list.add(vec.iterator());
            }
        }
        cur = 0;
    }

    public Integer next() {
        if (!hasNext()) {
            return 0;
        }
        Integer res = list.get(cur).next();
        if (!list.get(cur).hasNext()) {
            cur++;
        }
        return res;
    }

    public boolean hasNext() {
        return cur < list.size() && list.get(cur).hasNext();
    }
}
