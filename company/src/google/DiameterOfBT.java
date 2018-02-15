package google;

public class DiameterOfBT {
	int diameterOfBinaryTree(TreeNode* root) {
        if(root == nullptr)
            return 0;
        int maxlen = 0;
        pathLength(root, maxlen);
        return maxlen-1;
    }
    int pathLength(TreeNode* root, int &maxlen){
        if(root == nullptr)
            return 0;
        int leftlen = pathLength(root->left, maxlen);
        int rightlen = pathLength(root->right, maxlen);
        int res = max(leftlen, rightlen)+1;
        if(leftlen+rightlen+1 > maxlen)
            maxlen = leftlen+rightlen+1;
        return res;
    }

}
