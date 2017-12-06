package google;

public class RedundantConnection {
	 public int[] findRedundantConnection(int[][] edges) {
	        if(edges == null || edges.length == 0)
	            return new int[0];
	        int[] f = new int[edges.length+1];
	        for(int i = 0; i<f.length; i++)
	            f[i] = i;
	        for(int i = 0; i<edges.length; i++){
	            int f1 = farther(f, edges[i][0]);
	            int f2 = farther(f, edges[i][1]);
	            if(f1 == f2)
	                return edges[i];
	            else
	                f[f1] = f[f2];
	        }
	        return new int[0];
	        
	    }
	    int farther(int[] f, int id){
	        if(f[id] == id)
	            return id;
	        else{
	            int r = farther(f, f[id]);
	            f[id] = r;
	            return r;
	        }
	    }

}
