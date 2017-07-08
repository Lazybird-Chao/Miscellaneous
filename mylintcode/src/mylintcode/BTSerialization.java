package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTSerialization {
	public class TreeNode {
		      public int val;
		      public TreeNode left, right;
		      public TreeNode(int val) {
		          this.val = val;
		          this.left = this.right = null;
		      }
		  }
	
	public String serialize(TreeNode root) {
		if(root == null)
			return new String("");
		
		StringBuilder ret = new StringBuilder();
		Queue<TreeNode> accList = new LinkedList<TreeNode>();
		accList.offer(root);
		ret.append(Integer.toString(root.val));
		ret.append(",");
		while(accList.isEmpty()==false){
			TreeNode cur = accList.poll();
			if(cur.left!=null){
				accList.offer(cur.left);
				ret.append(Integer.toString(cur.left.val));
				ret.append(",");
			}
			else
				ret.append("#,");
			if(cur.right!=null){
				accList.offer(cur.right);
				ret.append(Integer.toString(cur.right.val));
				ret.append(",");
			}
			else
				ret.append("#,");
		}
		return ret.substring(0, ret.length()-1);
	}
	
	public TreeNode deserialize(String data) {
		if(data == null || data.isEmpty())
			return null;
		
		String[] treeNodeValue = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(treeNodeValue[0]));
		Queue<TreeNode> nodelist = new LinkedList<TreeNode>();
		nodelist.offer(root);
		
		int i=1;
		while(nodelist.isEmpty()==false){
			TreeNode cur = nodelist.poll();
			if(treeNodeValue[i].equals("#"))
				cur.left = null;
			else{
				cur.left = new TreeNode(Integer.parseInt(treeNodeValue[i]));
				nodelist.offer(cur.left);
			}
			i++;
			if(treeNodeValue[i].equals("#"))
				cur.right = null;
			else{
				cur.right = new TreeNode(Integer.parseInt(treeNodeValue[i]));
				nodelist.offer(cur.right);
			}
			i++;
		}
		return  root;
			
	}

}
