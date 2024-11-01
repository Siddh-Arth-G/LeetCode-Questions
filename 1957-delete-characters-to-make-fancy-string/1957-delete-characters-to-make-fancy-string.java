// class Solution {
//     public String makeFancyString(String s) {
//         StringBuilder sb = new StringBuilder();
//         char c = s.charAt(0);
//         int i = 0;
//         while(i<s.length()){
//             int count = 0;
//             while(i<s.length() && s.charAt(i) == c){
//                 count++;
//                 if(count < 3){
//                     sb.append(c);
//                 }
//                 i++;
//             }
//             if(i<s.length()) c = s.charAt(i);
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String makeFancyString(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for (char cur : s.toCharArray()) {
            if (cur == prev) {
                sameCount++;
            }
            else {
                sameCount = 1;
            }
            if (sameCount < 3) sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }
}