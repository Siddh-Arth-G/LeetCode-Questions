// class Solution {
//     public String compressedString(String word) {
//         StringBuilder comp = new StringBuilder();
//         int cnt = 1, n = word.length();
//         char ch = word.charAt(0);
//         for (int i = 1; i < n; i++) {
//             if (word.charAt(i) == ch && cnt < 9) {
//                 cnt++;
//             } else {
//                 comp.append(cnt).append(ch);
//                 ch = word.charAt(i);
//                 cnt = 1;
//             }
//         }
//         comp.append(cnt).append(ch);
//         return comp.toString();
//     }
// }

class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int count=0,j=0;
        for(int i=0;i<word.length();++i){
            j=i;
            char c=word.charAt(i);
            while(j<word.length() && word.charAt(j)==c){
                ++count;
                ++j;
            }
            while(count>9){
                sb.append('9');
                sb.append(c);
                count-=9;

            }
            sb.append((char)(count+'0'));
            sb.append(c);
            count=0;
            i=j-1;

        }
        return sb.toString();
    }
}