package concepts.slidingwindow;

/*
    Given an array where the element at the index i represents the price of a stock on day i, find the maximum profit that you can g
    ain by buying the stock once and then selling it.

    Note: You can buy the stock on one specific day and sell it on a different day to make a profit. If no profit can be achieved, we return zero.

    Constraints:
        1) We can’t sell before buying a stock, that is, the array index at which stock is bought will always be less than the index at which the stock is sold.
        2) 1 ≤ prices.length ≤ 10^3
        3) 0 ≤ prices[i] ≤ 10^5
 */
public class BestTimeToBuyAndSellStock {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        prices = new int[]{12, 2, 4, 2, 69};
        System.out.println(maxProfit(prices));
    }
}
