class Solution {
    public int maxVowels(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[] isVowel = new boolean[26];

        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        int i = 0;

        int maxVowels = 0;

        for (i = 0; i < k; i++) {
            if (isVowel[c[i] - 'a']) {
                maxVowels++;
            }
        }

        int localMax = maxVowels;

        for (i = 1; i <= n - k; i++) {
            if (isVowel[c[i - 1] - 'a']) {
                localMax--;
            }

            if (isVowel[c[i + k - 1] - 'a']) {
                localMax++;
            }

            maxVowels = Math.max(localMax, maxVowels);
        }

        return maxVowels;
    }
}