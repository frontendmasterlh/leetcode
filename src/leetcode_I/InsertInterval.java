package leetcode_I;

import java.util.*;

class Interval{
	int start;
	int end;
	Interval () {this.start = 0; this.end = 0;}
	Interval(int s, int e) {this.start = s; this.end = e;}
}

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval> (); 
        if (newInterval==null || intervals==null)
            return intervals;
            
        if (intervals.size()==0){ //If arraylist is empty.
            res.add(newInterval);
            return res;
        }
        
        int i=0;
        int start = newInterval.start;
        int end = newInterval.end;
        for (i=0; i < intervals.size() && intervals.get(i).end < newInterval.start; i++){
            res.add(intervals.get(i));
        }
        if (i < intervals.size()) {
            start = Math.min(newInterval.start, intervals.get(i).start);
        }
        for (; i< intervals.size() && intervals.get(i).start <= end; i++){
            end = Math.max (end, intervals.get(i).end);
        }
        res.add(new Interval(start, end));
        for(; i<intervals.size(); i++){
            res.add(intervals.get(i));
        }
        return res;
    }
	
	static public void main (String[] argv) {
		;
	}
}
