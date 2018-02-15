package google;

public class ClosestBSTValue2 {
	vector<int> closestKValues(TreeNode* root, double target, int k) {
        if(root == nullptr)
            return vector<int>();
        double left = numeric_limits<double>::max();
        double right = DBL_MAX;
        vector<int> res;
        helper(root, target, left, 0);
        if(left != DBL_MAX)
            res.push_back((int)left);
        left = DBL_MAX;
        helper(root, target, left, -1);
        helper(root, target, right, 1);
        while(res.size() < k){
            if(left == DBL_MAX || (right != DBL_MAX && target-left >= right-target) ){
                res.push_back((int)right);
                double tmp = right;
                right = DBL_MAX;
                helper(root, tmp, right, 1);
            }else{
                res.push_back((int)left);
                double tmp = left;
                left = DBL_MAX;
                helper(root, tmp, left, -1);
            }
        }
        
        return res;
        
    }
    void helper(TreeNode *root, double target, double &near, int direct){
        if(root == nullptr)
            return;
        if(direct > 0){
            if(root->val > target){
                near = root->val;
                helper(root->left, target, near, direct);
            }else{
                helper(root->right, target, near, direct);
            }
        }else if(direct < 0){
            if(root->val < target){
                near = root->val;
                helper(root->right, target, near, direct);
            }else{
                helper(root->left, target, near, direct);
            }
        } else if(direct == 0){
            if(root->val <target)
                helper(root->right, target, near, direct);
            else if(root->val > target)
                helper(root->left, target, near, direct);
            else{
                near = root->val;
                return;
            }
        }
    }

}
