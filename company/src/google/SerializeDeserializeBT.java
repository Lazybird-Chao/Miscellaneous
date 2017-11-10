package google;

public class SerializeDeserializeBT {
	 public String serialize(TreeNode root) {
	    	if(root == null){
	            return "#,";
	        }else{
	            String r = String.valueOf(root.val) + ",";
	            r = r + serialize(root.left) + serialize(root.right);
	            return r;
	        }
	    }
	    
	    public TreeNode deserialize(String data) {
	        String[] nodes = data.split(",");
	        int[] pos = {0};
	        return helper(nodes, pos);
	    	
	    }
	    TreeNode helper(String[] nodes, int[] pos){
	        if(pos[0] == nodes.length)
	            return null;
	        if(nodes[pos[0]].equals("#")){
	            pos[0]++;
	            return null;
	        }
	        TreeNode r = new TreeNode(Integer.parseInt(nodes[pos[0]]));
	        pos[0]++;
	        r.left = helper(nodes, pos);
	        r.right = helper(nodes, pos);
	        return r;
	    }

}
