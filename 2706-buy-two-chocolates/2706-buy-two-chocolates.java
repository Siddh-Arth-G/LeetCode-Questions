class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++) {
            for (int j=0;j<prices.length;j++) {
                int sum = 0;
                if (i != j) {
                    sum = prices[i]+prices[j];
                    if (sum < min && sum <= money)
                    min = sum;
                }
            }
        }
        if (min != Integer.MAX_VALUE)
        return money-min;
        return money;
    }
}