/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, root.val));
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode curr = p.getKey();
                int v = p.getValue();
                if(curr.val >= v) {
                    ans++;
                }
                int nextMax = Math.max(v, curr.val);
                if(curr.left != null) {
                    q.offer(new Pair<>(curr.left, nextMax));
                }
                if(curr.right != null) {
                    q.offer(new Pair<>(curr.right, nextMax));
                }
            }
        }
        return ans;
    }
}
