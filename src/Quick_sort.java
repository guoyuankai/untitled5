public class Quick_sort {
    public static void quicksort(int []a,int left,int right)
    {
        if(left>=right)
        {
            return;
        }
        int key=a[left];
        int low=left;
        int high=right;
        while (low<high)
        {
            while (low<high&&a[high]>=key)
            {
                high--;
            }
            a[low]=a[high];
            while (low<high&&a[low]<=key)
            {
                low++;
            }
            a[high]=a[low];
        }
        a[low]=key;
        quicksort(a,left,low-1);
        quicksort(a,low+1,right);
    }
    //归并排序
    public void mergesort(int []m,int first,int last)
    {
        if(first<last)
        {
            int mid=(first+last)/2;
            mergesort(m,first,mid);
            mergesort(m,mid+1,last);
            meragearray(m,first,mid,last);
        }
    }
    public void meragearray(int []a,int first,int mid,int last)
    {
      int i=first,j=mid+1;
      int k=0;
      int []ans=new int [last+1];
      while(i<=mid&&j<=last)
      {
          if(a[i]<a[j])
          {
              ans[k]=a[i];
              k++;
              i++;
          }
          else
          {
              ans[k++]=a[j++];
          }
      }
      while (i<=mid)
      {
          ans[k++]=a[i++];
      }
      while (j<=mid)
      {
          ans[k++]=a[j++];
      }
      for(i=0;i<k;i++)
      {
          a[first+i]=ans[i];
      }
    }
    //插入排序
    public void insert_sort(int []m)
    {
        int i,j;
        for(i=1;i<m.length;i++)
        {
            if(m[i]<m[i-1])
            {
                int temp=m[i];
                for(j=i-1;j>=0 &&m[j]>temp;j--)
                {
                    m[j+1]=m[j];
                }
                m[j+1]=temp;

            }
        }
    }
    //递归实现
    public void insert_sort2(int []m,int n)
    {
        if(n>0)
        {
            insert_sort2(m,n-1);
            insert(m,n);
        }
    }
    public void insert(int []m,int n)
    {
        int i;
        int t=m[n];
        for(i=n-1;i>=0&&m[i]>t;i--)
        {
            m[i+1]=m[i];
        }
        m[i+1]=t;
    }



    public void heap_sort(int []m)
    {
        for(int i=m.length/2-1;i>=0;i--)
        {
            adjust_heap(m,i,m.length);
        }
        for(int j=m.length-1;j>0;j--)
        {
            swap(m,0,j);
            adjust_heap(m,0,j);

        }
    }
    public void adjust_heap(int []m,int pos,int length)
    {
        int temp=m[pos];
        for(int i=2*pos+1;i<length;i=i*2+1)
        {
            if(i+1<length&&m[i]<m[i+1])
            {
                i++;
            }
            if(m[pos]<m[i])
            {
              swap(m,pos,i);
              pos=i;
            }
            else
            {
                break;
            }
        }

    }
    public void swap(int []array,int x,int y)
    {
        int t=array[x];
        array[x]=array[y];
        array[y]=t;

    }




}
