class Solution {
    public boolean areNumbersAscending(String s) 
    {
        int prev = -1;
        int l = s.length();
        
        for (int i = 0; i < l;) 
        {
            if (Character.isDigit(s.charAt(i))) 
            {
                int n = 0;
                while (i < l && Character.isDigit(s.charAt(i))) 
                {
                    n = n * 10 + (s.charAt(i) - '0');
                    i++;
                }
                
                if (n <= prev) 
                {
                    return false; 
                }
                prev = n; 
            } 
            else 
            {
                i++;
            }
        }
        
        return true; 
    }
}