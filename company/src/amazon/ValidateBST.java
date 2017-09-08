package amazon;

import common.TreeNode;

public class ValidateBST {
	/*
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return helper(root, new pair(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    
    class pair{
        int max;
        int min;
        public pair(int a, int b){
            max = a;
            min = b;
        }
    }
    boolean helper(TreeNode root, pair maxin){
        if(root.left==null && root.right==null){
            maxin.max = maxin.min = root.val;
            return true;
        }
        if(root.left == null){
            maxin.min = root.val;
        } else{
            pair leftm = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if(helper(root.left, leftm)){
                if(root.val <= leftm.max)
                    return false;
                else
                    maxin.min = leftm.min;
            } else
                return false;
        }
        
        if(root.right==null){
            maxin.max = root.val;
        } else{
            pair rightm = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if(helper(root.right, rightm)){
                if(root.val >= rightm.min)
                    return false;
                else
                    maxin.max = rightm.max;
            } else
                return false;
        }
        return true;  
        
    }
    */
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

}
