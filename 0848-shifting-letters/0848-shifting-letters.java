class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] ans = s.toCharArray();

        long sum = 0;

        for (int i = shifts.length - 1; i > - 1; i--) {
            sum += shifts[i];
           ans[i] = (char)(((ans[i] - 'a' + sum ) % 26) + 'a');
        }

        return String.valueOf(ans);
    }
}