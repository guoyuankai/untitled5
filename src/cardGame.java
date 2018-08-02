public class cardGame {
    public int cardGame(int[] A, int n) {
        // write code here
        int [][]dp_first=new int[n][n];
        int [][]dp_last=new int[n][n];
        for(int j=0;j<n;j++)
        {
            dp_first[j][j]=A[j];
            for(int i=j-1;i>=0;i--)
            {
                dp_first[i][j]=Math.max(A[i]+dp_last[i+1][j],A[j]+dp_last[i][j-1]);
                dp_last[i][j]=Math.min(dp_first[i+1][j],dp_first[i][j-1]);
            }
        }
        return Math.max(dp_first[0][n-1],dp_last[0][n-1]);
    }
}
