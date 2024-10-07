// class Solution {
//     public int minLength(String s) {
//         Stack<Character> st = new Stack<>();
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) == 'B'){
//                 if(!st.isEmpty()){
//                     if(st.peek() == 'A'){
//                         st.pop();
//                     }else{
//                         st.push(s.charAt(i));
//                     }
//                 }else{
//                     st.push(s.charAt(i));
//                 }
                
//             }else if(s.charAt(i) == 'D'){
//                 if(!st.isEmpty()){
//                     if(st.peek() == 'C'){
//                         st.pop();
//                     }else{
//                         st.push(s.charAt(i));
//                     }
//                 }else{
//                     st.push(s.charAt(i));
//                 }
//             }else{
//                 st.push(s.charAt(i));
//             }
//         }
//         return st.size();
//     }
// }



class Solution {
    public int minLength(String s) {
        char[] stack = new char[s.length()+1];
        int last = -1;
        for (char c : s.toCharArray()) {
            if (last > -1 && (c == 'B' && stack[last] == 'A' || 
                                     c == 'D' && stack[last] == 'C')) 
            {
                last--;
            } else {
                last++;
                stack[last] = c;
            }
        }
        return last+1;
    }
}