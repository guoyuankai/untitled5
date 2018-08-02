public class search_in_rotated_sorted_array {
    public static int search(int[] A, int target) {
        int left=0;
        int right=A.length-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(target==A[mid])
            {
                return mid;
            }
            if(A[mid]>=A[left])
            {
                if(target>=A[left]&&target<A[mid])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            else
            {
                if(target>A[mid]&&target<=A[right])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public boolean search2(int[] A, int target) {
        int left=0;
        int right=A.length-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(target==A[mid])
            {
                return true;
            }
            if(A[left]<A[mid])
            {
                if(target>=A[left]&&target<A[mid])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            else if(A[left]>A[mid])
            {
                if(target>A[mid]&&target<=A[right])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
            else
            {
                left++;
            }
        }
        return false;
    }
    public static int binarysearch(int []A,int target,int left,int right)
    {
        if(A==null||A.length==0)
        {
            return -1;
        }
        while (left<=right)
        {
            int mid=(left+right)/2;
            if(A[mid]>target)
            {
                right=mid-1;
            }
            else if(A[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
