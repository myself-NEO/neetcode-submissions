class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();
        int nums = columnNumber;
        while(nums > 0) {
            int r = nums%26 == 0 ? 26 : nums%26;
            char x = (char) ('A' + r - 1);
            s.append(x);
            nums /= 26;
            if(r==26) nums--;
        }
        return s.reverse().toString();
    }
}