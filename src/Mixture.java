public class Mixture {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        int n1=0;
        boolean flag1=false;
        for(int i=0;i<v;i++)
        {
            if(C.charAt(i)==A.charAt(n1))
            {
                n1++;
            }
            if(n1==n-1)
            {
                flag1=true;
                break;
            }
        }
        int n2=0;
        boolean flag2=false;
        for(int i=0;i<v;i++)
        {
            if(C.charAt(i)==B.charAt(n2))
            {
                n2++;
            }
            if(n2==m-1)
            {
                flag2=true;
                break;
            }
        }
        return flag1&&flag2;
    }
}
