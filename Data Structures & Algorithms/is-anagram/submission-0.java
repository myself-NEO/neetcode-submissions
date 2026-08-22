class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        for(char x : s.toCharArray()) {
            letters[x-'a']++;
        }
        for(char x : t.toCharArray()) {
            letters[x-'a']--;
        }
        for(int x : letters) {
            if(x != 0) return false;
        }
        return true;
    }
}
