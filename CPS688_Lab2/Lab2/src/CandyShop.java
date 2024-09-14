//Author Redwan Khalifa 501------
public class CandyShop {

    public static void highestSAValue(int n, int[] values, int[] weights, int w) {

        int[][] totalValues = new int[n + 1][w + 1]; //Save values for total number of items and space

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if(weights[i -1] <= j) {
                    totalValues[i][j] = Math.max(totalValues[i-1][j], totalValues[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    totalValues[i][j] = totalValues[i-1][j];
                }
            }
        }

        System.out.println(totalValues[n][w]);
    }
    
    public static void main (String[] args) {

        int numOfCandies = 3, maxWeight = 5;
        int[] candyValues = {6, 10, 12}, candyWeights = {1, 2, 3};

        highestSAValue(numOfCandies, candyValues, candyWeights, maxWeight);

    }
}
