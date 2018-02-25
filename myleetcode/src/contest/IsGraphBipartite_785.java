package contest;

public class IsGraphBipartite_785 {
	bool isBipartite(vector<vector<int>>& graph) {
        if(graph.empty())
            return true;
        vector<int> belonging(graph.size(), -1);
        vector<int> checked(graph.size(), 0);
        deque<int> q;
        int i=0;
        while(i<graph.size()){
            int from = -1;
            if(!q.empty()){
                from = q.front();
                q.pop_front();
            }else{
                from = i;
                i++;
            }
            if(checked[from] == 1)
                continue;
            int tmp1, tmp2;
            if(belonging[from] == -1){
                belonging[from] = 1;
                tmp1 = 1;
                tmp2 = 2;
            }else{
                tmp1 = belonging[from];
                tmp2 = tmp1==1? 2:1;
            }
            for(int j=0; j<graph[from].size(); j++){
                if(belonging[graph[from][j]] == tmp1)
                    return false;
                else if(belonging[graph[from][j]] == -1){
                    belonging[graph[from][j]] = tmp2;
                    q.push_back(graph[from][j]);
                }
            } 
            checked[from] = 1;
        }
        return true;
    }

}
