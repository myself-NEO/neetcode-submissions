class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;

        double ans = 1;
        long y = Math.abs((long)n);

        while(y > 0) {
            if((y&1)==1) ans *= x;

            x *= x;
            y >>= 1;
        }

        return n>0 ? ans : 1/ans;
    }
}
 