package arrays_part_1;

public class StockBuyandSell {
    
    public int maxprofit(int[] prices) {
        int buyDay = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(buyDay < prices[i]) {
                profit = Math.max(profit, prices[i] = buyDay);
            }
            buyDay = Math.min(buyDay, prices[i]);
        }
        return profit;
    }
}
