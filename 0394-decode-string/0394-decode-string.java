// class Solution {
//     public String decodeString(String s) {
//         Stack<Integer> si = new Stack<>();
//         Stack<String> st = new Stack<>();
//         String res = "";
//         int index = 0;

//         while(index < s.length()){
//             if(Character.isDigit(s.charAt(index))){
//                 int count = 0;
//                 while(Character.isDigit(s.charAt(index))){
//                     count = 10 * count + (s.charAt(index) - '0');
//                     index += 1;
//                 }
//                 si.push(count);
//             }else if(s.charAt(index) == '['){
//                 st.push(res);
//                 res = "";
//                 index++;
//             }else if(s.charAt(index) == ']'){
//                 StringBuilder sb = new StringBuilder(st.pop());
//                 int count = si.pop();
//                 for(int i=0; i<count; i++){
//                     sb.append(res);
//                 }
//                 res = sb.toString();
//                 index++;
//             }else{
//                 res += s.charAt(index);
//                 index++;
//             }
//         }
//         return res;
//     }
// }



class Solution {
    public String decodeString(String s) {

        Stack<Integer> s1=new Stack<>();
        Stack<StringBuilder> s2=new Stack<>();
        int currNum=0;
        StringBuilder currStr=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='['){
                s1.push(currNum);
                s2.push(currStr);
                currNum=0;
                currStr=new StringBuilder();
            }
            else if(ch==']'){
                int num=s1.pop();
                //s1.pop();
                StringBuilder prevStr=s2.pop();
                //s2.pop();
                String se=currStr.toString();
                currStr=prevStr.append(se.repeat(num));
            }
            else if(ch>='0' && ch<='9'){
                currNum=currNum*10+((int)ch-48);
            }
            else{
                currStr.append(ch);
            }


        }

        return currStr.toString();
        
        
    }
}