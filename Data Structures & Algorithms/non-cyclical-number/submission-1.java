class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1) {
            int sum = sum(n);
            if(sum==1) return true;
            if(set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }

    private int sum(int n) {
        int s = 0;
        while(n>0) {
            int r = n%10;
            s += r*r;
            n /= 10;
        }
        return s;
    }
}
