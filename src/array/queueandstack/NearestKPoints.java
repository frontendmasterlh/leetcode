package array.queueandstack;

import java.util.*;

public class NearestKPoints {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Distance {
        double d;
        Point p;
        public Distance(double d, Point p) {
            this.d = d;
            this.p = p;
        }
    }

    // Time: O(nlogk) Space: O(klogk)
    public List<Point> nearestKPoint_1(List<Point> list, final Point center, int k) {
        List<Point> res = new ArrayList<>();
        if (list == null || list.size() == 0 || center == null || k <= 0) {
            return res;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(getDistance(o2, center), getDistance(o1, center));
            }
        });
        for (Point point : list) {
            if (pq.size() < k) {
                pq.offer(point);
            } else {
                Point top = pq.peek();
                if (getDistance(top, center) > getDistance(point, center)) {
                    pq.poll();
                    pq.offer(point);
                }
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    private double getDistance(Point p1, Point p2) {
        return (p1.y - p2.y) * (p1.y - p2.y) + (p1.x - p2.x) * (p1.x - p2.x);
    }

    // Time: average: O(n) worst case: O(n^2) Space: O(n)
    public List<Point> nearestKPoint_2(List<Point> list, final Point center, int k) {
        List<Point> res = new ArrayList<>();
        if (list == null || list.size() == 0 || center == null || k <= 0) {
            return res;
        }
        Distance[] distances = new Distance[list.size()];
        for (int i = 0; i < list.size(); i++) {
            distances[i] = new Distance(getDistance(list.get(i), center), list.get(i));
        }
        quickSelect(distances, k);
//        for (Distance d : distances) {
//            System.out.println(d.p.x + " " + d.p.y + " " + d.d);
//        }
        for (int i = 0; i < k; i++) {
            res.add(distances[i].p);
        }
        return res;
    }

    private void quickSelect(Distance[] distances, int k) {
        int start = 0, end = distances.length - 1;
        while (start < end) {
            int p = partition(distances, start, end);
            if (p == k) {
                return;
            } else if (p < k) {
                start = p + 1;
            } else {
                end = p - 1;
            }
        }
    }

    private int partition(Distance[] distances, int start, int end) {
        int pivotIndex = findPivot(start, end);
        Distance pivot = distances[pivotIndex];
        swap(distances, pivotIndex, end);
        int left = start;
        int right = end -1;
        while (left < right) {
            if (distances[left].d < pivot.d) {
                left++;
            } else if (distances[right].d >= pivot.d) {
                right--;
            } else {
                swap(distances, left++, right--);
            }
        }
        swap(distances, end, left);
        return left;
    }

    private int findPivot(int start, int end) {
        return start + new Random().nextInt(end - start + 1);
    }

    private void swap(Distance[] distances, int i, int j) {
        Distance temp = distances[i];
        distances[i] = distances[j];
        distances[j] = temp;
    }

    public static void main(String[] args) {
        NearestKPoints n = new NearestKPoints();
        List<Point> list = new ArrayList<>();
        list.add(new Point(1, 1));
        list.add(new Point(2, 1));
        list.add(new Point(2, 2));
        List<Point> res = n.nearestKPoint_1(list, new Point(0,0), 2);
        for (Point point : res) {
            System.out.println(point.x + " " + point.y);
        }
        List<Point> res2 = n.nearestKPoint_2(list, new Point(0,0), 2);
        for (Point point : res2) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
