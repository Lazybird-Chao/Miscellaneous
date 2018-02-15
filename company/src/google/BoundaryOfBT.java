package google;

public class BoundaryOfBT {
	 vector<int> boundaryOfBinaryTree(TreeNode* root) {
	        if(root == nullptr)
	            return vector<int>();
	        vector<int> leftbound;
	        vector<int> rightbound;
	        vector<int> leaf;
	        if(root->left !=nullptr){
	            TreeNode *p = root;
	            while(p!=nullptr){
	                leftbound.push_back(p->val);
	                if(p->left != nullptr)
	                    p= p->left;
	                else
	                    p=p->right;
	            }
	        }
	        if(root->right != nullptr){
	            TreeNode *p = root;
	            while(p!=nullptr){
	                rightbound.push_back(p->val);
	                if(p->right != nullptr)
	                    p = p->right;
	                else
	                    p = p->left;
	            }
	        }
	        if(rightbound.empty() == false)
	            reverse(rightbound.begin(), rightbound.end());
	        getLeaf(leaf, root);
	        vector<int> res;
	        res.push_back(root->val);
	        for(int i=1; i<leftbound.size(); i++)
	            res.push_back(leftbound[i]);
	        if(leftbound.size()==0 && rightbound.size() != 0)
	            res.push_back(leaf[0]);
	        for(int i=1; i<leaf.size(); i++)
	            res.push_back(leaf[i]);
	        for(int i=1; i<(int)rightbound.size()-1; i++)
	            res.push_back(rightbound[i]);
	        return res;
	        
	    }
	    void getLeaf(vector<int>& leaf, TreeNode* root){
	        if(root->left == nullptr && root->right == nullptr)
	            leaf.push_back(root->val);
	        if(root->left != nullptr)
	            getLeaf(leaf, root->left);
	        if(root->right != nullptr)
	            getLeaf(leaf, root->right);
	        return;
	    }

}
