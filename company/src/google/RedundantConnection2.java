package google;

public class RedundantConnection2 {
	 public int[] findRedundantDirectedConnection(int[][] edges) {
	        if(edges == null || edges.length == 0)
	            return new int[0];
	        int[] f = new int[edges.length+1];
	        for(int i=0; i<= edges.length; i++)
	            f[i] = i;
	        int v1, v2, v3;
	        v1 = v2 = v3 = 0;
	        boolean hasDualfather =false;
	        for(int i= 0; i<edges.length; i++){
	            if(f[edges[i][1]] != edges[i][1]){
	                hasDualfather = true;
	                v1 = f[edges[i][1]];
	                v2 = edges[i][0];
	                v3 = edges[i][1];
	                break;
	            }
	            f[edges[i][1]] = edges[i][0];
	        }
	        for(int i=0; i<= edges.length; i++)
	            f[i] = i;
	        if(hasDualfather== false)
	            return edges[circlePos(f, edges, 0, 0)];
	        else{
	            if(circlePos(f, edges, v2, v3) == -1){
	                int[] tmp = {v2, v3};
	                return tmp;
	            }
	            else{
	                int[] tmp = {v1, v3};
	                return tmp;
	            }
	        }
	        
	    }
	    int find(int[] f, int id){
	        if(f[id]==id)
	            return id;
	        else
	            return find(f, f[id]);
	    }
	    int circlePos(int[] f, int[][] edges, int v2, int v3){
	        for(int i= 0; i<edges.length; i++){
	            if(edges[i][0]==v2 && edges[i][1]==v3)
	                continue;
	            int f1 = find(f, edges[i][0]);
	            int f2 = edges[i][1];
	            if(f1 == f2)
	                return i;
	            else
	                f[edges[i][1]] = edges[i][0];
	        }
	        return -1;
	    }

}
