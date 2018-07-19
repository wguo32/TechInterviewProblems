class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        HashSet<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        hash.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                ArrayList<String> expansion = expand(dict, word);
                for (String w : expansion) {
                    if (hash.contains(w)) {
                        continue;
                    }
                    if (w.equals(endWord)) {
                        return length;
                    }
                    hash.add(w);
                    queue.offer(w);
                }
            }
        }
        return 0;
    }

    private ArrayList<String> expand(Set<String> dict, String word) {
        ArrayList<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, c, i);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

    private String replace(String word, char ch, int index) {
        char[] chars = word.toCharArray();
        chars[index] = ch;
        // return chars.toString();
        return new String(chars);
    }
}
