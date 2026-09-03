class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().getAsInt(), hi = Arrays.stream(weights).sum();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(weights, days, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean isPossible(int[] weights, int days, int cap) {
        int d = 1, sum=0;
        for(int x : weights) {
            if(sum + x > cap) {
                sum = 0;
                d++;
            }
            sum += x;
        }
        return d<=days;
    }
}