class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i]+prices[j] <= money){
                    min = Math.min(min,(prices[i]+prices[j]));
                }
            }
        }
        if(min != Integer.MAX_VALUE){
            return money - min;
        }
        return money;
    }
}