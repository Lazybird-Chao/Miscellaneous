package google;

public class BTVerticalOrderTraversal {
	vector<vector<int>> verticalOrder(TreeNode* root) {
        if(root == nullptr)
            return vector<vector<int>>();
        deque<pair<TreeNode*, int>> q;
        unordered_map<int, vector<int>> m;
        int mincol = 0;
        int maxcol = 0;
        q.push_back(make_pair(root, 0));
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                pair<TreeNode*, int> cur = q.front();
                q.pop_front();
                mincol = min(mincol, cur.second);
                maxcol = max(maxcol, cur.second);
                if(m.find(cur.second)==m.end())
                    m[cur.second] = vector<int>();
                m[cur.second].push_back(cur.first->val);
                if(cur.first->left != nullptr)
                    q.push_back(make_pair(cur.first->left, cur.second-1));
                if(cur.first->right != nullptr)
                    q.push_back(make_pair(cur.first->right, cur.second+1));
            }
        }
        vector<vector<int>> res;
        for(int i=mincol; i<=maxcol; i++){
            if(m.find(i) != m.end())
                res.push_back(m[i]);
        }
        return res;
    }

}
