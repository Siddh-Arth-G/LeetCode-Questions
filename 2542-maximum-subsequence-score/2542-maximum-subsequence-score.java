class Solution {
    static final int SHIFT = 20;
    static final long MASK = 0xF_FFFFL;
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        // Simultaneous sort of nums1 and nums2, sorting ascending 
        // by nums2.  Pack both nums1 and corresponding nums2 value 
        // into a single long, in an array of long, then sort that 
        // array of long.
        long[] nums21 = new long[n];
        for (int i = n - 1; i >= 0; i--) 
            nums21[i] = ((long)nums2[i] << SHIFT) | nums1[i];
        Arrays.sort(nums21);
        
        // Build a priority queue with lowest first, containing the 
        // k highest values from nums2.  Calculate a sum of the 
        // values in the priority queue.  The index of the highest 
        // possible min value from nums2, will be at index idx2 in 
        // the sorted nums21 array.  The highest k-1 values in nums2 
        // will never be a min value from nums2, so skip the highest 
        // k-1 values in nums2, and start min value testing at 
        // highest possible min value, which is at index n-k in the 
        // sorted nums21 array.
        PriorityQueue<Integer> kNumFromNums1 = new PriorityQueue(k + 1);
        long sumFromNums1 = 0;
        int idx21 = n - k;
        for (int i = idx21; i < n; i++) {
            sumFromNums1 += (nums21[i] & MASK);
            kNumFromNums1.add((int)(nums21[i] & MASK));
        }

        // For each possible min value from nums1 (index n-k...0 in nums21), 
        // test to see if the sum of the k highest available nums1 values 
        // will resultin the highest score.
        long result = sumFromNums1 * (nums21[idx21] >> SHIFT);
        while (--idx21 >= 0) {
            sumFromNums1 += (nums21[idx21] & MASK) - kNumFromNums1.poll();
            kNumFromNums1.add((int)(nums21[idx21] & MASK));
            result = Math.max(result, sumFromNums1 * (nums21[idx21] >> SHIFT));
        }
        return result;
    }
}