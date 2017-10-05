package facebook;

public class TwoSum4InBST {
	public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);

    }
    boolean helper(TreeNode cur, TreeNode root, int k){
        if(cur == null)
            return false;
        if(k - cur.val != cur.val && findNum(root, k-cur.val))
            return true;
        if( helper(cur.left, root, k) || helper(cur.right, root, k))
            return true;
        return false;
    }
    
    boolean findNum(TreeNode root, int n){
        if(root == null)
            return false;
        if(root.val == n)
            return true;
        if(n > root.val)
            return findNum(root.right, n);
        else
            return findNum(root.left, n);
    }

}
