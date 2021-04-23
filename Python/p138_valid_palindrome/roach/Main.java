public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    static class Solution {

        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                int advPoint = advantagePoint(i, prices);
                if (i != advPoint) {
                    profit += prices[advPoint] - prices[i];
                    i = advPoint - 1;
                }
            }
            return profit;
        }

        public int advantagePoint(int index, int[] prices) {
            int curPrice = prices[index];
            if (index < prices.length - 1) {
                if (curPrice < prices[index + 1]) {
                    return index + 1;
                }
            }
            return index;
        }
    }

}