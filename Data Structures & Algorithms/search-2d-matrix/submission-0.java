class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length, col=matrix[0].length;
        int l=0, r=row*col-1;
        while(l<=r) {
            int mid = l + (r-l)/2;

            int rows = mid/col;
            int cols = mid%col;

            int val = matrix[rows][cols];
            if(target==val) return true;
            else if(target < val) r = mid-1;
            else l = mid+1;
        }
        return false;
    }
}
