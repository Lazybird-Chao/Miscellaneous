package mylintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root==null)
			return new ArrayList<List<Integer>>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		s1.push(root);
		int level = 0;
		while(!s1.isEmpty()) {
			++level;
			List<Integer> tmp = new ArrayList<Integer>();
			while(!s1.isEmpty()) {
				TreeNode cur = s1.pop();
				tmp.add(cur.val);
				if(level%2==1) {
					if(cur.left!=null)
						s2.push(cur.left);
					if(cur.right!=null)
						s2.push(cur.right);
				}
				else
				{
					if(cur.right!=null)
						s2.push(cur.right);
					if(cur.left!=null)
						s2.push(cur.left);
				}
			}
			Stack<TreeNode> tmps = s1;
			s1 = s2;
			s2 = tmps;
			res.add(tmp);
		}
		return res;
	}

}
