package google;

public class RedundentConnection2 {
	vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges){
        if(edges.empty())
            return vector<int>();
        unordered_map<int, int> f;
        int i=0;
        for(i=0; i<edges.size(); i++){
            if(f.find(edges[i][1])==f.end())
                f[edges[i][1]] = edges[i][0];
            else
                break;
        }
        int pos_res = i;
        vector<int> pos_res2;
        if(i<edges.size())
            pos_res2 = vector<int>({f[edges[i][1]], edges[i][1]});
        //cout<<pos_res<<endl;
        //if(i<edges.size())
        //    cout<<f[edges[i][1]]<<" "<<edges[i][1]<<endl;
        
        f.clear();
        for(i=0; i<edges.size(); i++){
            if(f.find(edges[i][0]) == f.end())
                f[edges[i][0]] = edges[i][0];
            if(f.find(edges[i][1])==f.end())
                f[edges[i][1]] = edges[i][1];
        }
        for(i=0; i<edges.size(); i++){
            if(i==pos_res)
                continue;
            int f1 = getFarther(f, edges[i][0]);
            //cout<<f1<<endl;
            if(f1 == edges[i][1])
                break;
            f[edges[i][1]] = edges[i][0];
        }
        //cout<<i<<endl;
        if(i == edges.size()){
            return edges[pos_res];
        }
        else if(pos_res<edges.size())
            return pos_res2;
        else
            return edges[i];
        
    }
    int getFarther(unordered_map<int, int> &f, int x){
        int farther = f[x];
        /*
        while(farther != x){
            x = farther;
            farther = f[farther];
        }
        */
        if(farther != x){
            farther = getFarther(f, farther);
            f[x] = farther;
        }
        return farther;
    }

}
