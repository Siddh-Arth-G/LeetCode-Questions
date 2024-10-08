// class Solution {
//     public int minSwaps(String s) {
//         Stack<Character> st = new Stack<>();
//         for(char ch:s.toCharArray()){
//             if(ch == '['){
//                 st.push(ch);
//             }else{
//                 if(!st.isEmpty() && st.peek() == '['){
//                     st.pop();
//                 }
//             }
//         }
//         return (st.size()+1)/2;
//     }
// }



// class Solution {
//     public int minSwaps(String s) {
//         char[] ch = new char[s.toCharArray().length];
//         int index = -1;
//         int i = 0;
//         for(char c:s.toCharArray()){
//             if(c == '['){
//                 ch[i] = c;
//                 i++;
//                 index++;
//             }else{
//                 if(index >= 0 && ch[index] == '['){
//                     index--;
//                     i--;
//                 }
//             }
//         }
//         return (i+1)/2;
//     }
// }




class Solution {
    public int minSwaps(String s) {
        int opening = 0;
        int unbalanced = 0;

        for (var c: s.getBytes()) {
            if (c == '[') {
                opening++;
            } else {
                if (opening > 0)
                    opening--;
                else
                    unbalanced++;    
            }
        }

        return unbalanced / 2 + unbalanced % 2;
    }
}