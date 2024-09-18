class Solution {
    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(ans, (a,b)->(b+a).compareTo(a+b));
        
        if(ans[0].equals("0")){
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        for(String val: ans){
            res.append(val);
        }
        
        return res.toString();
    }
}