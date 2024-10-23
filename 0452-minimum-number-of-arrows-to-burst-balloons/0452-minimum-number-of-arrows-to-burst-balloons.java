// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));

//         int end = points[0][1];
//         int r = 0;
//         // [1,6] [2,8]
//         for(int i = 1; i < points.length; i++){
//             if(points[i][0] <= end){
//                 end = Math.min(end,points[i][1]);
//             }else{
//                 end = points[i][1];
//                 r++;
//             }
//         }
        
//         return r+1;
//     }
// }



class Solution {
    public int findMinArrowShots(int[][] points) {
        final int n = points.length;
        final long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            // A[i] = points[i][1] << 32 | points[i][0];
            A[i] = (((long)points[i][1]) << 32) | (points[i][0] & 0xFFFFFFFFL);
        }
        // for(int i = 0; i < points.length; i++){
            // A[i] = (((long)points[i][1]) << 32) | (points[i][0] & 0xFFFFFFFFL);
        // }
        Arrays.sort(A);
        int prev = (int)(A[0] >>> 32);
        int count = 1;
        for(int i=1; i< A.length; i++){
            if((int)A[i] > prev){
                count++;
                prev = (int)(A[i] >>> 32);
            }
        }
        return count;

    }
}