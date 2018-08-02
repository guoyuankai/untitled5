import java.util.Scanner;

public class hould_pie {
   void solution()
   {
       Scanner sc=new Scanner(System.in);
       while (sc.hasNext())
       {
           int max=-1;
           int maxtime=-1;
           int t=sc.nextInt();
           if(t==0)
           {
               break;
           }
           int [][]dp=new int[120000][11];
           for(int i=0;i<t;i++)
           {
               int pos=sc.nextInt();
               int time=sc.nextInt();
               if(time>maxtime)
               {
                   maxtime=time;
               }
               dp[time][pos]++;
           }
           for(int i=maxtime-1;i>=0;i--)
           {
               for(int j=0;j<11;j++)
               {
                   if(j==0)
                   {
                       dp[i][j]=Math.max(dp[i+1][j],dp[i+1][j+1])+dp[i][j];
                   }
                   else if(j==10)
                   {
                       dp[i][j]=Math.max(dp[i+1][j],dp[i+1][j-1])+dp[i][j];
                   }
                   else
                   {
                       dp[i][j]=Math.max(dp[i+1][j],Math.max(dp[i+1][j-1],dp[i+1][j+1]))+dp[i][j];
                   }

               }

           }
           System.out.println(dp[0][5]);

       }
   }

}
