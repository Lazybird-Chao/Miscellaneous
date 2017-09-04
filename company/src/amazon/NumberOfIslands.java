package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int h = grid.length;
		int w = grid[0].length;
		
		
		int count = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(grid[i][j] == '1') {
					expand(grid, i, j);
					count++;
				}
			}
		}
		return count;
		
	}
	
	void expand(char[][] grid, int x, int y) {
		int w = grid[0].length;
		int h = grid.length;
		int[] xarray = {-1, 1, 0, 0};
		int[] yarray = {0, 0, -1, 1};
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer( x*w + y);
		grid[x][y] = '0';
		while(!q.isEmpty()) {
			int cur = q.poll();
			int c_x = cur/w;
			int c_y = cur%w;
			for(int i=0; i<4; i++) {
				int n_x = c_x + xarray[i];
				int n_y = c_y + yarray[i];
				if(checkValid(h, w, n_x, n_y) && grid[n_x][n_y]=='1') {
					q.offer(n_x*w + n_y);
					grid[n_x][n_y] = '0';
				}
			}
		}
		return;
		
	}
	
	boolean checkValid(int h, int w, int x, int y) {
		if(x >=0 && x < h && y>=0 && y<w)
			return true;
		else
			return false;
	}

}
