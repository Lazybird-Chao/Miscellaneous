package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
	
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	
	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> res = new ArrayList<Integer>();
		if(operators==null || operators.length==0) {
			return res;
		}
		
		int[][] root = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				root[i][j] = -1;
		int count = 0;
		for(int i=0; i<operators.length; i++) {
			Point target = operators[i];
			int r = target.x;
			int c = target.y;
			if(root[r][c]!=-1)
			    res.add(count);
		    else{
    			root[r][c] = r*m+c;
    			count++;
    			if(c-1>=0 && root[r][c-1]!=-1) {
    				if(findroot(root, r, c-1)!=findroot(root, r, c)) {
    					union(root, new Point(r, c-1), target);
    					count--;
    				}
    			}
    			if(c+1<m && root[r][c+1]!=-1) {
    				if(findroot(root, r, c+1) != findroot(root, r, c)) {
    					union(root, new Point(r, c+1), target);
    					count--;
    				}
    			}
    			if(r-1>=0 && root[r-1][c]!=-1) {
    				if(findroot(root, r-1, c) != findroot(root, r, c)) {
    					union(root, new Point(r-1, c), target);
    					count--;
    				}
    			}
    			if(r+1<n && root[r+1][c]!=-1) {
    				if(findroot(root, r+1, c) != findroot(root, r, c)) {
    					union(root, new Point(r+1, c), target);
    					count--;
    				}
    			}
    			res.add(count);
		    }
		}
		return res;
			
	}
	
	public void union(int[][] root, Point a, Point b) {
		int n = root.length;
		int m = root[0].length;
		int roota = root[a.x][a.y];
		int r = a.x;
		int c = a.y;
		while(roota != r*m+c) {
			r = roota/m;
			c = roota%m;
			roota = root[r][c];
		}
		r = a.x;
		c = a.y;
		int tmp = root[a.x][a.y];
		while(tmp != r*m+c) {
			root[r][c] = roota;
			r = tmp/m;
			c = tmp%m;
			tmp = root[r][c];
		}
		
		
		int rootb = root[b.x][b.y];
		r = b.x;
		c = b.y;
		while(rootb != r*m+c) {
			root[r][c] = roota;
			r = rootb/m;
			c = rootb%m;
			rootb = root[r][c];
		}
		root[r][c] = roota;
		
	}
	
	public int findroot(int[][] root, int x, int y){
    	int n = root.length;
		int m = root[0].length;
		int roota = root[x][y];
		int r = x;
		int c = y;
		while(roota != r*m+c) {
			r = roota/m;
			c = roota%m;
			roota = root[r][c];
		}
		return roota;
	}
	
	

}
