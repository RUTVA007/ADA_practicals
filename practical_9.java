import java.util.*;

public class CoinChangeDP {

    public static int minCoins(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize with large value
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If not possible
        if (dp[amount] > amount)
            return -1;

        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 3, 4};
        int amount = 6;

        int result = minCoins(coins, amount);

        if (result != -1)
            System.out.println("Minimum coins required: " + result);
        else
            System.out.println("Change cannot be made");
    }
}
