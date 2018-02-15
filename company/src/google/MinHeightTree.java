package google;

public class MinHeightTree {
	vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
        vector<int> res;
        if(n==1){
            res.push_back(0);
            return res;
        }else if(n==2){
            res.push_back(0);
            res.push_back(1);
            return res;
        }
        unordered_set<int> g[n];
        int indegree[n];
        for(int i=0;i<n; i++){
            indegree[i] = 0;
        }
        for(int i=0; i<edges.size(); i++){
            g[edges[i].first].insert(edges[i].second);
            g[edges[i].second].insert(edges[i].first);
            indegree[edges[i].first]++;
            indegree[edges[i].second]++;
        }
        deque<int> q;
        for(int i=0; i<n; i++){
            if(indegree[i] == 1)
                q.push_back(i);
        }
        int count = 0;
        while(true){
            int qs = q.size();
            for(int i=0; i<qs; i++){
                int v = q.front();
                count++;
                //cout<<v<<endl;
                q.pop_front();
                for(auto w : g[v]){
                    indegree[w]--;
                    if(indegree[w]==1)
                        q.push_back(w);
                    g[w].erase(v);
                }
            }
            if(count+q.size() == n)
                    break;
        }
        for(auto it: q)
            res.push_back(it);
        return res;
        
    }

}
