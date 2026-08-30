class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int n = s1.length();
        int l=0;
        for(int r=n-1; r<s2.length(); r++) {
            if(isPermutation(s1, s2.substring(l, r+1))) return true;
            l++;
        }
        return false;
    }

    private boolean isPermutation(String s1, String s2) {
        int[] alpha = new int[26];
        for(int i=0; i<s1.length(); i++) {
            alpha[s1.charAt(i)-'a']++;
            alpha[s2.charAt(i)-'a']--;
        }

        return Arrays.stream(alpha).allMatch(x -> x==0);
    }
}
