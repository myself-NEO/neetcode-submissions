class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l=0, r=arr.length-k;
        while(l < r) {
            int m = l + (r-l)/2;
            if(Math.abs(x - arr[m]) > Math.abs(x - arr[m+k])) l = m+1;
            else r = m;
        }
        for(int i=l; i<l+k; i++) ans.add(arr[i]);

        return ans;
    }
}