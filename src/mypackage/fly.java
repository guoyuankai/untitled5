package mypackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class fly {
    public static void  solution()
    {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        String[][] map=new String[m][2];
        int [][] realmap=new int[n][n];
        HashMap<String,Integer> mymap=new HashMap<String, Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                realmap[i][j]=Integer.MAX_VALUE;
            }
        }
        int num=0;
        for(int i=0;i<m;i++)
        {


               String t1=sc.next();
               if(!mymap.containsKey(t1))
               {
                   mymap.put(t1,num);
                   num++;
               }
                String t2=sc.next();
                if(!mymap.containsKey(t2))
                {
                    mymap.put(t2,num);
                    num++;
                }
                realmap[mymap.get(t1)][mymap.get(t2)]=1;
        }
        String strat=sc.next();
        int start_num=mymap.get(strat);
        String end=sc.next();
        int end_num=mymap.get(end);
        int[] ans=dijkstra(realmap,n,start_num);
        System.out.println(ans[end_num]);



    }

    public static int[] dijkstra(int[][] graph,int n,int u){
        int inf=Integer.MAX_VALUE;//表示两个点之间无法直接连通
        int dist[]=new int[n];
        boolean s[]=new boolean[n];
        Arrays.fill(s, false);
        Arrays.fill(dist, inf);
        int min,v;
        for(int i=0;i<n;i++){
            dist[i]=graph[u][i];
        }
        s[u]=true;
        while(true){
            min=inf;v=-1;
            //找到最小的dist
            for(int i=0;i<n;i++){
                if(!s[i]){
                    if(dist[i]<min){min=dist[i];v=i;}
                }
            }
            if(v==-1)
                break;//找不到更短的路径了
            //更新最短路径
            s[v]=true;
            for(int i=0;i<n;i++){
                if(!s[i]&&
                        graph[v][i]!=inf&&
                        dist[v]+graph[v][i]<dist[i]){
                    dist[i]=dist[v]+graph[v][i];
                }
            }
        }
        return dist;
    }



}
