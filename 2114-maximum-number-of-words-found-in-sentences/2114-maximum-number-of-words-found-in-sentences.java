class Solution {
    public static int getWhiteSpaces(String s) {
        int c=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ' ')
                c++;
        }
        return c;
    }
    public static int mostWordsFound(String[] sentences) {
        int n = sentences.length;
        int max=-1;
        int temp=0;
        for(int i=0; i<n;i++) {
            temp = getWhiteSpaces(sentences[i]);
            if(temp>max)
                max=temp;
        }
        return max+1;
    }
}