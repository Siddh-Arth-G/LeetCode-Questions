// class Solution {
//     public boolean closeStrings(String word1, String word2) {
//         if(word1.length() != word2.length()) return false;
//         Map<Character, Integer> map1 = new HashMap<>();
//         Map<Character, Integer> map2 = new HashMap<>();
//         for(char c: word1.toCharArray()){
//             map1.put(c, map1.getOrDefault(c, 0)+1);
//         }
//         for(char c: word2.toCharArray()){
//             map2.put(c, map2.getOrDefault(c, 0)+1);
//         }
//         if(!map1.keySet().equals(map2.keySet())) return false;

//         List<Integer> list1 = new ArrayList<>(map1.values());
//         List<Integer> list2 = new ArrayList<>(map2.values());

//         Collections.sort(list1);
//         Collections.sort(list2);

//         return list1.equals(list2);
//     }
// }




class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n=word1.length(),m=word2.length(),i,j;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        if(n!=m)
            return false;
        if(word1.equals(word2))
            return true;
        for(i=0;i<n;i++)
        {
            f1[word1.charAt(i)-'a']++;
        }     
        for(j=0;j<m;j++)
        {
            f2[word2.charAt(j)-'a']++;
        }
        for(i = 0; i < 26; ++i) {
            if((f1[i]==0 && f2[i]!=0) || (f1[i]!=0 && f2[i]==0)) {
                return false;
            }
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for(i=25;i>=0;i--)
        {
            if(f1[i]!=f2[i])
            {   
                return false;
            }
        }
        return true;
    }
}