public class gcd {
    //最小公倍数=两整数的乘积÷最大公约数
    public static int gcd1(int a,int b)
    {
        if(a<b)
        {
            gcd1(b,a);
        }
        while(b>0)
        {
            int t=a;
            a=b;
            b=t%b;
        }
        return a;
    }
    public static int gcd2(int a,int b)
    {
        if(a<b)
        {
            gcd2(b,a);
        }
        if(b==0)
        {
            return a;
        }
        return  gcd2(b,a%b);
    }
    public static int steingcd(int a,int b)
    {
        if(a==0 ||b==0)
        {
            return Math.abs(a-b);
        }
        if(a%2==0 && b%2==0)
        {
            return 2*steingcd(a>>1,b>>1);
        }
        else if(a%2==0)
        {
            return steingcd(a>>1,b);
        }
        else if(b%2==0)
        {
            return steingcd(a,b>>1);
        }
        else
        {
            return steingcd(Math.abs(a-b),Math.min(a,b));
        }
    }
}
