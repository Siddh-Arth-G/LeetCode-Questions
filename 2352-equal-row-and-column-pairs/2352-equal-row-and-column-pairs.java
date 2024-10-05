// class Solution {
//     public int equalPairs(int[][] grid) {
//         int count = 0;
//         for(int r=0; r<grid.length; r++){
//             for(int c=0; c<grid.length; c++){
//                 boolean isPair = true;
//                 for(int i=0; i<grid.length; i++){
//                     if(grid[r][i] != grid[i][c]){
//                         isPair = false;
//                         break;
//                     }
//                 }
//                 if(isPair) count++;
//             }
//         }
//         return count;
//     }
// }




// class Solution {
//     public int equalPairs(int[][] grid) {
//         int n = grid.length;
//         int count = 0;
//         Map<String, Integer> map = new HashMap<>();

//         for(int[] row: grid){
//             String rowStr = Arrays.toString(row);
//             map.put(rowStr, map.getOrDefault(rowStr, 0)+1);
//         }
//         for(int j=0; j<n; j++){
//             int[] col = new int[n];
//             for(int i=0; i<n; i++){
//                 col[i] = grid[i][j];
//             }
//             count += map.getOrDefault(Arrays.toString(col),0);
//         }
//         return count;
//     }
// }





class Solution {
    public int equalPairs(int[][] grid) {
        int pairs = 0;
        int[] nums = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums[j] = grid[j][i];
            }
            for (int[] array : grid) {
                if (Arrays.equals(array, nums)) {
                    pairs++;
                }
            }
        }

        return pairs;
    }
}