public class ListNode {
    int val;
    ListNode next;
    ListNode(int x)
    {
        val=x;
        next=null;
    }
    int lenth=0;

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
        {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
               return true;
            }
        }
        return false;
    }




    public ListNode detectCycle_beigin(ListNode head) {
        if(head==null||head.next==null)
        {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        int flag=0;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
           ListNode p1=head;
           ListNode p2=slow;
           while (p1!=p2)
           {
               p1=p1.next;
               p2=p2.next;
           }
           return p1;
        }
       else
        {
            return null;
        }

    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
        {
            return;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode backhead=slow.next;
        slow.next=null;

        ListNode head2=reverselist(backhead);
        ListNode first=head;
        while (head2!=null)
        {
            ListNode next=first.next;
            first.next=head2;
            head2=head2.next;
            first=first.next;
            first.next=next;
            first=first.next;
        }

    }
    public ListNode reverselist(ListNode head)
    {
        ListNode prv=null;
        ListNode next=null;
        while(head!=null)
        {
            next=head.next;
            head.next=prv;
            prv=head;
            head=next;
        }
        return prv;
    }









    public ListNode insertionSortList(ListNode head) {
       ListNode myhead=null;
       if(head==null||head.next==null)
       {
           return head;
       }
       ListNode front=head.next;
       ListNode behind=head;
       while (front!=null)
       {
         behind.next=null;
         myhead=insert(myhead,behind);
         behind=front;
         front=front.next;
       }
       myhead=insert(myhead,behind);
       return myhead;
    }
    public ListNode insert(ListNode myhead,ListNode target)
    {
       if(myhead==null)
       {
           myhead=target;
           myhead.next=null;
           return myhead;
       }
       if(target.val<=myhead.val)
       {
           target.next=myhead;
           return target;
       }
       else
       {
           ListNode behind=myhead;
           ListNode front=myhead.next;
           while(front!=null && front.val<target.val)
           {
               behind=front;
               front=front.next;
           }
           behind.next=target;
           target.next=front;
           return myhead;
       }


    }




    public ListNode sortList(ListNode head) {
        if(head==null ||head.next==null)
        {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode left=sortList(slow.next);
        slow.next=null;
        ListNode right=sortList(head);
        return merge(left,right);

    }
    public ListNode merge(ListNode left,ListNode right)
    {
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        ListNode myhead=null;
        if(left.val<right.val)
        {
            myhead=left;
            myhead.next=merge(left.next,right);
        }
        else
        {
            myhead=right;
            myhead.next=merge(left,right.next);
        }
        return myhead;
    }


}