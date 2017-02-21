package myleetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root){
		if(root == null)
			return new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		method1(root, res);
		return res;
	}
	
	public void method1(TreeNode root, List<Integer> traversal){
		if(root.left !=null)
			method1(root.left, traversal);
		traversal.add(root.val);
		if(root.right != null)
			method1(root.right, traversal);
		return;
	}
	
	public void method2(TreeNode root, List<Integer> traversal){
		Stack<TreeNode> processStack = new Stack<TreeNode>();
		processStack.push(root);
		while(!processStack.isEmpty()){
			TreeNode tmp = processStack.pop();
			if(tmp.right == null && tmp.left == null)
				traversal.add(tmp.val);
			else{
				if(tmp.right!=null)
					processStack.push(tmp.right);
				processStack.push(new TreeNode(tmp.val));
				if(tmp.left!=null)
					processStack.push(tmp.left);
			}
		}
		return;
	}
	
	public void method3(TreeNode root, List<Integer> traversal){
		Stack<TreeNode> processStack = new Stack<TreeNode>();
		TreeNode tmp = root;
		/*while(tmp!=null){
			if(tmp.left !=null){
				processStack.push(tmp);
				tmp = tmp.left;
			}
			else{
				traversal.add(tmp.val);
				if(tmp.right!=null)
					tmp = tmp.right;
				else if(!processStack.isEmpty())
					tmp = processStack.pop();
			}
		}*/
		while(tmp!=null || processStack.isEmpty()==false){
			while(tmp!=null){
				processStack.push(tmp);
				tmp = tmp.left;
			}
			tmp = processStack.pop();
			traversal.add(tmp.val);
			tmp = tmp.right;
		}
		return;
	}
}
