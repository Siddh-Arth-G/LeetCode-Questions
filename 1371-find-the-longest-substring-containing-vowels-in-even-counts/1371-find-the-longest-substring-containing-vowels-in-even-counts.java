class Solution {
    public int findTheLongestSubstring(String s) {
        int xor = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                xor ^= c;
            }
            if(map.containsKey(xor)){
                res = Math.max(res, i-map.get(xor));
            }else{
                map.put(xor, i);
            }
        }
        return res;
    }
}