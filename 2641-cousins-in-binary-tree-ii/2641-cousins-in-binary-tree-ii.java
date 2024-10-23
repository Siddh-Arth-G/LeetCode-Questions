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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int levelSum = 0;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();

                levelSum += node.val;

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
            list.add(levelSum);
        }

        root.val = 0;
        int levelIdx = 1;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int sibSum = 0;

                TreeNode node = q.remove();

                if(node.left != null){
                    sibSum += node.left.val;
                }
                if(node.right != null){
                    sibSum += node.right.val;
                }

                if(node.left != null){
                    node.left.val = list.get(levelIdx) - sibSum;
                }
                if(node.right != null){
                    node.right.val = list.get(levelIdx) - sibSum;
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            levelIdx++;
        }
        return root;
    }
}