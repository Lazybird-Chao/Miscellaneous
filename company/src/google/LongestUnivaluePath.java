package google;

public class LongestUnivaluePath {
	public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        maxpath = 0;
        helper(root);
        return maxpath-1;
    }
    int maxpath;
    retValue helper(TreeNode root){
        if(root == null)
            return new retValue(0,0);
        retValue lret = helper(root.left);
        retValue rret = helper(root.right);
        retValue ret = new retValue(1,1);
        if(root.left != null && root.val == root.left.val){
            ret.leftLen = Math.max(lret.leftLen, lret.rightLen) + 1;
        }
        if(root.right != null && root.val == root.right.val){
            ret.rightLen = Math.max(rret.leftLen, rret.rightLen) + 1;
        }
        maxpath = Math.max(maxpath, ret.leftLen+ret.rightLen-1);
        return ret;
    }
    class retValue{
        int leftLen;
        int rightLen;
        public retValue(int l, int r){
            leftLen = l;
            rightLen = r;
        }
    }

}
