// class Solution {
//     public List<String> letterCombinations(String digits) {
//         if (digits.isEmpty()) return Collections.emptyList();

//         String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//         List<String> output = new ArrayList<>();
//         backtrack("", digits, phone_map, output);
//         return output;
//     }

//     private void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
//         if (next_digits.isEmpty()) {
//             output.add(combination);
//         } else {
//             String letters = phone_map[next_digits.charAt(0) - '2'];
//             for (char letter : letters.toCharArray()) {
//                 backtrack(combination + letter, next_digits.substring(1), phone_map, output);
//             }
//         }
//     }
// }



class Solution {
    private static final String[] keyboard = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        StringBuilder combo = new StringBuilder();
        backtracking(0, digits, combo, result);
        return result;
    }
    private void backtracking(int idx, String digits, StringBuilder combo, List<String> result) {
        if (idx == digits.length()) {
            result.add(combo.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = keyboard[digit];
        for (char ch : letters.toCharArray()) {
            combo.append(ch);
            backtracking(idx + 1, digits, combo, result);
            combo.deleteCharAt(combo.length() - 1);
        }
    }
}