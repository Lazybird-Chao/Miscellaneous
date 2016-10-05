package myleetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myleetcode.InvertBtree.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		traversal(root, 0, ret);
		Collections.reverse(ret);
		return ret;
	}
	
	void traversal(TreeNode root, int depth, List<List<Integer>> ret){
		if(root == null)
			return;
		else{
			traversal(root.left, depth+1, ret);
			traversal(root.right, depth+1, ret);
			if(depth >= ret.size())
				ret.add(new ArrayList<Integer>());
			List<Integer> levelDepth = ret.get(depth);
			levelDepth.add(root.val);
		}
	}
	
	public List<List<Integer>> method2(TreeNode root){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<TreeNode> current= new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();
		if(root !=null){
			current.add(root);
		}
		List<TreeNode> p = current;
		while(p.size() !=0){
			List<Integer> tmp = new ArrayList<Integer>();
			for(int i = 0; i<p.size(); i++){
				tmp.add(p.get(i).val);
				if(p.get(i).left != null)
					next.add(p.get(i).left);
				if(p.get(i).right!=null)
					next.add(p.get(i).right);
			}
			ret.add(tmp);
			current = next;
			next = p;
			next.clear();
			p = current;
		}
		Collections.reverse(ret);
		return ret;
	}
}
