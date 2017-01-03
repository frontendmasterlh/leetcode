package leetcode_W;

import java.util.*;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        if (start.length() != end.length())
            return 0;
        if (start.equals(end))
            return 0;
        int min_value = 0;
        Queue<String> queue = new LinkedList<String> ();
        queue.offer (start);
        Set<String> unique = new HashSet<String> ();
        unique.add(start);
        
        int q1 = 1, q2 = 0;
        
        while (q1 >0){
            String s = queue.poll();
            --q1;
            
            for (int i = 0; i< s.length(); i++) {
                StringBuffer temp = new StringBuffer (s);
                for (char c='a'; c <='z'; c++){
                    temp.setCharAt(i, c);
                    if (dict.contains(temp.toString()) && !unique.contains(temp.toString())){
                        if (temp.toString().equals(end)){  // Notice: the type is StringBuffer, not String.
                            return min_value + 2;
                        }else {
                        	//System.out.println("temp: "+ temp);
                            unique.add(temp.toString());
                            queue.offer(temp.toString());
                            q2++;
                        }
                    }
                }
            }
            //System.out.println("Q1"+q1 +"Q2"+q2);
            if (q1==0){
                q1 = q2;
                q2 = 0;
                ++min_value;
            }
        }
        //System.out.println("!!!!");
        return 0;
    }
	
	static public void main (String[] argv) {
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String> ();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		System.out.println(new WordLadder().ladderLength(start, end, dict));
	}
}
