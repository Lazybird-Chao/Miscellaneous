package google;

public class BTPath {
	vector<string> binaryTreePaths(TreeNode* root) {
        if(root == nullptr)
            return vector<string>();
        vector<string> res;
        string path = "";
        helper(root, path, res);
        return res;
    }
    void helper(TreeNode* root, string path, vector<string>& res){
        string p = path+to_string(root->val);
        if(root->left==nullptr && root->right==nullptr)
            res.push_back(p);
        if(root->left != nullptr)
            helper(root->left, p+"->", res);
        if(root->right != nullptr)
            helper(root->right, p+"->", res);
        return;
    }

}
