import java.util.Scanner;

public class fentiandi {
    public void solution()
    {
        int n,m;
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            n=sc.nextInt();
            m=sc.nextInt();
            int num[][]=new int[n][m];
            for(int i=0;i<n;i++)
            {
                String t=sc.next();
                for(int j=0;j<m;j++)
                {
                    num[i][j]=t.charAt(j)-'0';
                }
            }
            int sum[][]=new int[n+1][m+1];
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+num[i-1][j-1];
                }
            }
            int left=0,right=sum[n][m],res=0;
            while (left<=right)
            {
                int mid=(left+right)/2;
                if(judge(mid,n,m,sum))
                {
                    res=mid;
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }

            }
            System.out.println(res);

        }
    }

    public static boolean judge(int x,int n,int m,int [][]sum)
    {
        for(int i=1;i<=n-3;i++)
        {
            for(int j=i+1;j<=n-2;j++)
            {
                for(int k=j+1;k<=n-1;k++)
                {
                    int last=0;
                    int count=0;
                    for(int r=0;r<=m;r++)
                    {
                        int s1=area(i,r,0,last,sum);
                        int s2=area(j,r,i,last,sum);
                        int s3=area(k,r,j,last,sum);
                        int s4=area(n,r,k,last,sum);
                        if(s1>=x&&s2>=x&&s3>=x&&s4>=x)
                        {
                            last=r;
                            count++;
                        }

                    }
                    if(count>=4)
                    {
                        return true;
                    }

                }
            }
        }
        return false;
    }
    public static int area(int x,int y,int i,int j,int[][]sum)
    {
        return (sum[x][y]-sum[i][y]-sum[x][j]+sum[i][j]);
    }

}
