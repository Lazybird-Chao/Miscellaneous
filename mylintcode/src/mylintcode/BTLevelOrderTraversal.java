package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		if(root==null)
			return new ArrayList<ArrayList<Integer>>();
		
		Queue<TreeNode> accList = new LinkedList<TreeNode>();
		Queue<TreeNode> accListNext = new LinkedList<TreeNode>();
		accList.offer(root);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		while(accList.isEmpty()==false){
			ArrayList<Integer> level = new ArrayList<Integer>();
			while(accList.isEmpty()==false){
				TreeNode cur = accList.poll();
				level.add(cur.val);
				if(cur.left!=null)
					accListNext.offer(cur.left);
				if(cur.right != null)
					accListNext.offer(cur.right);
			}
			ret.add(level);
			Queue<TreeNode> tmp = accList;
			accList = accListNext;
			accListNext = tmp;
			accListNext.clear();
		}
		return ret;
	}

}
