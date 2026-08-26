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
    public boolean isValidBST(TreeNode root) {
        //  A tree is a BST if its inorder traversal is sorted

        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);

        for(int i=0; i<ans.size()-1; i++) {
            if(ans.get(i)>=ans.get(i+1)) return false;
        }

        return true;
    }

    public void dfs(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
}
