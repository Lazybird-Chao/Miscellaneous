package google;

public class NumOfComponentsInUDG {
	 int countComponents(int n, vector<pair<int, int>>& edges) {
	        if(edges.empty())
	            return n;
	        int f[n];
	        for(int i=0; i<n; i++)
	            f[i] = i;
	        for(int i=0; i<edges.size(); i++){
	            int f1 = findFarther(f, edges[i].first);
	            int f2 = findFarther(f, edges[i].second);
	            if(f1 != f2){
	                f[f2] = f1;
	            }
	        }
	        int count = n;
	        for(int i=0; i<n; i++){
	            if(f[i]!=i)
	                count--;
	        }
	        return count;
	    }
	    int findFarther(int f[], int x){
	        if(f[x] == x)
	            return x;
	        int fa = findFarther(f, f[x]);
	        f[x] = fa;
	        return fa;
	    }

}
