// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> st = new Stack<>();
//         for(char ch:s.toCharArray()){
//             if(ch == ')'){
//                 if(!st.isEmpty() && st.peek() == '('){
//                     st.pop();
//                 }else{
//                     st.push(ch);
//                 }
//             }else{
//                 st.push(ch);
//             }
//         }
//         return st.size();
//     }
// }



// class Solution {
//     public int minAddToMakeValid(String s) {
//         int open = 0;  
//         int close = 0; 
        
//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 open++;  
//             } else {
//                 if (open > 0) {
//                     open--; 
//                 } else {
//                     close++;
//                 }
//             }
//         }
//         return open + close;
//     }
// }



class Solution {
    public int minAddToMakeValid(String s) {
        Stack<String> st=new Stack<>();
        int openCount=0;
        int closeCount=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                openCount++;
            }
           else
            {
                if(openCount>0)
                {
                    openCount--;
                }
                else
                closeCount++;
            }
        }
        return openCount+closeCount;
    }
}