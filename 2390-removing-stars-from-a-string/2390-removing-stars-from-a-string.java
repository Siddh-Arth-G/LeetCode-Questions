// class Solution {
//     public String removeStars(String s) {
//         char[] chars = s.toCharArray();
//         Stack<Character> stack = new Stack<>();

//         for(char ch: chars){
//             if(ch=='*'){
//                 stack.pop();
//             }else{
//                 stack.push(ch);
//             }
//         }

//         char[] res = new char[stack.size()];
//         int i=res.length-1;
//         while(!stack.isEmpty()){
//             res[i--] = stack.pop();
//         }
//         return new String(res);
//     }
// }



// class Solution {
//     public String removeStars(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         int length = s.length();
//         int i = 0;
//         int index=0;
//         while (i < length){
//             if (s.charAt(i) == '*'){
//                 index--;
             
//             }else{
//                 sb.setCharAt(index, s.charAt(i));
//                 index++;
//             }
//             i++;
//         }

//         // setCharAt
//         return sb.substring(0, index);
//     }
// }





class Solution {
    static{
        for(int i = 0; i < 500; i++){
            removeStars(" *");
        }
    }
    public static String removeStars(String s) {
        int len = s.length();
        byte[] res = new byte[len];
        s.getBytes(0,len,res,0);

        int countStars = 0;
        
        for(int i = 0; i<len; i++) {
            if(res[i] == '*') countStars++;
            else res[i-countStars*2] = res[i];
        }
        
        return new String(res, 0, len-countStars*2);
    }
}
