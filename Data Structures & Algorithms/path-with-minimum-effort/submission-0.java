class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] effort = new int[rows][cols];
        for(int[] x : effort) Arrays.fill(x, Integer.MAX_VALUE);
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c=curr[1], d=curr[2];
            if(d > effort[r][c]) continue;
            for(int[] dir : dirs) {
                int dr = r + dir[0];
                int dc = c + dir[1];
                if(dr>=0 && dr<rows && dc>=0 && dc<cols) {
                    int w = Math.abs(heights[r][c] - heights[dr][dc]);
                    int maxEffort = Math.max(d, w);
                    if(effort[dr][dc] > maxEffort){
                        effort[dr][dc] = maxEffort;
                        pq.offer(new int[]{dr, dc, maxEffort});
                    }
                }
            }
        }
        return effort[rows-1][cols-1];
        
    }
}