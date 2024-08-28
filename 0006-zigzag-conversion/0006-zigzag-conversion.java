class Solution {
    public String convert(String s, int n) {
        int len = s.length();
        if (n == 1 || n >= len) 
            return s;
        
        char[] arr = new char[len];
        
        int p = 0;
        
        for(int i=0; i<n ; i++){
            
            int j = i;
            while(j<len){
                if(i ==0 || i==n-1){
                    arr[p] = s.charAt(j);
                    j += n + n-2;
                    p++;
                }
                else{
                    arr[p] = s.charAt(j);
                    j += n-i-1 + n-i-1;
                    p++;
                    if(j>=len){
                        break;
                    }
                    arr[p] = s.charAt(j);
                    j += i + i; 
                    p++; 
                }
            }
        }
        String ans = new String(arr);
        return ans;
    }
}