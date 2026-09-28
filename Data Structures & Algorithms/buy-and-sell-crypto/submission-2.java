class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int j =1; int i = 0;
        int max_profit = 0;
        while(j<n){
            if(prices[j]-prices[i] > max_profit){
                max_profit = prices[j]-prices[i];
            }
            if(prices[j]<prices[i]){
                i=j;
            }
            j++;
        }
        return max_profit;
        
    }
}
