public class Expression {
    public int run_ops(int a,int b,char ops)
    {
        if(ops=='&')
        {
            return a&b;
        }
        else if(ops=='|')
        {
            return a|b;
        }
        else
        {
            return a^b;
        }
    }
    public int countWays(String exp, int len, int ret) {
        // write code here
        int []digits=new int[(len+1)/2];
        char []ops=new char[(len-1)/2];
        int k=0,l=0;
        for(int i=0;i<len;i++)
        {
            if(exp.charAt(i)=='0'||exp.charAt(i)=='1')
            {
                digits[k]=exp.charAt(i)-'0';
                k++;
            }
            else
            {
                ops[l]=exp.charAt(i);
                l++;
            }
        }
        int n=digits.length;
        int [][][]dp=new int[n][n][2];
        for(int i=0;i<n;i++)
        {
           if(digits[i]==1)
           {
               dp[i][i][1]=1;
           }
           else
           {
               dp[i][i][0]=1;
           }
        }
        for(int x=1;x<n;x++)
        {
            for(int i=0;i<n-x;i++)
            {
                int j=i+x;
                for(int ops_n=i;ops_n<j;ops_n++)
                {
                    if(dp[i][ops_n][0]!=0&&dp[ops_n+1][j][0]!=0)
                    {
                        int num=run_ops(0,0,ops[ops_n]);
                        dp[i][j][num]=(dp[i][j][num]+dp[i][ops_n][0]*dp[ops_n+1][j][0])%10007;
                    }

                    if(dp[i][ops_n][0]!=0&&dp[ops_n+1][j][1]!=0)
                    {
                        int num=run_ops(0,1,ops[ops_n]);
                        dp[i][j][num]=(dp[i][j][num]+dp[i][ops_n][0]*dp[ops_n+1][j][1])%10007;
                    }
                    if(dp[i][ops_n][1]!=0&&dp[ops_n+1][j][0]!=0)
                    {
                        int num=run_ops(1,0,ops[ops_n]);
                        dp[i][j][num]=(dp[i][j][num]+dp[i][ops_n][1]*dp[ops_n+1][j][0])%10007;
                    }
                    if(dp[i][ops_n][1]!=0&&dp[ops_n+1][j][1]!=0)
                    {
                        int num=run_ops(1,1,ops[ops_n]);
                        dp[i][j][num]=(dp[i][j][num]+dp[i][ops_n][1]*dp[ops_n+1][j][1])%10007;
                    }
                }
            }
        }
        return dp[0][n-1][ret];

    }

}
