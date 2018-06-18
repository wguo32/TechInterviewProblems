class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        for (int i = 0; i < 31; i++) {
            int digitX = x % 2;
            int digitY = y % 2;
            if (digitX != digitY) {
                dist++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return dist;
    }
}

// with OXR
class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int dist = 0;
        while (num > 0) {
            dist += num & 1;
            num >>= 1;
        }
        return dist;
    }
}
