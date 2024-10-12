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
//     List<Integer> list = new ArrayList<>();
//     public int maxLevelSum(TreeNode root) {
//         helper(root,0);
//         int max = list.get(0) , level = 1;
//         for(int i = 0; i < list.size(); i++){
//             if(list.get(i) > max){
//                 max = list.get(i);
//                 level = i+1;
//             }
//         }
//         return level;
//     }
//     public void helper(TreeNode root , int level){
//         if(root == null) return;
//         if(list.size() <= level) list.add(root.val);
//         else{
//             list.set(level , list.get(level)+root.val);
//         }
//         helper(root.right , level+1);
//         helper(root.left , level+1);
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
    int maxLevel = 0;
    int[] array = new int[100];
    public int maxLevelSum(TreeNode root) {
        recursion(root, 1);
        int max = array[1];
        int index = 1;
        for (int i = 2; i <= maxLevel; i++){
            if (array[i] > max){
                index = i;
                max = array[i];
            }
        }
        return index;
    }

    public void recursion(TreeNode root, int level) {
        if (level >= array.length){
            resize();
        }
        array[level] = array[level] + root.val;
        maxLevel = Math.max(maxLevel, level);
        if (root.left != null){
            recursion(root.left, level + 1);
        }
        if (root.right != null){
            recursion(root.right, level + 1);
        }
    }

    public void resize(){
        int[] array1 = new int[array.length * 10];
        for(int i = 0; i < array.length; i++){
            array1[i] = array[i];
        }
        array = array1;
    }
}