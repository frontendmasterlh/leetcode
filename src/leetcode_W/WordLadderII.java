package leetcode_W;

import java.util.*;

public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>> ();
        HashMap<String, Integer> level = new HashMap<String, Integer> ();
        HashSet<String> path = new HashSet<String> ();
        Queue<String> queue = new LinkedList<String> ();
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>> ();
        
        if (start== null || end == null || start.length() != end.length())
            return res;
            
        int min_value = Integer.MAX_VALUE;
        level.put(start, 1);
        visited.put(start, path);
        queue.offer(start);
        
        while (!queue.isEmpty()){
            String s = queue.poll();
            for (int i = 0; i< s.length(); i++) {
                StringBuilder sb = new StringBuilder (s);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String news = sb.toString();
                    if ((dict.contains(news) && !level.containsKey(news)) ||(level.containsKey(news) && level.get(news) > level.get(s))){
                        if (visited.containsKey(news)){
                            visited.get(news).add(s);
                        }else {
                            path = new HashSet<String> ();
                            path.add(s);
                            visited.put(news, path);
                            level.put(news, level.get(s)+1);
                            queue.offer(news);
                        }
                    }
                    if (news.equals(end)){//Because it can be found more than once.
                        if (level.get(s) < min_value){
                            ArrayList<String> entry = new ArrayList<String> ();
                            entry.add(end);
                            res.addAll(backTrace(visited, s, entry));
                            min_value = level.get(s) + 1;
                        }else {
                            break; //The path should be longer.
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    private ArrayList<ArrayList<String>> backTrace (HashMap<String, HashSet<String>> visited, String end, ArrayList<String> path){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>> ();
        ArrayList<String> entry = new ArrayList<String> (path);
        entry.add(0, end);
        if (visited.get(end).size() < 1){
            res.add(entry);
            return res;
        }
        
        for (String str : visited.get(end)) {
            res.addAll(backTrace(visited, str, entry));
        }
        
        return res;
    }
    
    static public void main (String[] argv){
    	Set<String> dict = new HashSet<String> ();
//    	dict.add("a");
//    	dict.add("b");
//    	dict.add("c");
//    	String start = "a";
//    	String end = "c";
    	dict.add("hot");
    	dict.add("cog");
    	dict.add("dog");
    	dict.add("hog");
    	dict.add("tot");
    	dict.add("hop");
    	dict.add("pot");
    	dict.add("dot");
    	String start = "hot";
    	String end = "dog";
    	
    	WordLadderII wl = new WordLadderII();
    	ArrayList<ArrayList<String>> res =  wl.findLadders(start, end, dict);
    	
    	for (ArrayList<String> v1 : res){
    		for (String v2 : v1){
    			System.out.print(v2 + " ");
    		}
    		System.out.println();
    	}
    }
}
