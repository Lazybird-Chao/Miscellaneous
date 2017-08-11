package mylintcode;

import java.util.List;


public class BTLongestConsecutiveSequence3 {
	public int longestConsecutive3(MultiTreeNode root) {
		if(root==null)
			return 0;
		maxLength =1;
		helper(root);
		return maxLength;
	}
	
	int maxLength;
	
	public class MultiTreeNode {
	      int val;
	      List<MultiTreeNode> children;
	      MultiTreeNode(int x) { val = x; }
	 }
	
	public class retValue{
		int assendLen;
		int desendLen;
	}
	
	retValue helper(MultiTreeNode root) {
		if(root==null) {
			return new retValue();
		}
			
		int amax=1;
		int dmax=1;
		for(int i=0; i<root.children.size(); i++) {
			retValue childRet = helper(root.children.get(i));
			if(root.val +1 == root.children.get(i).val)
				amax = Math.max(amax, childRet.assendLen+1);
			else if(root.val-1 == root.children.get(i).val)
				dmax = Math.max(dmax, childRet.desendLen+1);	
		}
		int maxlen = amax+dmax-1;
		maxLength = Math.max(maxLength, maxlen);
		
		retValue ret = new retValue();
		ret.assendLen = amax;
		ret.desendLen = dmax;
		return ret;
	}

}
