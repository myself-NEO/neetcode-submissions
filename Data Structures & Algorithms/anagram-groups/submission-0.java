class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            int[] freq = new int[26];
            for(char x : s.toCharArray()) freq[x-'a']++;
            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> e : map.values()) {
            ans.add(e);
        }
        return ans;
    }
}
