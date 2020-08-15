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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }
    
    public TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (inEnd > inStart || postStart < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = inStart;
        
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                index = i;
                break;
            }
        }
        
        System.out.println("*************************");
        System.out.println("index: " + index);
        System.out.println("inStart: " + inStart);
        System.out.println("inEnd: " + inEnd);
        System.out.println("postStart: " + postStart);
        System.out.println("*************************");
        
        root.left = constructTree(inorder, index - 1, inEnd, postorder, postStart - (inStart - index) - 1);
        root.right = constructTree(inorder, inStart, index + 1, postorder, postStart - 1);
        
        return root;
    }
}