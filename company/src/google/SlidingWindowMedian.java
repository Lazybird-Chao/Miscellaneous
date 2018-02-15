package google;

public class SlidingWindowMedian {
	/*
	class Solution {
		public:
		    vector<double> medianSlidingWindow(vector<int>& nums, int _k) {
		        k = _k;
		        vector<double> res;
		        int n = nums.size();
		        if(n < k) return res;
		        vector<int> firstk(nums.begin(), nums.begin()+k);
		        sort(firstk.begin(), firstk.end());
		        
		        for(int i = 0; i < k/2; ++i) small.insert(firstk[i]);
		        for(int i = k/2; i < k; ++i) large.insert(firstk[i]);
		        for(int i = k; i < n; ++i){
		            res.push_back(getMedian());
		            if(large.size() == 0 || nums[i] < *large.begin())
		                small.insert(nums[i]);
		            else large.insert(nums[i]);
		            if(small.count(nums[i-k])){
		                auto it = small.find(nums[i-k]);
		                small.erase(it);
		            }
		            else{
		                auto it = large.find(nums[i-k]);
		                large.erase(it);
		            }
		            balance();
		        }
		        res.push_back(getMedian());
		        return res;
		            
		    }
		        
		        
		private:
		    multiset<int> small;
		    multiset<int> large;
		    int k;
		    void balance(){
		        while(small.size() < k/2){
		            small.insert(*large.begin());
		            large.erase(large.begin());            
		        }
		        while(large.size() < k - k/2){
		            int num = *small.rbegin();
		            large.insert(num);
		            small.erase(small.find(num));
		            
		        }
		    }
		    double getMedian(){
		        if(k%2 == 0) return ((long long)*small.rbegin() + *large.begin() + 0.0)/2;
		        else return (double)(*large.begin()); 
		    }
		    
		};
		*/
	
	class Node{
	    public:
	        int val;
	        int cntsmaller;
	        Node* left;
	        Node* right;
	        
	        Node(){
	            val = 0;
	            cntsmaller = 0;
	            left = nullptr;
	            right = nullptr;
	        }
	        Node(int v){
	            val = v;
	            cntsmaller = 1;
	            left = right = nullptr;
	        }
	        bool operator<(Node& other){
	            return this->val < other.val;
	        }
	    };
	    
	    void insert(Node *root, Node *newnode){
	        if(newnode->val <= root->val){
	            root->cntsmaller++;
	            if(root->left == nullptr)
	                root->left = newnode;
	            else
	                insert(root->left, newnode);
	        }else{
	            if(root->right == nullptr)
	                root->right = newnode;
	            else
	                insert(root->right, newnode);
	        }
	        return;
	    }
	    
	    Node* find(Node *root, int k){
	        if(root->cntsmaller == k)
	            return root;
	        else if(root->cntsmaller > k){
	            return find(root->left, k);
	        }else{
	            return find(root->right, k-root->cntsmaller);
	        }
	    }
	    
	    Node* del(Node *root,  int v){
	        if(v > root->val){
	            root->right = del(root->right, v);
	        }
	        else if(v < root->val){
	            root->left = del(root->left, v);
	            root->cntsmaller--;
	        }
	        else{
	            if(root->left == nullptr && root->right == nullptr){
	                delete root;
	                root = nullptr;
	            }else if(root->left == nullptr || root->right == nullptr){
	                Node *tmp = root->left == nullptr? root->right : root->left;
	                delete root;
	                root = tmp;
	            }else{
	                root->cntsmaller--;
	                Node *p = root->left;
	                Node *pf = root;
	                while(p->right != nullptr){
	                    pf = p;
	                    p = p->right;
	                }
	                root->val = p->val;
	                if(pf->left == p)
	                    pf->left = p->left;
	                else
	                    pf->right = p->left;
	                delete p; 
	            }
	        }
	        return root;
	    }
	    
	    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
	        if(nums.empty())
	            return vector<double>();
	        if(k==1){
	            vector<double> res;
	            for(int i : nums)
	                res.push_back(i);
	            return res;
	        }
	        Node *root = new Node(nums[0]);
	        for(int i=1; i<k-1; i++){
	            Node *tmp = new Node(nums[i]);
	            insert(root, tmp);
	        }
	        vector<double> res;
	        for(int i=k-1; i<nums.size(); i++){
	            Node *tmp = new Node(nums[i]);
	            insert(root, tmp);
	            if(k % 2 == 0){
	                Node *mid1 = find(root, k/2);
	                Node *mid2 = find(root, k/2+1);
	                res.push_back(((double)(mid1->val) + mid2->val)/2);
	            }else{
	                Node *mid = find(root, k/2+1);
	                res.push_back(mid->val);
	            }
	            root = del(root, nums[i-k+1]);
	        }
	        return res;
	    }

}
