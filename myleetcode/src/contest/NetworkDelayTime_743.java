package contest;

public class NetworkDelayTime_743 {
	class Node{
        public:
        int cost;
        vector<int> neighbors;
        vector<int> edgecost;
        Node(){
            cost = INT_MAX;
        }
    };
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        if(times.empty())
            return -1;
        Node g[101];
        for(int i =0; i<times.size(); i++){
            int src = times[i][0];
            g[src].neighbors.push_back(times[i][1]);
            g[src].edgecost.push_back(times[i][2]);
        }
        bool access[101];
        for(int i=1; i<=N; i++)
            access[i] = false;
        int maxtime = 0;
        g[K].cost = 0;
        while(true){
            int minid = -1;
           for(int i = 1; i<=N; i++){
               if(access[i])
                   continue;
               if(minid ==-1)
                   minid = i;
               else if(g[i].cost < g[minid].cost)
                   minid = i;
           }
            if(minid == -1 || g[minid].cost == INT_MAX)
                break;
            int curcost = g[minid].cost;
            maxtime = max(maxtime, curcost);
            access[minid] = true;
            
            vector<int> &neighbors = g[minid].neighbors;
            for(int i = 0; i<neighbors.size(); i++){
                int nid = neighbors[i];
                if(curcost + g[minid].edgecost[i] < g[nid].cost)
                    g[nid].cost = curcost + g[minid].edgecost[i];
            }
        }
        for(int i =1; i<=N; i++){
            if(access[i]==false)
                return -1;
        }
        return maxtime;
    }

}
