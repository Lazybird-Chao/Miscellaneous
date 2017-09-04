package amazon;
import java.util.Stack;

import common.TreeNode;

public class SerializeDeserializeBT {
	public String serialize(TreeNode root) {
        if(root == null)
        	return "";
        StringBuilder res = new StringBuilder();
        res.append(Integer.toString(root.val));
        res.append("(");
        res.append(serialize(root.left));
        res.append(",");
        res.append(serialize(root.right));
        res.append(")");
        return res.toString();	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.isEmpty())
    		return null;
    	Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    	Stack<Character> cStack = new Stack<Character>();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<data.length(); i++) {
    		char c = data.charAt(i);
    		if(c != ')') {
    			cStack.push(c);
    		} else {
    			while(cStack.peek() != ',')
    				sb.append(cStack.pop());
    			TreeNode rnode = null;
    			if(sb.length() != 0) {
    				rnode = new TreeNode(Integer.parseInt(sb.reverse().toString()));
    				rnode.left = nodeStack.pop();
    				rnode.right = nodeStack.pop();
    			} 
    			TreeNode lnode = null;
    			cStack.pop();
    			sb.setLength(0);
    			while(cStack.peek() != '(')
    				sb.append(cStack.pop());
    			if(sb.length() != 0){
    				lnode = new TreeNode(Integer.parseInt(sb.reverse().toString()));
    				lnode.left = nodeStack.pop();
    				lnode.right = nodeStack.pop();
    			} 
    			nodeStack.push(rnode);
    			nodeStack.push(lnode);
    			sb.setLength(0);
    			cStack.pop();
	    	}       
	    }
	    while(!cStack.isEmpty())
	    	sb.append(cStack.pop());
	    TreeNode root = null;
	    if(sb.length() != 0)
	    	root = new TreeNode(Integer.parseInt(sb.reverse().toString()));
	    root.left = nodeStack.pop();
	    root.right = nodeStack.pop();
	    return root;
    }
    
    
    public String serialize2(TreeNode root) {
    	if(root == null)
    		return "n,";
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(root.val);
    	sb.append(",");
    	sb.append(serialize2(root.left));
    	sb.append(serialize2(root.right));
    	return sb.toString();
    	
    }
    
    public TreeNode deserialize2(String data) {
    	if(data.isEmpty())
    		return null;
    	String[] nodelist = data.split(",");
    	int[] pos = new int[1];
    	pos[0] = 0;
    	return helper(nodelist, pos);
    	
    }
    
    TreeNode helper(String[] nodelist, int[] pos) {
    	String cur = nodelist[pos];
    	if(cur.equals("n")) {
    		pos[0]++;
    		return null;
    	} else {
    		TreeNode root = new TreeNode(Integer.parseInt(cur));
    		pos[0]++;
    		root.left = helper(nodelist, pos);
    		root.right = helper(nodelist, pos);
    		return root;
    	}
    }
    
}
