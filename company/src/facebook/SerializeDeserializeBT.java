package facebook;

import common.TreeNode;

public class SerializeDeserializeBT {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        helper1(root, sb);
        //System.out.println(sb);
        return sb.toString();
    }
    void helper1(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(String.valueOf(root.val));
        sb.append(',');
        helper1(root.left, sb);
        helper1(root.right, sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())
            return null;
        String[] nodes = data.split(",");
        int[] pos = {0};
        TreeNode root = helper2(nodes, pos);
        return root;
    }
    TreeNode helper2(String[] nodes, int[] pos){
        if(pos[0] >= nodes.length)
            return null;
        if(nodes[pos[0]].equals("#")){
            ++pos[0];
            return null;
        }
        TreeNode r = new TreeNode(Integer.parseInt(nodes[pos[0]]));
        ++pos[0];
        r.left = helper2(nodes, pos);
        r.right = helper2(nodes, pos);
        return r;
    }

}
