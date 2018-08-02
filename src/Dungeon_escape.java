import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Dungeon_escape {
    public static void solution()
    {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        char [][]dungeon=new char[n][m];
        boolean [][] flag_map=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            String temp=sc.next();
            for(int j=0;j<m;j++)
            {
                dungeon[i][j]=temp.charAt(j);
            }
        }
        int start_x=sc.nextInt();
        int start_y=sc.nextInt();
        int [][]distance=new int[n][m];

        int k=sc.nextInt();
        int [][]direction=new int[k][2];
        for(int i=0;i<k;i++)
        {
            direction[i][0]=sc.nextInt();
            direction[i][1]=sc.nextInt();
        }
        ArrayList<int[]> quene=new ArrayList<>();
        int []temp={start_x,start_y};
        flag_map[start_x][start_y]=true;
        quene.add(temp);
        while (!quene.isEmpty())
        {

            temp=quene.get(0);
            quene.remove(0);
            for(int l=0;l<k;l++)
            {
                if(temp[0]+direction[l][0]>=n||temp[1]+direction[l][1]>=m||temp[0]+direction[l][0]<0||temp[1]+direction[l][1]<0)
                {
                    continue;
                }

                if(dungeon[temp[0]+direction[l][0]][temp[1]+direction[l][1]]!='X'&&flag_map[temp[0]+direction[l][0]][temp[1]+direction[l][1]]==false)
                {
                    if(distance[temp[0]][temp[1]]+1>distance[temp[0]+direction[l][0]][temp[1]+direction[l][1]])
                    {
                        distance[temp[0]+direction[l][0]][temp[1]+direction[l][1]]=distance[temp[0]][temp[1]]+1;
                    }
                    int []t=new int[2];
                    t[0]=temp[0]+direction[l][0];
                    t[1]=temp[1]+direction[l][1];
                    quene.add(t);
                    flag_map[t[0]][t[1]]=true;


                }
            }
        }
        int ans=0;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(flag_map[i][j]==false&&dungeon[i][j]=='.')
                {
                    flag=true;
                }
                ans=Math.max(ans,distance[i][j]);
            }
        }
        if(flag==true)
        {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }
}
