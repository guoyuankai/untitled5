public class Coin_Change {
    public int countWays(int[] changes, int n, int x) {
        // write code here
        int[][]dp=new int[x+1][n+1];
        for(int j=0;j<=n;j++)
        {
            dp[0][j]=1;
        }
        for(int i=0;i<=x;i++)
        {
            dp[i][0]=0;
        }
        for(int i=1;i<=x;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i>=changes[j-1])
                {
                    dp[i][j]=dp[i-changes[j-1]][j]+dp[i][j-1];
                }
                else
                {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[x][n];
    }
}
