package contest;

public class ClosestLeafInBT_742 {
	 int findClosestLeaf(TreeNode* root, int k) {
	        if(root == nullptr)
	            return -1;
	        unordered_map<int, Pair> nodes;
	        findChildClose(root, nodes);
	        findClose(root, nodes, k, nullptr);
	        Pair &p = nodes[k];
	        int min_id=p.id_father;
	        int min_dis=p.distance_father;
	        if(min_dis>p.distance_left){
	            min_dis = p.distance_left;
	            min_id = p.id_left;
	        }
	        if(min_dis > p.distance_right){
	            min_dis = p.distance_right;
	            min_id = p.id_right;
	        }
	        return min_id;
	        
	    }
	    class Pair{
	        public:
	        int id_left;
	        int id_right;
	        int id_father;
	        int distance_left;
	        int distance_right;
	        int distance_father;
	        Pair(){
	            id_left = -1;
	            id_right = -1;
	            id_father = -1;
	            distance_left = INT_MAX;
	            distance_right = INT_MAX;
	            distance_father = INT_MAX;
	        }
	    };
	    Pair findChildClose(TreeNode* root, unordered_map<int, Pair> &nodes){
	        Pair res;
	        if(root->left != nullptr){
	            Pair pleft = findChildClose(root->left, nodes);
	            if(pleft.distance_left > pleft.distance_right){
	                res.id_left = pleft.id_right;
	                res.distance_left = pleft.distance_right+1;
	            }else{
	                res.id_left = pleft.id_left;
	                res.distance_left = pleft.distance_left+1;
	            }
	        }
	        if(root->right != nullptr){
	            Pair pright = findChildClose(root->right, nodes);
	            if(pright.distance_left > pright.distance_right){
	                res.id_right = pright.id_right;
	                res.distance_right = pright.distance_right+1;
	            }else{
	                res.id_right = pright.id_left;
	                res.distance_right = pright.distance_left+1;
	            }
	        }
	        if(res.id_left == -1 && res.id_right ==-1){
	            res.id_left = res.id_right = root->val;
	            res.distance_left = res.distance_right = 0;
	        }
	        nodes[root->val] = res;
	        return res;
	    }
	    
	    void findClose(TreeNode* root, unordered_map<int, Pair> &nodes, int k, TreeNode* farther){
	        if(root == nullptr)
	            return;
	        Pair &cur = nodes[root->val];
	        if(farther != nullptr){
	            Pair &pf = nodes[farther->val];
	            if(root == farther->left){
	                if(pf.distance_right > pf.distance_father){
	                    cur.id_father = pf.id_father;
	                    cur.distance_father = pf.distance_father+1;
	                }else if(pf.id_right != -1){
	                    cur.id_father = pf.id_right;
	                    cur.distance_father = pf.distance_right+1;
	                }
	            }else{
	                if(pf.distance_left > pf.distance_father){
	                    cur.id_father = pf.id_father;
	                    cur.distance_father = pf.distance_father+1;
	                }else if(pf.id_left != -1){
	                    cur.id_father = pf.id_left;
	                    cur.distance_father = pf.distance_left+1;
	                }
	            }
	        }
	        if(root->val == k)
	            return;
	        findClose(root->left, nodes, k, root);
	        findClose(root->right, nodes, k, root);
	        return;
	    }
	    

}
