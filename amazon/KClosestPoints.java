/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Queue<Point> heap = new PriorityQueue<>(k, new Comparator<Point>(){
            public int compare(Point a, Point b) {
                int distA = distance(a, origin);
                int distB = distance(b, origin);
               if (distA == distB) {
                    if (a.x == b.x) {
                        return b.y - a.y;
                    }
                    return b.x - a.x;
                } else if (distA > distB) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < points.length; i++) {
            // there is no need to check if the point to be offered is larger or not,
            // just push it and then throw away the one on the top if heap size is > k
            // if (heap.size() >= k) {
            //     if (distance(heap.peek(), origin) > distance(points[i], origin)) {
            //         heap.poll();
            //     }
            // }
            heap.offer(points[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        Point[] result = new Point[k];
        int index = heap.size() - 1;
        while (!heap.isEmpty()) {
            Point p = heap.poll();
            result[index--] = p;
        }
        return result;
    }

    public int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
