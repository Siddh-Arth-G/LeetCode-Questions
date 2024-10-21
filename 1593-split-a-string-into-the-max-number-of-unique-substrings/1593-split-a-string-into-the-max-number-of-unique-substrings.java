// class Solution {
//     public int maxUniqueSplit(String s) {
//         return helper(s, new HashSet());
//     }
//     private int helper(String s, Set<String> seen){
//         int max = 0;
//         for(int i=1; i<=s.length(); i++){
//             String candidate = s.substring(0, i);
//             if(!seen.contains(candidate)){
//                 seen.add(candidate);
//                 max = Math.max(max, 1 + helper(s.substring(i), seen));
//                 seen.remove(candidate);
//             }
//         }
//         return max;
//     }
// }



class Solution {

    int res = -1;
    Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
        
        backtrace(0, s);
        return res;
    }

    void backtrace(int startIndex, String s){
        if(startIndex==s.length()){
            res = Math.max(res, set.size());
            return;
        }

        for(int i=startIndex;i<s.length();i++){

            if(s.length()-1-i+set.size()<res){
                break;
            }

            String cur = s.substring(startIndex, i+1);
            if(!set.contains(cur)){
                set.add(cur);
                backtrace(i+1, s);
                set.remove(cur);
            }
        }

    }
}