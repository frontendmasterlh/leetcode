package leetcode_M;

import java.util.HashMap;
import java.util.Map;

//Definition for a point.
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
    }

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
        if (points==null || points.length==0)
            return 0;
        if (points.length==1)
            return 1;
        Map<Float, Integer> map = new HashMap<Float, Integer> ();
        int n = points.length;
        int max = 1;
        for (int i=0; i< n; i++) {
            int x = points[i].x;
            int y = points[i].y;
            int du = 0, localmax = 1;
            map.clear();
            map.put((float)Integer.MAX_VALUE, 0);
            for (int j=0; j<n; j++) {
                if (i!=j) {
                    int x1 = points[j].x;
                    int y1 = points[j].y;
                    if (x1==x && y1==y){
                        du++;
                    }else if (x1==x){
                        if (map.get((float)Integer.MAX_VALUE)==0)
                            map.put((float)Integer.MAX_VALUE, 2);
                        else                            
                            map.put((float)Integer.MAX_VALUE, map.get((float)Integer.MAX_VALUE)+1);
                    }else {
                        float k = (float)(y1 - y) / (float)(x1 - x);
                        if (map.containsKey(k)){//get可能为空。
                            map.put(k, (map.get(k) + 1));
                        }else {
                            map.put(k, 2); //两点成一线。
                        }
                    }
                }
            }
            for (Integer value : map.values()) {
                localmax = Math.max(localmax, value);
            }
            max = Math.max(max, localmax+du);
        }
        return max;
    }
	static public void main (String argv[]){
		Point[] points={new Point(), new Point(1,1), new Point(3,4), new Point(3,4)};
		System.out.println(new MaxPointsonaLine ().maxPoints(points));
	}
}
