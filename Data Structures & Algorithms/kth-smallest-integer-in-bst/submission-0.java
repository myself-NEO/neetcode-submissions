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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, k);
        return ans.get(k-1);
    }

    public void dfs(TreeNode root, List<Integer> ans, int k) {
        if(root==null || ans.size()>=k) return;
        dfs(root.left, ans, k);
        ans.add(root.val);
        dfs(root.right, ans, k);
    }
}
