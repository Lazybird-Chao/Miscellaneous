package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversl2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root==null)
			return new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		while(!q.isEmpty()) {
			int lcount = q.size();
			List<Integer> larray = new ArrayList<Integer>();
			for(int i=0; i<lcount; i++) {
				TreeNode cur = q.poll();
				larray.add(cur.val);
				if(cur.left!=null)
					q.offer(cur.left);
				if(cur.right!=null)
					q.offer(cur.right);
			}
			res.add(larray);
		}
		for(int i=0,j=res.size()-1; i<j; i++,j--) {
			List<Integer> tmp = res.get(i);
			res.set(i,res.get(j));
			res.set(j, tmp);
		}
		return res;
	}

}
