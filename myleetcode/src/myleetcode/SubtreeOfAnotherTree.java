package myleetcode;

import java.util.Stack;

public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t){
		if(s==null)
			return false;
		else if(t==null)
			return true;
		
		if(s.val == t.val){
			if(similarTree(s, t))
				return true;
		}
		return isSubtree(s.left, t) || isSubtree(s.right, t);
		
	}

	
	boolean similarTree(TreeNode r1, TreeNode r2){
		if(r1==null && r2==null)
			return true;
		else if(r1==null || r2==null)
			return false;
		if(r1.val != r2.val)
			return false;
		return similarTree(r1.left, r2.left) && similarTree(r1.right, r2.right);
	}
	
	
	public boolean method2(TreeNode s, TreeNode t){
		if(s==null)
			return false;
		else if(t==null)
			return true;
		
		String s1 = traversalPreorder(s);
		String s2 = traversalPreorder(t);
		return s1.contains(s2);
	}
	
	String traversalPreorder(TreeNode r){
		if(r==null)
			return new String("");
		StringBuilder ret = new StringBuilder("");
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(r);
		while(!s.empty()){
			TreeNode cur = s.pop();
			if(cur != null){
				ret.append(Integer.toString(cur.val));
				ret.append(',');
				s.push(cur.right);
				s.push(cur.left);
			}
			else{
				ret.append("$,");
			}
		}
		return ret.substring(0, ret.length()-1);
	}
	
	
	String traversalInorder(TreeNode r){
		if(r == null)
			return new String("");
		StringBuilder ret = new StringBuilder("");
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		/*
		TreeNode root = r;
		s.push(root);
		while(!s.isEmpty()){
			if(root.left!=null){
				s.push(root.left);
				root = root.left;
			}
			else{
				ret.append("$,");
				ret.append(Integer.toString(root.val));
				ret.append(',');
				s.pop();
				if(root.right!=null){
					s.push(root.right);
					root = root.right;
				}
				else{
					ret.append("$,");
					if(s.isEmpty())
						break;
					root = s.pop();
					ret.append(Integer.toString(root.val));
					ret.append(',');
				}
			}
		}
		
		return ret.substring(0, ret.length()-1);
		*/
		
		TreeNode root = r;
		while(root!=null || !s.isEmpty()){
			if(root != null){
				s.push(root);
				root = root.left;
			}
			else{
				ret.append("$,");
				root = s.pop();
				ret.append(Integer.toString(root.val));
				ret.append(',');
				root = root.right;
			}
		}
		ret.append("$");
		
		return ret.toString();
	}
	
	String traversalPostorder(TreeNode r){
		if(r == null)
			return new String("");
		StringBuilder ret = new StringBuilder("");
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		/*
		s1.push(r);
		while(!s1.isEmpty()){
			TreeNode cur = s1.pop();
			s2.push(cur);
			if(cur.left!=null)
				s1.push(cur.left);
			if(cur.right!= null)
				s1.push(cur.right);
		}
		
		while(!s2.isEmpty()){
			TreeNode cur = s2.pop();
			ret.append(Integer.toString(cur.val));
			ret.append(',');
		}
		return ret.substring(0,ret.length()-1);
		*/
		
		s1.push(r);
		while(!s1.isEmpty()){
			TreeNode cur = s1.pop();
			s2.push(cur);
			if(cur!=null){
				s1.push(cur.left);
				s1.push(cur.right);
			}
		}
		
		while(!s2.isEmpty()){
			TreeNode cur = s2.pop();
			if(cur==null)
				ret.append("$,");
			else{
				ret.append(Integer.toString(cur.val));
				ret.append(',');
			}
		}
		return ret.substring(0,ret.length()-1);
		
		
	}

}
