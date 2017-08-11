package mylintcode;

import java.util.ArrayList;
import java.util.Stack;

public class BTPostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		if(root==null)
			return new ArrayList<Integer>();
		ArrayList<Integer> travers = new ArrayList<Integer>();
		helper(root, travers);
		return travers;
	}
	
	void helper(TreeNode root, ArrayList<Integer> travers) {
		if(root==null)
			return;
		helper(root.left, travers);
		helper(root.right, travers);
		travers.add(root.val);
		return;
	}
	
	void method2(TreeNode root, ArrayList<Integer> travers) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while(s1.isEmpty()==false) {
			TreeNode cur = s1.pop();
			if(cur.left!=null)
				s1.push(cur.left);
			if(cur.right!=null)
				s1.push(cur.right);
			s2.push(cur);
		}
		while(s2.isEmpty()==false)
			travers.add(s2.pop().val);
		
	}

}
