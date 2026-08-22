class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        for(char x : strs[0].toCharArray()) {
            for(int i=1; i<strs.length; i++) {
                if(strs[i].length() <= idx || strs[i].charAt(idx)!=x){
                    return ans.toString();
                }
            }
            ans.append(x);
            idx++;
        }
        return ans.toString();
    }
}