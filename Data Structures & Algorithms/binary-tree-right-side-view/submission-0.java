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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(null==root) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            boolean flag = true;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(flag) ans.add(curr.val);
                flag = false;
                if(curr.right != null) q.offer(curr.right);
                if(curr.left != null) q.offer(curr.left);
            }
        }
        return ans;
    }
}
