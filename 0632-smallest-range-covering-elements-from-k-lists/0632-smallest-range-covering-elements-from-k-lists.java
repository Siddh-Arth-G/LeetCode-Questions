// class Solution {
//     public int[] smallestRange(List<List<Integer>> nums) {
//         int[] range = new int[2];
//         range[0] = 0;
//         range[1] = Integer.MAX_VALUE;

//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

//         int max = Integer.MIN_VALUE;

//         for(int i=0; i<nums.size(); i++){
//             max = Math.max(max, nums.get(i).get(0));
//             pq.offer(new int[] {
//                 nums.get(i).get(0),
//                 0,
//                 i
//             });
//         }
//         while(true){
//             int[] minInfo = pq.poll();
//             int min = minInfo[0];
//             int row = minInfo[1];
//             int col = minInfo[2];
//             // int max = Integer.MIN_VALUE;
            
//             // int micColIndex = 0;

//             // for(int i=0; i<nums.size(); i++){
//             //     if(nums.get(i).get(indices[i]) < min) {
//             //         min = nums.get(i).get(indices[i]);
//             //         minColIndex = i;
//             //     }

//             //     max = Math.max(max, nums.get(i).get(indices[i]));
//             // }

//             if((max - min) < (range[1] - range[0])){
//                 range[0] = min;
//                 range[1] = max;
//             }

//             // indices[miColIndex]++;

//             if(row + 1 < nums.get(col).size()){
//                 pq.offer(new int[] {
//                     nums.get(col).get(row+1),
//                     row + 1,
//                     col
//                 });
//                 max = Math.max(max, nums.get(col).get(row+1));
//             }else{
//                 break;
//             }

//             // if(indices[minColIndex] == nums.get(minColIndex).size()){
//             //     break;
//             // }
//         }
//         return range;
//     }
// }



class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) {
            return new int[] { nums.get(0).get(0), nums.get(0).get(0) };
        }
        int k = nums.size();
        int minK = nums.get(0).get(0), minArr = 0;
        int maxK = nums.get(0).get(0), maxArr = 0;
        for (int i = 1; i < k; ++i) {
            List<Integer> list = nums.get(i);
            int val = list.get(0);
            if (val > maxK) {
                maxK = val;
                maxArr = i;
            }
            if (val < minK) {
                minK = val;
                minArr = i;
            }
        }
        int[] ret = new int[] { minK, maxK };
        int[] pos = new int[k];
        boolean done = false;
        int curListLen;
        while (!done) {
            List<Integer> curMinList = nums.get(minArr);
            pos[minArr]++;
            if (curMinList.size() == pos[minArr]) {
                done = true;
                continue;
            }
            int next = curMinList.get(pos[minArr]);
            minK = next;
            for (int i = 0; i < k; ++i) {
                curMinList = nums.get(i);
                curListLen = curMinList.size();
                for (int curIdx = pos[i]; curIdx < curListLen && curMinList.get(curIdx) <= next; curIdx++) {
                    pos[i] = curIdx;
                }
                int curVal = curMinList.get(pos[i]);
                if (curVal < minK) {
                    minK = curVal;
                    minArr = i;
                }
                if (curVal > maxK) {
                    maxK = curVal;
                    maxArr = i;
                }
            }
            if (maxK - minK < ret[1] - ret[0]) {
                ret[1] = maxK;
                ret[0] = minK;
            }
        }
        return ret;
    }
}