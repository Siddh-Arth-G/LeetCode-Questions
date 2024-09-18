class Solution {
    public boolean isValid(String s) {
//         ArrayDeque<Character> ad = new ArrayDeque<>();
        
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
//                 ad.push(s.charAt(i));
//             }else{
//                 if(ad.isEmpty()){
//                     return false;
//                 }else if((s.charAt(i) == ')' && ad.pop() == '(') || 
//                          (s.charAt(i) == ']' && ad.pop() == '[') || 
//                          (s.charAt(i) == '}' && ad.pop() == '{')){
//                             continue;
//                 }else{
//                     return false;
//                 }
//             }
//         }
//         return (ad.isEmpty());
        
        char[] charray = new char[s.length()];
        int index = -1;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                index = index + 1;
                charray[index] = ')';
            } else if (ch == '{') {
                index = index + 1;
                charray[index] = '}';
            } else if (ch == '[') {
                index = index + 1;
                charray[index] = ']';
            } else if (index == -1 || charray[index--] != ch) {
                return false;
            }
        }
        return index == -1;
    }
}