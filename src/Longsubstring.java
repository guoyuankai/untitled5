public class Longsubstring {
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        int [][]dp=new int[n+1][m+1];
        int max=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(A.charAt(i-1)==B.charAt(j-1))
                {
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
                if(dp[i][j]>max)
                {
                    max=dp[i][j];
                }
            }

        }
        return max;

    }
}
