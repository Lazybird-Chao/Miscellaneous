package google;

public class RedundentConnection {
	vector<int> findRedundantConnection(vector<vector<int>>& edges){
        if(edges.empty())
            return vector<int>();
        unordered_map<int, int> f;
        for(int i=0; i<edges.size(); i++){
            if(f.find(edges[i][0])==f.end())
                f[edges[i][0]] = edges[i][0];
            if(f.find(edges[i][1])==f.end())
                f[edges[i][1]] = edges[i][1];
        }
        int i=0; 
        for(; i<edges.size(); i++){
            int f1 = findFarther(f, edges[i][0]);
            int f2 = findFarther(f, edges[i][1]);
            if(f1 == f2)
                break;
            else{
                if(f1 < f2)
                    f[f2] = f1;
                else
                    f[f1] = f2;
            }
        }
        return edges[i];
        
    }
    int findFarther(unordered_map<int, int> &f, int x){
        int farther = f[x];
        if(farther != x){
            farther = findFarther(f, farther);
            f[x] = farther;
        }
        return farther;
    }

}
