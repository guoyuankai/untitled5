public class Point {
    int x;
    int y;
    Point(){x=0;y=0;};
    Point(int a,int b){x=a;y=b;};
    public int maxPoints(Point[] points) {
        if(points==null)
        {
            return 0;
        }
        if(points.length<=2)
        {
            return points.length;
        }
        int max=0;
        for(int i=0;i<points.length;i++)
        {
            int flag=0;
            for(int j=i+1;j<points.length;j++)
            {
                if(points[i].x==points[j].x &&points[i].y==points[j].y)
                {
                    flag=1;
                }
                int t=2;
                int mflag=0;
                for(int k=0;k<points.length;k++)
                {

                    if(k==i||k==j)
                    {
                        continue;
                    }
                    else if(flag==1)
                    {

                        if(points[k].x==points[i].x&&points[k].y==points[i].y)
                        {
                            t++;
                        }
                        else if(mflag==0)
                        {
                            t++;
                            mflag=1;
                        }
                    }
                    else
                    {
                        if((points[k].y-points[j].y)*(points[i].x-points[j].x)-(points[k].x-points[j].x)*(points[i].y-points[j].y)==0)
                        {
                            t++;
                        }
                    }
                }
                max=Math.max(t,max);
            }
        }
        return max;
    }

}
