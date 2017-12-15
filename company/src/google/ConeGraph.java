package google;

public class ConeGraph {
	UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(node == nullptr)
            return nullptr;
        unordered_map<UndirectedGraphNode* , UndirectedGraphNode*> m;
        queue<UndirectedGraphNode*>  q;
        q.push(node);
        while(!q.empty()){
            UndirectedGraphNode* cur = q.front();
            q.pop();
            UndirectedGraphNode* cur_n = new UndirectedGraphNode(cur->label);
            m[cur] = cur_n;
            for(int i=0; i<cur->neighbors.size(); i++){
                UndirectedGraphNode* nei = cur->neighbors[i];
                if(m.find(nei) == m.end())
                    q.push(nei);
            }
        }
        for(auto &it : m){
            UndirectedGraphNode* oldnode = it.first;
            UndirectedGraphNode* newnode = it.second;
            for(int i=0; i<oldnode->neighbors.size(); i++){
                newnode->neighbors.push_back(m[oldnode->neighbors[i]]);
            }
        }
        return m[node];
    
    }

}
