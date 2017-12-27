/**
problem from lintcode http://www.lintcode.com/en/problem/remove-substrings/#
*/
public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int minLen = s.length();

        queue.offer(s);
        set.add(s);

        while (!queue.isEmpty()) {
            String head = queue.poll();
            for (String str : dict) {
                int found = head.indexOf(str);
                while (found != -1) {
                    String newStr = head.substring(0, found) +
                                    head.substring(found + str.length());
                    if (!set.contains(newStr)) {
                        if (newStr.length() < minLen) {
                            minLen = newStr.length();
                        }
                        queue.offer(newStr);
                        set.add(newStr);
                    }
                    found = head.indexOf(str, found + 1);
                }
            }
        }
        return minLen;
    }
}
