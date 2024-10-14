// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];
//         int countPro = 0;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 countPro++;
//                 dfs(isConnected, visited, i);
//             }
//         }
//         return countPro;
//     }

//     private void dfs(int[][] isConnected, boolean[] visited, int i) {
//         visited[i] = true;
//         for (int j = 0; j < isConnected.length; j++) {
//             if (isConnected[i][j] == 1 && !visited[j]) {
//                 dfs(isConnected, visited, j);
//             }
//         }
//     }
// }




class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                cnt++;
                dfs(arr, i, vis);
            }
        }
        return cnt;
    }

    private void dfs(int[][] arr, int i, boolean[] vis){
        for(int j=0; j<arr[i].length; j++){
            if(!vis[j] && arr[i][j] != 0 && j!= i){
                vis[j] = true;
                dfs(arr, j , vis);
            }
        }
    }
}