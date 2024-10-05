class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i:map.values()){
            set.add(i);
        }
        return map.size() == set.size();
    }
}



// class Solution{
//     public boolean uniqueOccurrences(int[] arr){
//         int[] res = new int[2001];
//         for(int i: arr){
//             res[i+1000]++;
//         }
//         Arrays.sort(res);
//         for(int i=0; i<2001; i++){
//             if(res[i] == 0){
//                 continue;
//             }else{
//                 if(res[i-1] == res[i]){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }
