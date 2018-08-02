public class chkWildMatch {
    public boolean chkWildMatch(String A, int lena, String B, int lenb) {
        // write code here
        boolean [][]dp=new boolean[lena+1][lenb+1];
        dp[0][0]=true;
        for(int i=1;i<=lena;i++)
        {
            for(int j=1;j<=lenb;j++)
            {
                if(B.charAt(j-1)=='*')
                {
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else if(B.charAt(j-1)=='.')
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=dp[i-1][j-1]&&A.charAt(i-1)==B.charAt(j-1);
                }
            }
        }
        return dp[lena][lenb];

    }
}
