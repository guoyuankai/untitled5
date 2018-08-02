import java.util.Stack;

public class leetcode {
    public int evalRPN(String[] tokens) {
        Stack<Integer> mystack=new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("/")&&!tokens[i].equals("*"))
            {
                int t=Integer.parseInt(tokens[i]);
                mystack.push(t);
            }
            else
            {
                int b=mystack.pop();
                int a=mystack.pop();
                if(tokens[i].equals("+"))
                {
                    mystack.push(a+b);
                }
                if(tokens[i].equals("-"))
                {
                    mystack.push(a-b);
                }
                if(tokens[i].equals("*"))
                {
                    mystack.push(a*b);
                }
                if(tokens[i].equals("/"))
                {
                    mystack.push(a/b);
                }
            }
        }
        int ans=mystack.pop();
        return ans;
    }


}





