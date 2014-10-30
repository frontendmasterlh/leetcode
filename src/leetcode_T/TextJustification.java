package leetcode_T;

import java.util.*;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String> ();
        if (words==null || L < 0)
            return res;
        int begin = 0;
        while (begin < words.length){
            int idx = begin;
            int cursize = 0;
            while (idx < words.length) {
                int tempsize  = cursize==0 ? words[idx].length() : cursize + 1 + words[idx].length();
                if (tempsize <= L){
                    cursize = tempsize;
                }else
                    break;
                idx++;
            }
            int end = idx -1;
            int eachspace = 0;
            int remainspace = L - cursize;
            if (end != begin && end != words.length -1){
                eachspace = remainspace / (end - begin);
                remainspace = remainspace % (end - begin);
            }else {
                eachspace = 0;
            }
            
            StringBuffer line = new StringBuffer ();
            for (int i = begin; i<= end; i++){
                if (i==begin)
                    line.append(words[i]);
                else {
                    line.append(" ");
                    for (int j =0; j< eachspace; j++)
                        line.append(" ");
                    if (remainspace >0 && end != words.length -1){
                        line.append(" ");
                        remainspace--;
                    }
                    line.append(words[i]);
                }
            }
            while (remainspace > 0){
                line.append(" ");
                remainspace--;
            }
            res.add(line.toString());
            begin = end + 1;
        }
        return res;
    }
	
	static public void main (String[] argv) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int L = 16;
		ArrayList<String> res = new TextJustification().fullJustify(words, L);
		for (String v : res) {
			System.out.println(v);
		}
	}
}
