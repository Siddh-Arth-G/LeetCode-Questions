class Solution {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        for (char c :  "aeiouAEIOU".toCharArray()){
            vowels[c] = true;
        }

        // Convert the string to a char array for in-place modification
        char[] chars = s.toCharArray();

        int pointerA = 0;
        int pointerB = s.length() - 1;

        while (pointerA < pointerB) {
            // Move pointerA forward until we find a vowel
            while (pointerA < pointerB && !vowels[chars[pointerA]]) {
                pointerA++;
            }

            // Move pointerB backward until we find a vowel
            while (pointerA < pointerB && !vowels[chars[pointerB]]) {
                pointerB--;
            }

            // Swap the vowels at pointerA and pointerB
            char temp = chars[pointerA];
            chars[pointerA] = chars[pointerB];
            chars[pointerB] = temp;

            // Move both pointers towards the center
            pointerA++;
            pointerB--;
        }

        // Convert the char array back to a string and return it
        return new String(chars);
    }
}