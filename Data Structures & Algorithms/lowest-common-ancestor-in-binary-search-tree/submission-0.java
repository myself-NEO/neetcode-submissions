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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        findpath(root, p, ppath);

        List<TreeNode> qpath = new ArrayList<>();
        findpath(root, q, qpath);

        int i=0;
        while(i<ppath.size() && i<qpath.size()) {
            if(ppath.get(i).val==qpath.get(i).val) i++;
            else break;
        }

        return ppath.get(i-1);
    }

    public boolean findpath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if(root == null) return false;
        path.add(root);
        if(root == p) return true;
        if(findpath(root.left, p, path) || findpath(root.right, p, path)) return true;
        path.remove(path.size()-1);
        return false;
    }
}
