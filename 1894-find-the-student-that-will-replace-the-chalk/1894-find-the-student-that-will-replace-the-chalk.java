class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i=0; i<chalk.length; i++){
            sum += chalk[i];
        }
        long l = k;
        while(l >= sum){
            l = l-sum;
        }
        for(int i=chalk.length-1; i>=0; i--){
            if(sum-chalk[i] <= l){
                return i;
            }else{
                sum = sum - chalk[i];
            }
        }
        return -1;
    }
}