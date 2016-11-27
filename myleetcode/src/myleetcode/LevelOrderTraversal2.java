package myleetcode;
import java.util.ArrayList;
import java.util.List;

import myleetcode.InvertBtree.TreeNode;

public class LevelOrderTraversal2 {
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(root==null)
			return ret;
		List<TreeNode> pcurrent = new ArrayList<TreeNode>();
		List<TreeNode> pnext = new ArrayList<TreeNode>();
		pcurrent.add(root);
		while(pcurrent.size()>0){
			List<Integer> row = new ArrayList<Integer>();
			for(TreeNode p:pcurrent){
				row.add(p.val);
				if(p.left !=null)
					pnext.add(p.left);
				if(p.right != null)
					pnext.add(p.right);
			}
			ret.add(row);
			List<TreeNode> tmp = pcurrent;
			pcurrent = pnext;
			pnext= tmp;
			pnext.clear();
		}
		
		return ret;
	}
}
