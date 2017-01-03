package leetcode_S;

import java.util.*;

public class SimplifyPath {
    String res;
    Stack<String> stack;
    private void createStack (String path) {
        String name="";
        for (int i=0; i< path.length(); i++) {
            if (path.charAt(i)=='/'){
                if (!name.isEmpty()){
                    if (name.charAt(0)=='.' && name.length()==2 && name.charAt(1)=='.'){
                        if (!stack.isEmpty()){
                            stack.pop();
                        }
                    }else if (!(name.charAt(0)=='.' && name.length()==1)){
                        stack.push(name);
                    }
                }
                name="";
            }else {
                name = name + path.charAt(i);
            }
        }
        if (path.charAt(path.length()-1) != '/'){//Consider this condition that the last char is not '/'.
            if (!name.isEmpty()){
                                if (name.charAt(0)=='.' && name.length()==2 && name.charAt(1)=='.'){
                                    if (!stack.isEmpty()){
                                        stack.pop();
                                    }
                                }else if (!(name.charAt(0)=='.' && name.length()==1)){
                                    stack.push(name);
                                }
            }
        }
    }
    
    private void createString () {
        
        while (!stack.isEmpty()){
            res = stack.pop() + '/' +res;
        }
        if (!res.isEmpty())//Delete the last '/' that added manually.
            res = res.substring(0, res.length()-1);
        res = '/' + res;
    }
    
    public String simplifyPath(String path) {
        stack = new Stack<String> ();
        createStack (path);
        res="";
        createString ();
        return res;
    }
    
//	public String simplifyPath(String path) {// We can also use split to get the
//												// value.
//		StringBuilder sb = new StringBuilder();
//		sb.append("/");
//		String[] stubs = path.split("/+"); // 正则 碰到不管几个/都分割一次
//		ArrayList<String> paths = new ArrayList<String>();
//		for (String s : stubs) {
//			if (s.equals("..")) {
//				if (paths.size() > 0) {
//					paths.remove(paths.size() - 1);
//				}
//			} else if (!s.equals(".") && !s.equals("")) {
//				paths.add(s);
//			}
//		} // for循环结束 path 完成
//
//		for (String string : paths) {
//			sb.append(string).append("/");
//		}
//		if (sb.length() > 1) { // 最后会多append一个 "/"
//			sb.deleteCharAt(sb.length() - 1);
//		}
//		return sb.toString();
//	}
    
    static public void main (String[] argv){
    	;
    }
}
