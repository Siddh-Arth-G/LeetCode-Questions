// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     int count;
//     public int goodNodes(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         count = 0;
//         helper(root, root.val);
//         return count;
//     }

//     public void helper(TreeNode root, int max){
//         if(root == null){
//             return;
//         }
//         if(root.val >= max){
//             count++;
//             max = root.val;
//         }
//         helper(root.left, max);
//         helper(root.right, max);
//     }
// }





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
    int good = 0;
    public int goodNodes(TreeNode root) {
        goodNodes(root, root.val);
        return good;
    }
    public void goodNodes(TreeNode root, int max) {
        if (root == null) return;
        if(root.val >= max) {
            good++;
            max = root.val;
        }
        if (root.left != null) goodNodes(root.left, max);
        if (root.right != null) goodNodes(root.right, max);
    }
}