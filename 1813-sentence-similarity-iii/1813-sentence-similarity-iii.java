// class Solution {
//     public boolean areSentencesSimilar(String sentence1, String sentence2) {
//         String[] s1 = sentence1.split(" ");
//         String[] s2 = sentence2.split(" ");
//         int i=0;
//         int j=0;
//         while(i<s1.length && j<s2.length &&s1[i].equals(s2[j])){
//             i++;
//             j++;
//         }
//         if(i==s1.length || j==s2.length) return true;
//         int m=s1.length-1;
//         int n=s2.length-1;
//         while(m>=i && n>=j &&s1[m].equals(s2[n])){
//             m--;
//             n--;
//         }
//         if(m==-1 || n==-1)return true;
//         if(m == i-1 || n == j-1) return true;
//         return false;
//     }
// }




class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int i = 0;
        int j = 0;

        while (i < s1.length && i < s2.length && s1[i].equals(s2[i])) {
            i++;
        }

        while (j < s1.length - i && j < s2.length - i && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
            j++;
        }

        return i + j == Math.min(s1.length, s2.length);
    }
}
