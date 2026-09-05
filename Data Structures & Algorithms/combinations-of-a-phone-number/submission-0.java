class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        bt(map, digits, new StringBuilder(), 0, ans);
        return ans;
    }

    private void bt(Map<Character, String> map, String digits, StringBuilder curr, int idx, List<String> ans) {
        if(curr.length()==digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String x = map.get(digits.charAt(idx));
        for(char c : x.toCharArray()) {
            curr.append(c);
            bt(map, digits, curr, idx+1, ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
