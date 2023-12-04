import java.util.*;

// JAVA program for coin change problem.
// And Bonus Problem
class CoinChange {
    static int countRe(int coins[], int n, int sum){
		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;
		if (n <= 0)
			return 0;
		return countRe(coins, n - 1, sum)
			+ countRe(coins, n, sum - coins[n - 1]);
	}
	static int countMe(int[] coins, int sum, int n, int[][] dp){
		if (sum == 0)
			return dp[n][sum] = 1;
		if (n == 0 || sum<0)
			return 0;
		if (dp[n][sum] != -1)
			return dp[n][sum];
		return dp[n][sum]
			= countMe(coins, sum - coins[n - 1], n, dp)
			+ countMe(coins, sum, n - 1, dp);

	}
    static long countDp(int coins[], int n, int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
    }
     public static String RemovingSmallestDigit(String number) {
        int n = number.length();
        StringBuilder result = new StringBuilder();

        // Find the index of the first digit that is greater than its right neighbor
        int index = 0;
        while (index < n - 1 && number.charAt(index) >= number.charAt(index + 1)) {
            index++;
        }

        // If no such digit is found, remove the last digit
        if (index == n - 1) {
            return number.substring(0, n - 1);
        }

        // Remove the leftmost digit that is greater than the digit to its right
        result.append(number.substring(0, index)).append(number.substring(index + 1));
        return result.toString();
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 5, 8, 10};
        int n = coins.length;
        int sum = 7;
        System.out.println("Number of ways to make change in Recursion: " + countRe(coins, n, sum));
        System.out.println("Number of ways to make change in DP: " + countDp(coins, n, sum));
        int tc = 1;
		while (tc != 0) {
			int n1, sum1;
			n1 = 5;
			sum1 = 7;
			int[] coins1 = {1, 2, 5, 8, 10};
			int[][] dp = new int[n1 + 1][sum1 + 1];
			for (int[] row : dp)
				Arrays.fill(row, -1);
			int res = countMe(coins1, sum1, n1, dp);
			System.out.println("Number of ways to make change in Memorization: " + res);
			tc--;
        }
        // Test cases
        System.out.println(RemovingSmallestDigit("1234"));   // Output: 234
        System.out.println(RemovingSmallestDigit("2945"));   // Output: 945
        System.out.println(RemovingSmallestDigit("9273"));   // Output: 973
        System.out.println(RemovingSmallestDigit("3954"));   // Output: 954
        System.out.println(RemovingSmallestDigit("19374"));  // Output: 9374
    }
}

