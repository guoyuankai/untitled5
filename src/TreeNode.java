import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }





    public int run(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int left=run(root.left);
        int right=run(root.right);
        if(left==0||right==0)
        {
            return left+right+1;
        }
        else
        {
            return Math.min(left,right)+1;
        }
    }

}



