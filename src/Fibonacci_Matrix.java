public class Fibonacci_Matrix {
    static int getNthNumber(int n)
    {
        if(n==0)
        {
            return 1;
        }
        else
        {
            n--;
        }
        long [][]matrix_a=new long [2][2];
        matrix_a[0][0]=1;
        matrix_a[0][1]=1;
        matrix_a[1][0]=1;
        matrix_a[1][1]=0;
        matrix_a=matrix_quick_pow(matrix_a,n);
        long[][]c=new long[2][1];
        c[0][0]=1;
        c[1][0]=1;
        long [][]ans=matrix_multiplication(matrix_a,c);
        return (int)ans[0][0];

    }
    static long[][] matrix_quick_pow(long[][]a,long b)
    {
        int row=a.length;
        long [][]res=new long[row][row];
        for(int i=0;i<row;i++)
        {
            res[i][i]=1;
        }
        while (b!=0)
        {
            if((b&1)==1)
            {
                res=matrix_multiplication(res,a);
            }
            a=matrix_multiplication(a,a);
            b>>=1;
        }
        return res;
    }
    static long[][] matrix_multiplication(long [][]a,long [][]b)
    {

        int row_1=a.length;
        int col_1=a[0].length;
        int row_2=b.length;
        int col_2=b[0].length;
        long [][]ans=new long[row_1][col_2];
        for(int i=0;i<row_1;i++)
        {
            for(int j=0;j<col_2;j++)
            {
                for(int k=0;k<row_2;k++)
                {
                    ans[i][j]+=a[i][k]*b[k][j];
                    ans[i][j]=ans[i][j]%1000000007;
                }
            }
        }
        return ans;
    }
}
