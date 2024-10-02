class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        
        int size = 0; 
        int i = 0;    
        
        while (i < chars.length) {
            char curr = chars[i]; 
            int count = 0;        
            
            while (i < chars.length && chars[i] == curr) {
                count++;
                i++;
            }
            
            chars[size] = curr;
            size++;
            
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[size] = c;
                    size++;
                }
            }
        }
        
        return size;
    }
}
