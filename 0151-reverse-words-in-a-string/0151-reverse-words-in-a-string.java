// class Solution {
//     public String reverseWords(String s) {
//         List<String> list = new ArrayList<>();
//         int i=0;
//         while(i<s.length()){
//             if(s.charAt(i) != ' '){
//                 int start = i;
//                 StringBuilder sb = new StringBuilder();
//                 while(i<s.length() && s.charAt(i) != ' '){
//                     sb.append(s.charAt(i));
//                     i++;
//                 }
//                 list.add(sb.toString());
//             }else{
//                 i++;
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int j=list.size()-1; j>=0; j--){
//             sb.append(list.get(j)).append(" ");
//         }
//         return sb.toString().trim();
//     }
// }




class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int startIndex = s.length()-1;
        while(startIndex >= 0){
            while(startIndex >= 0 && s.charAt(startIndex) == ' '){
                startIndex--;
            }
            if(startIndex < 0){
                break;
            }
            int endIndex = startIndex;
            while(startIndex >= 0 && s.charAt(startIndex) != ' '){
                startIndex--;
            }
            if(res.length() == 0){
                res.append(s.substring(startIndex+1,endIndex+1));
            }else{
                res.append(" ");
                res.append(s.substring(startIndex+1,endIndex+1));
            }
        }
        return res.toString();
        }
    
}