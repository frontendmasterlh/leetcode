package leetcode_S;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        Map<String, Integer> needfind = new HashMap<String, Integer> ();
        Map<String, Integer> hasfind = new HashMap<String, Integer> ();
        
        int listsize = L.length;
        int wordsize = L[0].length();
        int i=0, j=0;
        for (i = 0; i< listsize; i++) {
            if (needfind.get(L[i])==null)
                needfind.put (L[i], 1);
            else 
                needfind.put (L[i], needfind.get(L[i]) + 1);
        }
        
        for (i = 0; i <= S.length() - listsize * wordsize; i++) {//i means the starting point in S
            hasfind.clear ();
            for (j = 0; j < listsize; j++) {//j means the starting point of the word in L
                String temp = S.substring(i + j * wordsize, i + (j+1) * wordsize);
                if (needfind.get(temp) != null) {
                    if (hasfind.get(temp)!=null){
                        hasfind.put (temp, hasfind.get(temp) +1);
                    }else
                        hasfind.put (temp, 1);
                    if (hasfind.get(temp) > needfind.get(temp))
                        break;
                }else
                    break;
            }
            if (j==listsize)//It has passed all the check.
                res.add(i);
        }
        return res;
    }
	
	static public void main (String[] argv) {
		;
	}
}
