package myleetcode;

import java.util.List;
import java.util.ArrayList;

import myleetcode.InvertBtree.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root){
		List<String> ret=new ArrayList<String>();
		if(root ==null){
			ret.add(new String());
			return ret;
		}
		Dfs(root, ret, new StringBuilder());
		return ret;
	}
	
	void Dfs(TreeNode root, List<String> record, StringBuilder current){
		if(root.left ==null && root.right == null){
			current.append(Integer.toString(root.val));
			record.add(current.toString());
			return;
		}
		if(root.left != null){
			StringBuilder newpath = new StringBuilder(current);
			newpath.append(Integer.toString(root.val));
			newpath.append("->");
			Dfs(root.left, record, newpath);
		}
		if(root.right != null){
			//StringBuilder newpath = new StringBuilder(current);
			current.append(Integer.toString(root.val));
			current.append("->");
			Dfs(root.right, record, current);
		}
	}
}
