class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(char c:s.toCharArray()){
            int number = (c-'a'+1);
            sum += sumOfDigits(number);
        }
        while(k>1){
            sum = sumOfDigits(sum);
            k--;
        }
        return sum;
    }
    
    private int sumOfDigits(int num){
        int sum = 0;
        while(num>0){
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }
}