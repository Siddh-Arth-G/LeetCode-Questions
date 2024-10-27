// class Solution {
//     public int countSquares(int[][] matrix) {
//         int squares = 0;
//         int row = matrix.length;
//         int col = matrix[0].length;
//         int[][] dp = new int[row][col];
//         for(int r=0; r<row; r++){
//             for(int c=0; c<col; c++){
//                 if(matrix[r][c] == 1){
//                     if(r == 0 || c == 0){
//                         dp[r][c] = 1;
//                     }else{
//                         dp[r][c] = Math.min(dp[r-1][c], Math.min(dp[r][c-1], dp[r-1][c-1])) + 1;
//                     }
//                     squares +=  dp[r][c];
//                 }
//             }
//         }
//         return squares;
//     }
// }



class Solution {
    public int countSquares(int[][] matrix) {
        int rowSize  = matrix.length;
        int colSize = matrix[0].length;

        for(int i = 1; i < rowSize; i++)
        {
            for(int j = 1; j < colSize; j++)
            {
                if(matrix[i][j] == 1)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
            }
        }

        int total = 0;
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                total += matrix[i][j];
            }
        }

        return total;
    }
}