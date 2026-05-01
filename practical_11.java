public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] p) {

        int n = p.length;
        int[][] dp = new int[n][n];

        // dp[i][i] = 0 (single matrix cost is 0)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // chain length
        for (int len = 2; len < n; len++) {

            for (int i = 1; i < n - len + 1; i++) {

                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + p[i - 1] * p[k] * p[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        // Example: A1(10x20), A2(20x30), A3(30x40)
        int[] dimensions = {10, 20, 30, 40};

        int result = matrixChainOrder(dimensions);

        System.out.println("Minimum multiplication cost = " + result);
    }
}
