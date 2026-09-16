class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] arr = new int[n];
        for(int i=1; i<n; i++) arr[i] = prices[i] - prices[i-1];

        int ans = 0;
        for(int x : arr) {
            if(x > 0) ans += x;
        }

        return ans;
    }
}