package contest;

public class MinDistanceInBST_783 {
	int minDiffInBST(TreeNode* root) {
        if(root == nullptr)
            return -1;
        int mindiff = INT_MAX;
        helper(root, INT_MAX, mindiff);
        return mindiff;
    }
    int helper(TreeNode* root, int pre, int &mindiff){
        if(root == nullptr)
            return INT_MAX;
        int left;
        left = helper(root->left, pre, mindiff);
        if(left != INT_MAX)
            mindiff = min(mindiff, root->val - left);
        else if(pre != INT_MAX)
            mindiff = min(mindiff, root->val - pre);
        int right;
        right = helper(root->right, root->val, mindiff);
        if(right == INT_MAX)
            return root->val;
        else
            return right;
        
    }

}
