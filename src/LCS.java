public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(A.charAt(i-1)==B.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    if(dp[i-1][j]>dp[i][j-1])
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                    else
                    {
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
        }
        return dp[n][m];

    }

}
