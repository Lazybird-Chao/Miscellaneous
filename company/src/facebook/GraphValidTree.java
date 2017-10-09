package facebook;

public class GraphValidTree {
	 public boolean validTree(int n, int[][] edges) {
	        if(edges == null || edges.length != n-1)
	            return false;
	        int[] f = new int[n];
	        for(int i = 0; i<n; i++)
	            f[i] = i;
	        for(int i = 0; i < edges.length; i++){
	            if(find(f, edges[i][0]) != find(f, edges[i][1]))
	                union(f, edges[i][0], edges[i][1]);
	            else{
	                return false;
	            }
	        }
	        for(int i = 1; i < n; i++){
	            if(find(f, i) != find(f, i-1))
	                return false;
	        }
	        return true;
	    }
	    
	    int find(int[] farther, int i){
	        if(farther[i] == i)
	            return i;
	        else{
	            farther[i] = find(farther, farther[i]);
	            return farther[i];
	        }
	    }
	    
	    void union(int[] farther, int i, int j){
	        farther[find(farther, j)] = find(farther, i);
	        return;
	    }

}
