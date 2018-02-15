package google;

public class BTLongestConsecutiveSeq2 {
	int maxlen=0;
    int longestConsecutive(TreeNode* root) {
        if(root== nullptr)
            return 0;
        helper(root);
        return maxlen;
    }
    pair<int, int> helper(TreeNode* root){
        if(root == nullptr)
            return make_pair(0, 0);
        pair<int, int> left;
        if(root->left == nullptr)
            left = make_pair(1, 1);
        else if(root->val - root->left->val == 1){
            pair<int, int> tmp = helper(root->left);
            left.first = 1+tmp.first;
            left.second = 1;
        }else if(root->val - root->left->val == -1){
            pair<int, int> tmp = helper(root->left);
            left.first = 1;
            left.second = 1+tmp.second;
        }else{
            pair<int, int> tmp = helper(root->left);
            left = make_pair(1, 1);
        }
        pair<int, int> right;
        if(root->right == nullptr)
            right = make_pair(1, 1);
        else if(root->val - root->right->val == 1){
            pair<int, int> tmp = helper(root->right);
            right.first = 1+tmp.first;
            right.second = 1;
        }else if(root->val -root->right->val == -1){
            pair<int, int> tmp = helper(root->right);
            right.first = 1;
            right.second = 1+tmp.second;
        }else{
            pair<int, int> tmp = helper(root->right);
            right = make_pair(1, 1);
        }
        //cout<<"L "<<left.first<<" "<<left.second<<endl;
        //cout<<"R "<<right.first<<" "<<right.second<<endl;
        maxlen = max(maxlen, left.first+right.second-1);
        maxlen = max(maxlen, left.second+right.first-1);
        return make_pair(max(left.first, right.first), max(left.second, right.second));
    }

}
