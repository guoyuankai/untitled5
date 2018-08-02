import java.util.Scanner;

public class Prime {
    public static boolean isprime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void prime1(int n)
    {
        int []allprime=new int[n];
        int []check=new int[n+1];
        int num=0;
        check[0]=check[1]=1;
        for(int i=2;i<=n;i++)
        {
            if(check[i]==0)
            {
                allprime[num++]=i;
            }
            for(int j=2*i;j<=n;j=j+i)
            {
                check[j]=1;
            }
        }
        for(int j=0;j<num;j++)
        {
            System.out.println(allprime[j]);
        }
    }

    public static void prime2(int n)
    {
        int []allprime=new int[n];
        int []check=new int[n+1];
        int num=0;
        for(int i=2;i<=n;i++)
        {
            if(check[i]==0)
            {
                allprime[num++]=i;
            }
            for(int j=0;j<num &&i*allprime[j]<=n;j++)
            {
                check[i*allprime[j]]=1;
                if(i%allprime[j]==0)break;
            }
        }
        for(int j=0;j<num;j++)
        {
            System.out.println(allprime[j]);
        }
    }
    void ola_prime(int n)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int []prime=new int[n+1];
            int []visit=new int[n+1];
            int count=0;
            for(int i=2;i<=n;i++)
            {
                if(visit[i]==0)
                {
                    prime[count]=i;
                    count++;
                }
                for(int j=0;j<count&&i*prime[j]<=n;j++)
                {
                    visit[i*prime[j]]=1;
                    if(i%prime[j]==0)
                    {
                        break;
                    }
                }
            }
            System.out.print(count);
        }
    }

}
