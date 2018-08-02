public class fen_ping_guo {
    public static int apple(int m,int n)
    {
        if(m==0||n==1)
        {
            return 1;
        }
        if(n>m)
        {
            return apple(m,m);
        }
        else
        {
            return apple(m-n,n)+apple(m,n-1);
        }
    }
}
