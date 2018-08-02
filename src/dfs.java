import java.util.ArrayList;

public class dfs {
    static ArrayList ans;
    static int mymax=Integer.MIN_VALUE;
    public static void dfs(int x, int y, int n, int m, int map[][], ArrayList path, int [][]visit, int p, ArrayList ans)
    {
        if(p<0)
        {
            return ;
        }
        if(x==0&&y==m-1&&p>=0)
        {
            if(mymax<p)
            {
                mymax=p;
                ans.clear();
                for(int k=0;k<path.size();k++)
                {
                    int []temp=(int [])path.get(k);
                    ans.add(temp);
                }
            }
            return ;
        }
        if(x+1<n && map[x+1][y]!=0 && visit[x+1][y]==0)
        {
            visit[x+1][y]=1;
            int []pos=new int[2];
            pos[0]=x+1;
            pos[1]=y;
            path.add(pos);
            dfs(x+1,y,n,m,map,path,visit,p,ans);
            visit[x+1][y]=0;
            path.remove(path.size()-1);
        }

        if(x-1>=0 && map[x-1][y]!=0 && visit[x-1][y]==0)
        {
            visit[x-1][y]=1;
            p=p-3;
            int []pos=new int[2];
            pos[0]=x-1;
            pos[1]=y;
            path.add(pos);
            dfs(x-1,y,n,m,map,path,visit,p,ans);
            path.remove(path.size()-1);
            p=p+3;
            visit[x-1][y]=0;
        }


        if(y+1<m && map[x][y+1]!=0&&visit[x][y+1]==0)
        {
            visit[x][y+1]=1;
            p=p-1;
            int []pos=new int[2];
            pos[0]=x;
            pos[1]=y+1;
            path.add(pos);
            dfs(x,y+1,n,m,map,path,visit,p,ans);
            path.remove(path.size()-1);
            p++;
            visit[x][y+1]=0;
        }
        if(y-1>=0 && map[x][y-1]!=0&&visit[x][y-1]==0)
        {
            visit[x][y-1]=1;
            p--;
            int []pos=new int[2];
            pos[0]=x;
            pos[1]=y-1;
            path.add(pos);
            dfs(x,y-1,n,m,map,path,visit,p,ans);
            path.remove(path.size()-1);
            p++;
            visit[x][y-1]=0;
        }
        return ;
    }
}
