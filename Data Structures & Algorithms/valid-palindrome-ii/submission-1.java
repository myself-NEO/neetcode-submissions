class Solution {
    public boolean validPalindrome(String s) {
        int l=0, r=s.length()-1;
        while(l<r) {
            if(s.charAt(l)==s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s.substring(l+1, r+1)) || isPalindrome(s.substring(l, r));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}