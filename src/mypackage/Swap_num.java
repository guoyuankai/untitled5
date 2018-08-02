package mypackage;

import java.util.Scanner;

public class Swap_num {
    public static int distance(char[]num1,char[]num2,int swap_flag,int pos1,int pos2)
    {
        int ans=0;
        if(swap_flag==0)
        {
            for (int i = 0; i < num1.length; i++) {
                ans += Math.abs(num1[i] - num2[i]);
            }

        }
        else
        {
            for (int i = 0; i < num1.length; i++) {
                if(i!=pos1&&i!=pos2) {
                    ans += Math.abs(num1[i] - num2[i]);
                }

            }
            ans+=Math.abs(num1[pos1]-num2[pos2])+Math.abs(num1[pos2]-num2[pos1]);
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String a=sc.next();
        String b=sc.next();
        char []num1=new char[n];
        char []num2=new char[n];
        for(int i=0;i<n;i++)
        {
            num1[i]=a.charAt(i);
            num2[i]=b.charAt(i);
        }
        int pos1=-1;
        int pos2=-1;
        int swap_count=0;
        int temp_min=Integer.MAX_VALUE;
        int result=distance(num1,num2,0,-1,-1);
        while (true)
        {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int mydis = distance(num1, num2, 1, i, j);
                    if (mydis < temp_min) {
                        temp_min = mydis;
                        pos1 = i;
                        pos2 = j;
                    }
                }
            }

            if(temp_min+1<result)
            {
                char temp=num1[pos1];
                num1[pos1]=num1[pos2];
                num1[pos2]=temp;
                result=temp_min;
                swap_count++;
            }
            else
            {
                break;
            }
        }
        System.out.println(result+swap_count);


    }
}
