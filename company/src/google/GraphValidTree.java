package google;

public class GraphValidTree {
	 bool validTree(int n, vector<pair<int, int>>& edges) {
	        if(edges.size() != n-1)
	            return false;
	        vector<int> f(n);
	        for(int i=0; i<n; i++)
	            f[i] = i;
	        for(int i=0; i<edges.size(); i++){
	            int f1 = findFarther(f, edges[i].first);
	            int f2 = findFarther(f, edges[i].second);
	            if(f1 == f2)
	                return false;
	            f[f2] = f1;
	        }
	        return true;
	    }
	    int findFarther(vector<int>& f, int x){
	        if(f[x] == x)
	            return x;
	        int fa = findFarther(f, f[x]);
	        f[x] = fa;
	        return fa;
	    }

}
