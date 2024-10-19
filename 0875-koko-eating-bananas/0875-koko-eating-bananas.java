// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int l = 0, r = 1;
        
//         while (!good(piles, h, r)) {
//             r *= 2;
//         }
        
//         while (r > l + 1) {
//             int mid = (r + l) >>> 1;
//             if (good(piles, h, mid)) {
//                 r = mid;
//             } else {
//                 l = mid;
//             }
//         }
        
//         return r;
//     }
    
//     private boolean good(int[] piles, int h, int x) {
//         long hours = 0;
//         for (int i : piles) {
//             hours += (i + x - 1) / x;
//         }
//         return hours <= h;
//     }
// }




class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for(int p : piles){
            total += p;
        }
        int left = (int) ((total - 1) / h) + 1;
        int right = (int) ((total - n) / (h - n + 1)) + 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}