// class Solution {
//     public boolean isCircularSentence(String sentence) {
//         String[] str = sentence.split(" ");
//         boolean isCircular = true;
//         for(int i=0; i<str.length; i++){
//             if(i == str.length-1){
//                 if(str[i].charAt(str[i].length() - 1) != str[0].charAt(0)){
//                     isCircular = false;
//                     break;
//                 }
//             }else{
//                 if(str[i].charAt(str[i].length() - 1) != str[i+1].charAt(0)){
//                     isCircular = false;
//                     break;
//                 }
//             }
//         }
//         return isCircular;
//     }
// }




class Solution {
    public boolean isCircularSentence(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        int k = s.indexOf(" ");
        if (k == -1)
            return true;

        while (k != -1) {
            if (s.charAt(k - 1) != s.charAt(k + 1)) {
                return false;
            }

            k = s.indexOf(" ", k+1);
        }
        return true;
    }
}

// class Solution {
//     public boolean isCircularSentence(String sentence) {
//         String words[] = sentence.split(" ");
//         for(int i=0;i<words.length-1;i++){
//             if(words[i].charAt(words[i].length()-1)!=words[i+1].charAt(0)){
//                 return false;
//             }
//         }
//         if(words.length==1){
//             return words[0].charAt(0)==words[0].charAt((words[0].length()-1));
//         }
//         return words[0].charAt(0)==words[words.length-1].charAt((words[words.length-1].length()-1));
//     }
// }