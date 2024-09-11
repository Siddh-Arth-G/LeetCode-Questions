class Solution {
    public int removeDuplicates(int[] arr) {
        // int count = 0;
        // for(int i=0; i<arr.length; i++){
        //     if(i<arr.length - 1 && arr[i] == arr[i+1]){
        //         continue;
        //     } else{
        //         arr[count] = arr[i];
        //         count++;
        //     }
        // }
        // return count;
        List<Integer> sets = new ArrayList<>();
        for(int num: arr) {
            if(!sets.contains(num)) {
                sets.add(num);
            }
        }
        int size = sets.size();
        for(int i= 0; i< size; i++) {
            arr[i] = sets.get(i);
        }
        return sets.size();
    }
}