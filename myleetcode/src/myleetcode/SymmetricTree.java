package myleetcode;
import java.util.ArrayList;
import java.util.List;

import myleetcode.InvertBtree.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root){
		TreeNode root2 = reverseCopyTree(root);
		return isSameTree(root, root2);
	}
	
	TreeNode reverseCopyTree(TreeNode root){
		if(root ==null)
			return null;
		TreeNode left = reverseCopyTree(root.left);
		TreeNode right = reverseCopyTree(root.right);
		TreeNode root2 = new TreeNode(root.val);
		root2.left = right;
		root2.right = left;
		return root2;
	}
	
	boolean isSameTree(TreeNode root1, TreeNode root2){
		if(root1 != null && root2!=null){
			if(root1.val != root2.val)
				return false;
			else{
				return isSameTree(root1.left, root2.left) && 
						isSameTree(root1.right, root2.right);
			}
		}
		else if(root1 ==null && root2==null)
			return true;
		else
			return false;
	}
	
	public boolean method2(TreeNode root){
		if(root ==null)
		    return true;
		List<TreeNode> leftOrder = new ArrayList<TreeNode>();
		List<TreeNode> rightOrder = new ArrayList<TreeNode>();
		TreeNode p1, p2;
		if(root.left !=null)
		    leftOrder.add(root.left);
		if(root.right !=null)
		    rightOrder.add(root.right);
		int idx = 0;
		while(idx < leftOrder.size() && idx<rightOrder.size()){
			p1 = leftOrder.get(idx);
			p2 = rightOrder.get(idx);
			if((p1==null && p2!=null) || 
					(p1!=null && p2==null))
				return false;
			else if(p1 !=null && p2 != null
					&& p1.val != p2.val)
				return false;
			leftOrder.add(p1.left);
			leftOrder.add(p1.right);
			rightOrder.add(p2.right);
			rightOrder.add(p2.left);
			idx++;		
		}
		if(idx == leftOrder.size() && idx == rightOrder.size())
			return true;
		else
			return false;
	}
	
	public boolean method3(TreeNode root) {
	    return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	}
}
