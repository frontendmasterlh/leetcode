package leetcode_M;

import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {
	private class IntervalComparator implements Comparator<Interval> {
        public int compare (Interval o1, Interval o2) {
            if (o1.start < o2.start)
                return -1;
            else if (o1.start > o2.start)
                return 1;
            else
                return 0;
        }
    } 
    
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval> ();
        if (intervals==null || intervals.size()<=1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare (Interval o1, Interval o2) {
            if (o1.start < o2.start)
                return -1;
            else if (o1.start > o2.start)
                return 1;
            else
                return 0;
            }
        });//new IntervalComparator()
        
        Interval prev = intervals.get(0);
        for (int i=1; i< intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= prev.end){
                if (cur.end > prev.end) {
                    prev.end = cur.end;
                }
            }else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);
        return res;
    }
    
    static public void main (String argv[]){
    	
    }
}
