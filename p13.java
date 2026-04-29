public class SCS {

    // Function to find LCS length
    public static int lcs(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    // Function to find SCS length
    public static int scsLength(String X, String Y) {
        int lcsLen = lcs(X, Y);
        return X.length() + Y.length() - lcsLen;
    }

    public static void main(String[] args) {

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int result = scsLength(X, Y);

        System.out.println("Length of Shortest Common Supersequence = " + result);
    }
}
