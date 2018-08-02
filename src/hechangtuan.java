import java.util.Scanner;

public class hechangtuan {
    public void solution()
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            long max=-1;
            int n=sc.nextInt();
            int val[]=new int[n+1];
            for(int i=1;i<=n;i++)
            {
                val[i]=sc.nextInt();
            }
            int k=sc.nextInt();
            int d=sc.nextInt();
            long [][]dp_max=new long[n+1][k+1];
            long [][]dp_min=new long[n+1][k+1];
            for(int i=1;i<=n;i++)
            {
                dp_max[i][1]=val[i];
                dp_min[i][1]=val[i];
            }
            for(int i=1;i<=n;i++)
            {
                for(int j=2;j<=k;j++)
                {
                    for(int l=1;l<=d&&i-l>=1;l++)
                    {
                        dp_max[i][j]=Math.max(dp_max[i][j],Math.max(dp_max[i-l][j-1]*val[i],dp_min[i-l][j-1]*val[i]));
                        dp_min[i][j]=Math.min(dp_min[i][j],Math.min(dp_max[i-l][j-1]*val[i],dp_min[i-l][j-1]*val[i]));
                    }
                }
                max=Math.max(max,dp_max[i][k]);

            }
            System.out.println(max);
        }
    }
}
