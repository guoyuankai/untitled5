public class Fibonacci {
    public static long solution(int n)
    {
        double a=Math.pow((1+Math.sqrt(5))/2.0,n);
        double b=Math.pow((1-Math.sqrt(5))/2.0,n);
        double c=(a-b)/Math.sqrt(5);
        return (long)c;
    }

}
