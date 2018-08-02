package mypackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Rabbit {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int max_life=sc.nextInt();
        int years=sc.nextInt();
        ArrayList island=new ArrayList();
        island.add(1);
        for(int i=2;i<=years;i++)
        {
            int length=island.size();
            for(int j=0;j<length;j++)
            {
                int rabbit=(int )island.get(j);
                if(rabbit!=max_life)
                {
                    if(rabbit>=2)
                    {
                        island.add(1);
                    }
                    island.set(j,rabbit+1);
                }
            }
            Iterator myit=island.iterator();
            int max1=Integer.MIN_VALUE;
            int max2=Integer.MIN_VALUE;
            while (myit.hasNext())
            {
                int rabbit=(int)myit.next();
                if(rabbit==max_life)
                {
                    myit.remove();
                }

            }
            if(island.size()>=10)
            {
                island.remove(0);
                island.remove(0);
            }
        }
        int ans=0;
        for(int i=0;i<island.size();i++)
        {
            ans+=(int)island.get(i)*2;
        }
        System.out.println(ans);

    }
}
