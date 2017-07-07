package mylintcode;

import java.util.Stack;

public class FlattenBTtoLinkedList {
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			TreeNode cur = s.pop();
			if(cur.right!=null)
				s.push(cur.right);
			if(cur.left != null)
				s.push(cur.left);
			if(s.isEmpty())
				cur.right = null;
			else
				cur.right = s.peek();
		}
		return;
	}
	
	public void method2(TreeNode root){
		if(root == null)
			return;
		helper(root, null);
		return;
		
	}
	
	public TreeNode helper(TreeNode root, TreeNode last){
		if(root == null)
			return null;
		TreeNode right = root.right;
		TreeNode left = root.left;
		if(last != null)
			last.right = root;
		root.left = null;
		TreeNode lastleft = helper(left, root);
		TreeNode lastright;
		if(lastleft==null)
			lastright = helper(right, root);
		else
			lastright = helper(right, lastleft);	
		if(lastright!=null)
			return lastright;
		else if(lastleft != null)
			return lastleft;
		else
		    return root;
	}

}
