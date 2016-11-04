package array.dfs;

import java.util.ArrayList;
import java.util.List;

import array.queueandstack.FlattenNestedListIterator;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up.
 i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

 Example 1:Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

 Example 2:
 Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 13 + 42 + 6*1 = 17)
 */
public class NestedListWeightSumII {
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int intSum) {
        List<NestedInteger> nextLevel = new ArrayList<>();
        int listSum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                nextLevel.addAll(ni.getList());
            }
        }
        listSum = nextLevel.isEmpty() ? 0 : helper(nextLevel, intSum);
        return intSum + listSum;
    }
}
