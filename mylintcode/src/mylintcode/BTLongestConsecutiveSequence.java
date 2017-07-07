package mylintcode;

public class BTLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		retValue ret = helper(root);
		return ret.max;
	}
	
	public class retValue{
		int max;
		int rmax;
	}
	
	public retValue helper(TreeNode root){
		if(root == null)
			return new retValue();
		
		retValue ret = new retValue();
		retValue left = helper(root.left);
		if(root.left!= null && root.val+1 == root.left.val){
			ret.rmax = left.rmax+1;
		}
		else
			ret.rmax = 1;
		if(ret.rmax >= left.max)
			ret.max = ret.rmax;
		else
			ret.max = left.max;
		
		retValue right = helper(root.right);
		if(root.right!=null && root.val+1 == root.right.val){
			if(right.rmax +1 > ret.rmax)
				ret.rmax = right.rmax+1;
		}
		if(ret.rmax >= ret.max)
			ret.max = ret.rmax;
		if(ret.max < right.max)
			ret.max = right.max;
		return ret;
	}

}
