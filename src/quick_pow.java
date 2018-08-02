public class quick_pow {
    static long solution(int a,int b)
    {
        int sum=1;
        while (b!=0)
        {
            if((b&1)==1)
            {
                sum=sum*a;
            }
            a*=a;
            b>>=1;
        }
        return sum;
    }
    static int[][] matrix_quick_pow(int[][]a,int b)
    {
        int row=a.length;
        int [][]res=new int[row][row];
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
    static int[][] matrix_multiplication(int [][]a,int [][]b)
    {

        int row_1=a.length;
        int col_1=a[0].length;
        int row_2=b.length;
        int col_2=b[0].length;
        int [][]ans=new int[row_1][col_2];
        for(int i=0;i<row_1;i++)
        {
            for(int j=0;j<col_2;j++)
            {
               for(int k=0;k<row_2;k++)
               {
                   ans[i][j]+=a[i][k]*b[k][j];
               }
            }
        }
        return ans;
    }
}
