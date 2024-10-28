package a.array.cond;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class ShareProfit {

	public static void main(String[] args) {

		System.out.println("Profit : " + maxProfit()); // Output: 6

	}

	public static int maxProfit() {

		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 }; 

		if (prices == null || prices.length == 0)
			return 0;

		int minPrice = prices[0];
		int maxProfit = 0;
		//1st way
		for (int i = 1; i < prices.length; i++) {
			System.out.println("i is :" + i);
			if (prices[i] < prices[i - 1] && minPrice > prices[i]) {
				minPrice = prices[i];
			} else if (prices[i] > minPrice && (maxProfit < prices[i] - minPrice)) {
				// maxProfit=price;
				maxProfit = prices[i] - minPrice;
			}
		}

		//2nd way - Good
		  minPrice = prices[0];
		  maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff =prices[i] -minPrice;
			maxProfit = Math.max(maxProfit, diff) ;
			minPrice=Math.min(minPrice, prices[i]);
			
		}
		
		return maxProfit;
	}
}
