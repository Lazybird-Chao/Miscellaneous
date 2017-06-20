package myleetcode;

public class ConstructStringFromBinaryTree {
	public String tree2str(TreeNode t){
		StringBuilder ret = new StringBuilder("");
		helper(t, ret);
		return ret.toString();
	}
	
	public void helper(TreeNode t, StringBuilder prestr){
		if(t==null)
			return;
		prestr.append(Integer.toString(t.val));
		if(t.left==null && t.right==null)
			return;
		prestr.append("(");
		helper(t.left, prestr);
		prestr.append(")");
		if(t.right != null){
			prestr.append("(");
			helper(t.right, prestr);
			prestr.append(")");
		}
	}
	
	/*public static void main(String[] args){
		String test = "01 02  02";
		String[] ret = test.split("[ ]+");
		System.out.println(ret.length);
		for(String x: ret)
			System.out.println(x);
	}*/

}
