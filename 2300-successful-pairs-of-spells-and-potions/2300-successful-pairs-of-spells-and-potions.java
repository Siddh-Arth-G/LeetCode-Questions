// class Solution {
//     public int[] successfulPairs(int[] spells, int[] potions, long success) {
//         // sorting potions so that if we find the least potion we dont have to search more O(mLogm)
//         Arrays.sort(potions);
       
//     for(int i=0;i<spells.length;i++){
//         //for each spell finding the number and storing without using any extra space
//         spells[i]=binarySearch(spells[i],potions,success);

//     }
//     return spells;
        
//     }
//     public int binarySearch(int num,int[] potions,long success){
        
//         int left=0;
//         int n=potions.length;
//         int right=n-1;
//         // BINARY SEARCH O(Longm)
//         while(left<right){
//             int mid=(left+right)/2;
//             if((long)num*potions[mid]<success){
//                 left=mid+1;
//             }else{
//                 right=mid;
//             }
//         }
//         //if last element check if its included cause aur algo can come and stop here even if its not included
//         if(left==n-1){
//             if((long)num*potions[left]<success){
//                 return 0;
//             }
//         }
//         // return the number of elements to the right of pointer
//         return n-left;

//     }
// }




import java.math.BigInteger;
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m= potions.length;

        int maxp = potions[0];
        for (int i = 1; i < m; i++) {
            if (maxp < potions[i]) {
                maxp = potions[i];
            }
        }

        int[] pcouners = new int[maxp + 1];
        for (int i = 0; i <m; i++) {
            pcouners[potions[i]]++;
        }

        for (int i = maxp - 1; i > 0; i--) {
            pcouners[i] += pcouners[i + 1];
        }

        long mins = (success + maxp - 1) / maxp;
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int res = 0;

            if (spell >= mins) {
                long ptarget = (success + spell - 1) / spell;
                res = pcouners[(int) ptarget];
            }

            spells[i] = res;
        }
        
        return spells;
    }
}