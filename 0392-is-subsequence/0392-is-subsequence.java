// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         if(s.length() == 0){
//             return true;
//         }
//         int i = 0;
//         int j = 0;

//         while(i<s.length() && j<t.length()){
//             if(s.charAt(i) == t.charAt(j)){
//                 i++;
//                 j++;
//             }else{
//                 j++;
//             }
//         }
//         if(i == s.length()){
//             return true;
//         }
//         return false;
//     }
// }








class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        int previousCharPos = -1;

        for (int i = 0; i < s.length(); i++) {
            int currentCharPos = t.indexOf(s.charAt(i), index);
            if (currentCharPos == -1) {
                return false;
            } else if (currentCharPos > previousCharPos) {
                index = currentCharPos + 1;
            } else {
                return false;
            }
        }

        return true;
    }
    
}