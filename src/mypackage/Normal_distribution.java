package mypackage;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Normal_distribution {

    static double[] gaussrand()
    {
        double v1,v2,s;
        int phase=0;
        do {
            v1=(double)Math.random()*2-1.0;
            v2=(double)Math.random()*2-1.0;
            s=v1*v1+v2*v2;
        }while (s>=1||s==0);
        double []ans=new double[2];
        ans[0]=v1*Math.sqrt(-2*Math.log(s)/s);
        ans[1]=v2*Math.sqrt(-2*Math.log(s)/s);

        return ans;
    }

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.UP);
        HashMap mycount=new HashMap();
        for(int i=0;i<100000;i++)
        {
            double []t=gaussrand();
            t[0]=Double.valueOf(nf.format(t[0]));
            t[1]=Double.valueOf(nf.format(t[1]));
            for(int j=0;j<2;j++)
            {
                if(mycount.containsKey(t[j]))
                {
                    int val=(int)mycount.get(t[j]);
                    mycount.replace(t[j],val+1);
                }
                else
                {
                    mycount.put(t[j],0);
                }
            }

        }


        Object [] key_arr =mycount.keySet().toArray();
        Arrays.sort(key_arr);
        for  (Object key : key_arr) {
            Object value = mycount.get(key);
            System.out.println(key+"\t"+mycount.get(key));
        }
//        Iterator myit=mycount.entrySet().iterator();
//        while (myit.hasNext())
//        {
//            Map.Entry entry = (Map.Entry) myit.next();
//            double key=(double) entry.getKey();
//            System.out.println(key+"\t"+mycount.get(key));
//        }
    }

}
