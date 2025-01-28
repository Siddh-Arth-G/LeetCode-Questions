class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // int rows = mat.length, cols = mat[0].length;
        // Map<Integer, int[]> positionMap = new HashMap<>();
        // int[] rowCount = new int[rows];
        // int[] colCount = new int[cols];
        // Arrays.fill(rowCount, cols);
        // Arrays.fill(colCount, rows);
        // for (int r = 0; r < rows; ++r) {
        //     for (int c = 0; c < cols; ++c) {
        //         positionMap.put(mat[r][c], new int[]{r, c});
        //     }
        // }
        // for (int idx = 0; idx < arr.length; ++idx) {
        //     int[] pos = positionMap.get(arr[idx]);
        //     if (--rowCount[pos[0]] == 0 || --colCount[pos[1]] == 0) {
        //         return idx;
        //     }
        // }
        // return -1;


        int row = mat.length;
        int col = mat[0].length;
        Map<Integer, int[]> pos = new HashMap<>();
        
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                pos.put(mat[i][j], new int[]{i, j});
        
        int[] rCnt = new int[row];
        int[] cCnt = new int[col];
        
        for(int i = 0; i < arr.length; i++) {
            int[] p = pos.get(arr[i]);
            rCnt[p[0]]++;
            cCnt[p[1]]++;
            if(rCnt[p[0]] == col || cCnt[p[1]] == row)
                return i;
        }
        return arr.length -1;
    }

}