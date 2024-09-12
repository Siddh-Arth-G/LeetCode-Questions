class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char ch: allowed.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for(String word: words){
            boolean isAllowed = true;
            for(char ch: word.toCharArray()){
                if(!set.contains(ch)){
                    isAllowed = false;
                    break;
                }
            }
            if(isAllowed){
                count++;
            }
        }
        return count;
    }
}