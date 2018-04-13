package contest;

public class AllPathFromSourceToTarget_797 {
	vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        if(graph.empty())
            return vector<vector<int>>();
        vector<vector<int>> res;
        vector<vector<vector<int>>> paths(graph.size());
        vector<int> accessed(graph.size(), 0);
        dfs(graph, 0, paths, accessed);
        for(int i=0; i<paths[0].size(); i++){
            res.push_back(paths[0][i]);
            reverse(res.back().begin(), res.back().end());
        }
        return res;
        
    }
    void dfs(vector<vector<int>>& graph, int cur_node, vector<vector<vector<int>>> &paths, vector<int>& accessed){
        if(accessed[cur_node] == 1)
            return;
        if(cur_node == graph.size()-1){
            accessed[cur_node] = 1;
            paths[cur_node].push_back(vector<int>(1, cur_node));
            return;
        }
        for(int i=0; i<graph[cur_node].size(); i++){
            int nei = graph[cur_node][i];
            if(accessed[nei]==0)
                dfs(graph, nei, paths, accessed);
            for(int j = 0; j<paths[nei].size(); j++){
                paths[cur_node].push_back(paths[nei][j]);
                paths[cur_node].back().push_back(cur_node);
            }
        }
        accessed[cur_node] = 1;
        return;
    }

}
