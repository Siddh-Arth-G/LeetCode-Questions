class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int size = arr.length;
        if(size == 0){
            return arr;
        }
        int[][] arr2 = new int[size][2];
        
        for(int i=0; i<size; i++){
            arr2[i] = new int[]{arr[i], i};
        }
        
        Arrays.sort(arr2, (a,b)->Integer.compare(a[0], b[0]));
        
        int rank = 1;
        int prev = arr2[0][0];
        for(int i=0; i<size; i++){
            if(prev != arr2[i][0]){
                prev = arr2[i][0];
                rank++;
            }
            arr[arr2[i][1]] = rank;
        }
        
        return arr;
    }
}