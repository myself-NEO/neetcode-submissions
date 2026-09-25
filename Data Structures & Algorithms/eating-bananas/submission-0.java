class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // lets say I am eating with the speed of h
        // so ans will range between Max(piles[]) and 1

        int l=1, r= Arrays.stream(piles).max().orElse(0), ans = 0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(canEat(piles, h, mid)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean canEat(int[] piles, int time, int speed) {
        int t = 0;
        for(int x : piles) {
            // Equivalent to Math.ceil((double) x / speed) using pure integers
            t += (long) (x + speed - 1) / speed;
        }
        return t <= time;
    }
}
