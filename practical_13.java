public class SCS {

    // Function to compute LCS table
    public static int[][] lcsTable(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    // Build SCS from LCS table
    public static String buildSCS(String X, String Y, int[][] dp) {

        int i = X.length();
        int j = Y.length();

        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            }
            else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters
        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }

    public static void main(String[] args) {

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int[][] dp = lcsTable(X, Y);

        String scs = buildSCS(X, Y, dp);

        System.out.println("Shortest Common Supersequence: " + scs);
        System.out.println("Length: " + scs.length());
    }
}
