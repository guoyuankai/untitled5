package mypackage;

import java.util.Scanner;

public class TreeRoute {

    public void solution()
    {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int location[] = new int[n];
        for(int i=0;i<n;i++){
            location[i] = scanner.nextInt();
        }
        int nodeVal[] = new int[n];
        int nodeLayer[] = new int[n];
        int nodeLocation[] = new int[n];
        for(int i=0;i<n;i++){
            //个位数是节点值
            nodeVal[i] = location[i]%10;
            //百位是层数
            nodeLayer[i] = location[i]/100;
            //十位是位置
            nodeLocation[i] = location[i]%100/10;
        }
        //保存每个节点被访问的次数，每个都初始化为零
        int root[] = new int[n];
        for(int i=0;i<n;i++){
            root[i] = 0;
        }
        //index指示的是寻找每个节点的父节点的索引，因此从头到尾值从n-1到0，每个值都只出现了一次
        int index = n-1;
        for(int i=n-1;i>=0;i--){
            while(index>=0){
                if(nodeLayer[index] == nodeLayer[i]-1 && Math.ceil(Float.valueOf(nodeLocation[i])/2) == nodeLocation[index]){
                    //因为初始化为了0，因此对于叶子节点的父节点，此时的累加是加一
                    if(root[i] == 0){
                        root[index] += 1;
                    }
                    else{
                        root[index] += root[i];
                    }
                    break;
                }
                else{
                    index--;
                }
            }
        }
        //count 保存的是路径值的累加
        int count = 0;
        for(int i=n-1;i>=0;i--){
            if(root[i] == 0){
                //叶子节点只会被访问一次
                count+= nodeVal[i];
            }
            else{
                count += nodeVal[i]*root[i];
            }
        }
        System.out.println(count);
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []array=new int[n];
        int []layer_info=new int[n];
        int []pos_info=new int[n];
        int []value=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
            layer_info[i]=array[i]/100;
            pos_info[i]=(array[i]/10)%10;
            value[i]=array[i]%10;
        }
        int []count=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                if(layer_info[j]==layer_info[i]+1&&(pos_info[j]+1)/2==pos_info[i])
                {
                    count[i]+=count[j];
                }
            }
            if(count[i]==0)
            {
                count[i]=1;
            }

        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=count[i]*value[i];
        }
        System.out.println(ans);

    }
}
