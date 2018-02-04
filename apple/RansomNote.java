class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null ||
        magazine.length() == 0 && ransomNote.length() != 0) {
            return false;
        }
        int[] characters = new int[256];
        for (Character c : magazine.toCharArray()) {
            characters[c]++;
        }

        for (Character c : ransomNote.toCharArray()) {
            characters[c]--;
        }
        for (int num : characters) {
            if (num < 0) {
                return false;
            }
        }
        return true;
    }
}
