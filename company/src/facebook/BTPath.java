package facebook;

public class BTPath {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null)
            return res;
        StringBuilder path = new StringBuilder();
        helper(root, path, res);
        return res;
    }
    void helper(TreeNode root, StringBuilder path, List<String> res){
        if(root.left == null && root.right == null){
            res.add(path.toString() + String.valueOf(root.val));
            return;
        }
        int curlength = path.length();
        path.append(String.valueOf(root.val) + "->");
        if(root.left != null){
            helper(root.left, path, res);
        }
        if(root.right != null){
            helper(root.right, path, res);
        }
        path.setLength(curlength);
        return;
    }

}
