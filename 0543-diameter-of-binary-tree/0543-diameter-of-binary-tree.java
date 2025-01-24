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
    int res=0;
    public int diaoft(TreeNode root)
    {
        if(root==null)return 0;
        int lh=diaoft(root.left);
        int rh=diaoft(root.right);
        res=Math.max(res,lh+rh);
       return 1+Math.max(lh,rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        diaoft(root);
        return res;
    }
}