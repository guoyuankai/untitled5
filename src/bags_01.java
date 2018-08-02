import java.util.Scanner;

public class bags_01 {
    public void bags()
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int v=sc.nextInt();
            int []value=new int[n];
            int []volum=new int[n];
            for(int i=0;i<n;i++)
            {
                value[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                volum[i]=sc.nextInt();
            }
            int dp[][]=new int[n+1][v+1];
            for(int i=1;i<=n;i++)
            {
                for(int j=0;j<=v;j++)
                {
                    if(j>=volum[i-1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volum[i - 1]] + value[i - 1]);
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[n][v]);
        }
    }

    public void thef_bag()
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0)
        {
            double totalrisk=sc.nextDouble();
            int n=sc.nextInt();
            int []val=new int [n+1];
            double []risk=new double [n+1];
            int total_val=0;
            int max=0;
            for(int i=1;i<=n;i++)
            {
                val[i]=sc.nextInt();
                total_val+=val[i];
                risk[i]=sc.nextDouble();
            }
            double [][]dp=new double[n+1][total_val+1];
            dp[0][0]=1;
            for(int i=1;i<=n;i++)
            {
                for(int j=0;j<=total_val;j++)
                {
                    if(j-val[i]>=0)
                    {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-val[i]]*(1-risk[i]));
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }

                }

            }
            for(int j=0;j<=total_val;j++)
            {
                if(dp[n][j]>=1-totalrisk)
                {
                    if(max<j)
                    {
                        max=j;
                    }
                }
            }
            System.out.println(max);

        }
    }

    public void onedim()
    {
        Scanner sc=new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        while(n!=0||m!=0)
        {
            int[] cost = new int[m+1];
            double[] posbility=new double[m+1];
            for(int i=1;i<=m;i++)
            {
                cost[i]=sc.nextInt();
                posbility[i]=sc.nextDouble();
            }
            double dp[]=new double[n+1];
            for(int i=1;i<=m;i++)
            {
                for(int j=n;j>=0;j--)
                {
                    if(j-cost[i]>=0)
                    {
                        dp[j]=Math.max(dp[j],dp[j-cost[i]]+posbility[i]-dp[j-cost[i]]*posbility[i]);
                    }
                    else
                    {
                        dp[j]=dp[j];
                    }
                }
            }
            double t=dp[n]*100;
            System.out.print(String.format("%.1f",t));
            System.out.println('%');
            n = sc.nextInt();
            m = sc.nextInt();
        }
    }

}
