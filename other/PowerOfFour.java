/* there are two characters:
    first, there is only one bit 1 in the binary for those number which is power of 4
    second, there are even number of trailing 0s in the binary form
*/

class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 &&
                (Integer.toBinaryString(num).length() - 1) % 2 == 0;
    }
}
