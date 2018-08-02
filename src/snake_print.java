public class snake_print {
    public static void printmatrix(int [][]m)
    {
        int row=m.length;
        int col=m[0].length;
        for(int j=0;j<col;j++)
        {
            System.out.println(m[0][j]);
        }
        for(int i=1;i<row;i++)
        {
            System.out.println(m[i][col-1]);
        }
        for(int j=col-2;j>=0;j--)
        {
            System.out.println(m[row-1][j]);
        }
        for(int i=row-2;i>0;i--)
        {
            System.out.println(m[i][0]);
        }
        if(row-2<=0||col-2<=0)
        {
            return;
        }
        else
        {
            int [][]m1=new int[row-2][col-2];
            for(int i=1,ii=0;i<row-1;i++,ii++)
            {
                for(int j=1,jj=0;j<col-1;j++,jj++)
                {
                    m1[ii][jj]=m[i][j];
                }
            }
            printmatrix(m1);
        }

    }

    public static void matrixprint(int [][]matrix)
    {
        int row=matrix.length;
        int col=matrix[0].length;
        int turn=Math.min(row,col)/2;
        for(int k=0;k<=turn;k++)
        {
            for(int j=k;j<col-k;j++)
            {
                System.out.println(matrix[k][j]);
            }
            for(int i=k+1;i<row-k;i++)
            {
                System.out.println(matrix[i][col-k-1]);
            }
            for(int j=col-2-k;j>=k;j--)
            {
                System.out.println(matrix[row-1-k][j]);
            }
            for(int i=row-2-k;i>k;i--)
            {
                System.out.println(matrix[i][k]);
            }
        }

    }
}
