package array.queueandstack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by jli1 on 10/27/16.
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }


    private Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger top = stack.pop();
        return top.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            List<NestedInteger> top = stack.pop().getList();
            for (int i = top.size() - 1; i >= 0; i--) {
                stack.push(top.get(i));
            }
        }
        return false;
    }
}
