class Solution {
    public int findMin(int[] nums) {
        int pivotValue = pivot(nums);
        return nums[pivotValue+1];
    }
    private int pivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(end > mid && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(start < mid && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] > arr[start]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}