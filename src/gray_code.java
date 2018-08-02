import java.util.ArrayList;

public class gray_code {
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int num = 1 << n;
        for(int i = 0; i < num; ++i){
            int a=i>>1;
            int b=a^i;
            arr.add(i>>1^i);
        }
        return arr;
    }
    public static ArrayList<Integer> grayCode2(int n)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i=0;i<n;i++)
        {
            int high_bit=1<<i;
            for(int j=arr.size()-1;j>=0;j--)
            {
                int num=arr.get(j);
                int t=high_bit|num;
                arr.add(t);
            }
        }
        return arr;
    }
}
