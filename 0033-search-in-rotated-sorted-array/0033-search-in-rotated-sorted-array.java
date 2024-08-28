class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        int pivot = pivot(nums);
        if(pivot == -1){
            return search(nums, target, 0, nums.length-1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(nums[0] <= target){
            return search(nums, target, 0, pivot-1);
        }
        return search(nums, target, pivot+1, nums.length-1);
    }
    private int pivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int mid = -1;
        while(start<=end){
            mid = start + (end - start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] < arr[start]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    private int search(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}