package array.array;

import java.util.Stack;

/**
 * Suppose we abstract our file system by a string in the following manner:

 The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

 dir
 subdir1
 subdir2
 file.ext
 The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

 The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

 dir
 subdir1
 file1.ext
 subsubdir1
 subdir2
 subsubdir2
 file2.ext
 The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

 We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

 Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

 Note:
 The name of a file contains at least a . and an extension.
 The name of a directory or sub-directory will not contain a ..
 Time complexity required: O(n) where n is the size of the input string.

 Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String[] arr = input.split("\n");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int level = findLevel(arr[i]);

            while (!stack.isEmpty() && stack.size() >= level) {
                String top = stack.pop();
                int start = sb.length() - 1 - top.length();
                sb.replace(start, start + top.length() + 1, "");
            }

            String newStr = arr[i].substring(level - 1);
            stack.push(newStr);
            sb.append(newStr).append("/");

            if (isFile(arr[i])) {
                max = Math.max(max, sb.length() - 1);
            }
        }
        return max;
    }

    private int findLevel(String str) {
        int count = 0;
        int index = 0;
        while (index < str.length() - 1 && str.charAt(index) == '\t') {
            count++;
            index++;
        }
        return count + 1;
    }

    private boolean isFile(String str) {
        return str.contains(".");
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath l = new LongestAbsoluteFilePath();
        String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(l.lengthLongestPath(str));
    }
}
