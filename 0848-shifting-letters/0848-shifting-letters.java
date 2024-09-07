class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        // Convert the string to a char array for easier manipulation
        char[] chars = s.toCharArray();
        int totalShift = 0;

        // Traverse shifts array from the end
        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26; // Accumulate shifts and use modulo 26 to prevent overflow
            chars[i] = (char) ((chars[i] - 'a' + totalShift) % 26 + 'a'); // Shift the character
        }

        return new String(chars); // Return the modified string
    }
}
