package google;

public class BTLongestConsecutiveSequence {
	int longestConsecutive(TreeNode* root) {
        if(root==nullptr)
            return 0;
        int maxlen = 1;
        helper(root->left, root->val, 1, maxlen);
        helper(root->right, root->val, 1, maxlen);
        return maxlen;
    }
    void helper(TreeNode* root, int preval, int curlen, int &maxlen){
        if(root==nullptr)
            return;
        if(root->val == preval+1){
            curlen++;
            maxlen = max(maxlen, curlen);
        }else{
            curlen = 1;
        }
        helper(root->left, root->val, curlen, maxlen);
        helper(root->right, root->val, curlen, maxlen);
        return;
    }

}
