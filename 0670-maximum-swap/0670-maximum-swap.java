class Solution {
    public int maximumSwap(int num) {
        // Convert the number to a character array (digit array)
        char[] digits = Integer.toString(num).toCharArray();
        
        // Create an array to store the last occurrence index of each digit (0-9)
        int[] last = new int[10];
        
        // Store the last occurrence of each digit in the number
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        // Traverse through the digits and try to find the best swap
        for (int i = 0; i < digits.length; i++) {
            // Try to find a larger digit in the remaining part of the array
            for (int d = 9; d > digits[i] - '0'; d--) {
                // If there is a larger digit later in the number, swap it
                if (last[d] > i) {
                    // Swap digits[i] with digits[last[d]]
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    // Convert the character array back to integer and return it
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // If no swap is needed, return the original number
        return num;
    }
}