package mylintcode;

public class BTLongestConsecutiveSequence2 {
	public int longestConsecutive2(TreeNode root) {
		if(root==null)
			return 0;
		maxLength =1;
		helper(root);
		return maxLength;
		
	}
	
	int maxLength;
	
	public class retValue{
		int assendLen;
		int desendLen;
	}
	
	retValue helper(TreeNode root) {
		if(root==null) {
			return null;
		}
		
		retValue lret = helper(root.left);
		if(lret!=null) {
			if(root.val +1 == root.left.val)
				lret.assendLen++;
			else
				lret.assendLen=1;
			if(root.val-1 == root.left.val)
				lret.desendLen++;
			else
				lret.desendLen=1;
		}
		retValue rret = helper(root.right);
		if(rret!=null) {
			if(root.val +1 == root.right.val)
				rret.assendLen++;
			else
				rret.assendLen=1;
			if(root.val-1 == root.right.val)
				rret.desendLen++;
			else
				rret.desendLen=1;
		}
		int amax = 1;
		int dmax = 1;
		if(lret!=null) {
			amax += lret.assendLen-1;
			dmax += lret.desendLen-1;
		}
		if(rret!=null) {
			amax += rret.desendLen-1;
			dmax += rret.assendLen-1;
		}
		maxLength = Math.max(maxLength, amax);
		maxLength = Math.max(maxLength, dmax);
		
		retValue ret = new retValue();
		ret.assendLen=ret.desendLen=1;
		if(lret!=null)
		    ret.assendLen = Math.max(lret.assendLen, rret.assendLen);
		if(rret!=null)
		    ret.desendLen = Math.max(lret.desendLen, rret.desendLen);
		return ret;
			
	}

}
