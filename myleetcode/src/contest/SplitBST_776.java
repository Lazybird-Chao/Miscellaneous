package contest;

public class SplitBST_776 {
	/*
	 * This method is not correct
	 * 
	vector<TreeNode*> splitBST(TreeNode* root, int V) {
        if(root == nullptr)
            return vector<TreeNode*>({nullptr, nullptr});
        TreeNode* before=nullptr;
        TreeNode* fbefore = nullptr;
        TreeNode* after =nullptr;
        TreeNode *p = root;
        while(p != nullptr){
            if(p->val <= V){
                before = p;
                p = p->right;
            }else{
                after = p;
                p = p->left;
            }
        }
        if(before == nullptr)
            return vector<TreeNode*>({nullptr, root});
        else if(after == nullptr)
            return vector<TreeNode*>({root, nullptr});
        p = root;
        fbefore = nullptr;
        while(p != nullptr){
            if(p->val == before->val)
                break;
            else if(p->val < before->val){
                fbefore = p;
                p = p->right;
            }else{
                fbefore = p;
                p = p->left;
            }
        }
        if(fbefore == nullptr){
            TreeNode* tmp = before->right;
            before->right = nullptr;
            return vector<TreeNode*>({before, tmp});
        }
        if(before->right == nullptr){
            if(fbefore->left == before)
                fbefore->left = nullptr;
            else
                fbefore->right = nullptr;
        }else{
            if(fbefore->left == before)
                fbefore->left = before->right;
            else
                fbefore->right = before->right;
        }
        before->right = nullptr;
        return vector<TreeNode*>({before, root});
        
    }
    */
	
	vector<TreeNode*> splitBST(TreeNode* root, int V){
        TreeNode *r1 = new TreeNode(0);
        TreeNode *r2 = new TreeNode(0);
        TreeNode *p1 = r1;
        TreeNode *p2 = r2;
        TreeNode *p = root;
        while(p != nullptr){
            if(p->val <= V){
                p1->right = p;
                TreeNode *tmp = p->right;
                p->right = nullptr;
                p1 = p;
                p = tmp;
            }else{
                p2->left = p;
                TreeNode *tmp = p->left;
                p->left = nullptr;
                p2 = p;
                p = tmp;
            }
        }
        return vector<TreeNode*>({r1->right, r2->left});
    }

}
