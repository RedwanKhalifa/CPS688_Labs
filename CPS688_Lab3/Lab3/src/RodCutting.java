//Author Redwan Khalifa 501------
public class RodCutting {

    public static int maxValue(int[] prices, int length) {
        int[] maxPrice = new int[length + 1];
        maxPrice[0] = 0;

        for (int j = 1; j <= length; j++) { //bottom-up method
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                max = Math.max(max, prices[i - 1] + maxPrice[j - i]);
            }
            maxPrice[j] = max;
        }
        return maxPrice[length];
    }
    public static void main(String[] args) {
        int rodLength = 8;
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(maxValue(prices, rodLength));
    }
}
