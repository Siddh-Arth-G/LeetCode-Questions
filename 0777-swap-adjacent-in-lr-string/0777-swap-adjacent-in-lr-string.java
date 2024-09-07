class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            // Skip X in both strings
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            // If both are out of bounds, return true
            if (i == n && j == n) return true;

            // If only one reaches the end, return false
            if (i == n || j == n) return false;

            // Check if the characters are different
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }

            // Handle 'R' and 'L' movement rules
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}
