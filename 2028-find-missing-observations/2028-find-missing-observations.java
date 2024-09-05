class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int i=0; i<rolls.length; i++){
            sum += rolls[i];
        }
        int remainingNumbers = (mean*(rolls.length+n)) - sum;
        if(remainingNumbers > 6*n || remainingNumbers < n){
            return new int[]{};
        }
        int[] missingRolls = new int[n];
        int average = remainingNumbers/n;
        int remainder = remainingNumbers % n;
        for(int i=0; i<n; i++){
            missingRolls[i] = average;
            if(remainder > 0){
                missingRolls[i]++;
                remainder--;
            }
        }
        return missingRolls;
    }
}