import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> rem = new HashMap<>();
        
        // Count the occurrences of each remainder
        for (int val : arr) {
            int re = (val % k + k) % k; // Adjust remainder to be positive
            int f = rem.getOrDefault(re, 0);
            rem.put(re, f + 1);
        }
        
        // Check conditions for pairing
        for (int val : arr) {
            int re = (val % k + k) % k;
            
            if (re == 0) { // Remainder 0 should have an even count
                int fq = rem.get(re);
                if (fq % 2 != 0) {
                    return false;
                }
            } else if (re == k / 2 && k % 2 == 0) { // Special case when k is even and re == k/2
                int fq = rem.get(re);
                if (fq % 2 != 0) {
                    return false;
                }
            } else { // General case: re and (k - re) should have the same count
                int fq = rem.getOrDefault(re, 0);
                int ofq = rem.getOrDefault(k - re, 0);
                if (fq != ofq) {
                    return false;
                }
            }
        }
        return true;
    }
}
