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
//     // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
//     Map<Long, Integer> hmap;
//     int count;

//     public int pathSum(TreeNode root, int targetSum) {
//         hmap = new HashMap<>();
//         count = 0;

//         dfs(root, 0, targetSum);

//         return count;
//     }

//     private void dfs(TreeNode root, long prefixSum, int targetSum) {
//         // base case
//         if (root == null) return;

        
//         prefixSum += root.val;
        
//         // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
//         if (hmap.containsKey(prefixSum-targetSum)) {
//             count += hmap.get(prefixSum-targetSum);
//         } 
        
//         // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
//         if (targetSum == prefixSum) {
//             count++;
//         }

//         // Update the prefixSum till current node and it's count
//         hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

//         // Recurse
//         dfs(root.left, prefixSum, targetSum);
//         dfs(root.right, prefixSum, targetSum);

//         // Backtrack
//         hmap.put(prefixSum, hmap.get(prefixSum) - 1);
        
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
    int count = 0;
    int k;
    HashMap<Long, Integer> h = new HashMap();
    
    public void preorder(TreeNode node, long currSum) {
        if (node == null)
            return;
        
        // The current prefix sum
        currSum += node.val;

        // Here is the sum we're looking for
        if (currSum == k)
            count++;
        
        // The number of times the curr_sum − k has occurred already, 
        // determines the number of times a path with sum k 
        // has occurred up to the current node
        count += h.getOrDefault(currSum - k, 0);
        
        //Add the current sum into the hashmap
        // to use it during the child node's processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // Process the left subtree
        preorder(node.left, currSum);

        // Process the right subtree
        preorder(node.right, currSum);

        // Remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }    
            
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }
}