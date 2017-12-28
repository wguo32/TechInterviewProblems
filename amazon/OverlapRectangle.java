/**
A rectangle is defined with two points, the upper left point and lower right point.
Point is a class with p.x, p.y;
*/
public class Solution {
    public boolean isOverlap(Point l1, Point r1, Point l2, Point r2) {
        if (l1.x> r2.x || r1.x < l2.x) {
            return false;
        }
        if (l1.y < l2.y || r1.y > l2.y) {
            return false;
        }
        return true;
    }
}
