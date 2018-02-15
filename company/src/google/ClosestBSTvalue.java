package google;

public class ClosestBSTvalue {
	int closestValue(TreeNode* root, double target) {
        if(root == nullptr)
            return 0;
        TreeNode *before = nullptr;
        TreeNode *after = nullptr;
        TreeNode *p = root;
        while(p != nullptr){
            if(p->val < target){
                before = p;
                p = p->right;
            }else if(p->val > target){
                after = p;
                p = p->left;
            }else
                return p->val;
        }
        if(before == nullptr)
            return after->val;
        else if(after == nullptr)
            return before->val;
        else if(target - before->val < after->val - target)
            return before->val;
        else
            return after->val;
    }

}
