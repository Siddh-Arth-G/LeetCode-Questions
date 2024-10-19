class Solution {
    public char findKthBit(int n, int k) {
        // Recursively find the k-th bit in Sn
        return findKthBitRecursive(n, k);
    }

    private char findKthBitRecursive(int n, int k) {
        // Base case: S1 is "0", so the first bit is '0'
        if (n == 1) {
            return '0';
        }

        // Calculate the length of Sn
        int length = (1 << n) - 1;  // Length of Sn is 2^n - 1

        // Find the middle bit index
        int mid = length / 2 + 1;

        // If k is in the first half, it is the same as in Sn-1
        if (k < mid) {
            return findKthBitRecursive(n - 1, k);
        }
        // If k is the middle bit, it is always '1'
        else if (k == mid) {
            return '1';
        }
        // If k is in the second half, find the corresponding bit in Sn-1 and invert it
        else {
            // Find the mirrored position in the first half of Sn-1
            int mirroredK = length - k + 1;
            char mirroredBit = findKthBitRecursive(n - 1, mirroredK);
            // Invert the bit ('0' -> '1', '1' -> '0')
            return mirroredBit == '0' ? '1' : '0';
        }
    }
}