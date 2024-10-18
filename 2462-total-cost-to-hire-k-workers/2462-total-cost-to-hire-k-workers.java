// class Solution {
//     public long totalCost(int[] costs, int k, int candidates) {
//         int i = 0;
//         int j = costs.length - 1;
//         PriorityQueue<Integer> pq1 = new PriorityQueue<>();
//         PriorityQueue<Integer> pq2 = new PriorityQueue<>();

//         long ans = 0;
//         while (k-- > 0) {
//             while (pq1.size() < candidates && i <= j) {
//                 pq1.offer(costs[i++]);
//             }
//             while (pq2.size() < candidates && i <= j) {
//                 pq2.offer(costs[j--]);
//             }

//             int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
//             int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

//             if (t1 <= t2) {
//                 ans += t1;
//                 pq1.poll();
//             } else {
//                 ans += t2;
//                 pq2.poll();
//             }
//         }
//         return ans;
//     }
// }



class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        long cost = 0;

        int[] l = new int[candidates];
        int[] r = new int[candidates];

        int left = 0; int right = len-1;
        for (left = 0; left < candidates; left++) {
            l[left] = costs[left];
        }
        for (int i = 0; i < candidates; i++) {
            if (right < candidates) {
                r[i] = Integer.MAX_VALUE;
            } else {
                r[i] = costs[right--];
            }
        }

        buildMinHeap(l);
        buildMinHeap(r);

        while (k-- > 0) {
            if (r[0] < l[0]) {
                cost += r[0];
                r[0] = left <= right ? costs[right--] : Integer.MAX_VALUE;
                minHeapify(r, 1); // to check if r[0] is less than its child nodes
            } else {
                cost += l[0];
                l[0] = left <= right ? costs[left++] : Integer.MAX_VALUE;
                minHeapify(l, 1);
            }
        }
        return cost;
    }

    public void buildMinHeap(int[] arr) {
        for (int mid = arr.length/2; mid > 0; mid--) {
            minHeapify(arr, mid);
        }
    }

    public void minHeapify(int[] arr, int mid) {
        // left and right are child nodes for node mid-1
        int left = mid*2-1; int right = mid*2; int n = arr.length;
        if (left < n && right < n) {
            left = arr[left] > arr[right] ? right : left;
            if (arr[left] < arr[mid-1]) {
                swap(arr, left, mid-1); // swapped left upward
                // left+1 since that'll check if the node left+1-1=left is smaller than children
                minHeapify(arr, left+1);
            }
        } else if (left < n && arr[left] < arr[mid-1]) {
            swap(arr, left, mid-1);
            minHeapify(arr, left+1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}