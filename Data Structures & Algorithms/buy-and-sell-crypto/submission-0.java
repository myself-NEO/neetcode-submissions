class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int l=0, r=1;
        int ans = 0;
        while(r < prices.length) {
            if(prices[l] < prices[r]) ans = Math.max(ans, prices[r]-prices[l]);
            else l = r;
            r++;
        }
        return ans;
    }
}
