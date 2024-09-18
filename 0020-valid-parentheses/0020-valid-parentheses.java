class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> ad = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                ad.push(s.charAt(i));
            }else{
                if(ad.isEmpty()){
                    return false;
                }else if((s.charAt(i) == ')' && ad.pop() == '(') || 
                         (s.charAt(i) == ']' && ad.pop() == '[') || 
                         (s.charAt(i) == '}' && ad.pop() == '{')){
                            continue;
                }else{
                    return false;
                }
            }
        }
        return (ad.isEmpty());
    }
}