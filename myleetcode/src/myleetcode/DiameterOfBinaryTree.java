package myleetcode;

public class DiameterOfBinaryTree {
	 public int diameterOfBinaryTree(TreeNode root){
		 return search(root).maxPathLength;
	 }
	 
	 public class retValue{
		 int depth =0;
		 int maxPathLength =0;
	 }
	 public retValue search(TreeNode root){
		 if(root ==null)
			 return new retValue();
		 retValue ret = new retValue();
		 retValue retleft = search(root.left);
		 retValue retright = search(root.right);
		 ret.depth = Math.max(retleft.depth+1, retright.depth+1);
		 ret.maxPathLength = Math.max(retleft.maxPathLength, retright.maxPathLength);
		 ret.maxPathLength = Math.max(ret.maxPathLength, (retleft.depth-1)+(retright.depth-1)+2);
		 return ret;
	 }
}
