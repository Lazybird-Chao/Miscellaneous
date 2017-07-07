package mylintcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public int numIslands(boolean[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0)
			return 0;
		
		int w = grid[0].length;
		int h = grid.length;
		int islandsCount =0;
		boolean[][] accessed = new boolean[h][w];
		int[][] neighborPos = {{0,1},{0,-1},{1,0},{-1,0}};
		Queue<Integer> accList = new LinkedList<Integer>();
		
		int start = findOne(grid, accessed);
		while(start>=0){
			accList.offer(start);
			accessed[start/w][start%w]=true;
			while(accList.isEmpty()==false){
				int current = accList.poll();
				int x = current/w;
				int y = current%w;
				for(int i=0; i<4; i++){
					int tx = x+neighborPos[i][0];
					int ty = y+neighborPos[i][1];
					if(isInBound(h,w,tx, ty) && accessed[tx][ty]==false
							&& grid[tx][ty]==true){
						accList.offer(tx*w+ty);
						accessed[tx][ty] = true;
					}
				}	
			}
			islandsCount++;
			start = findOne(grid, accessed);
		}
		return islandsCount;
	}
	
	int findOne(boolean[][] grid, boolean[][] accessed){
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid[0].length; j++)
				if(grid[i][j]==true && accessed[i][j]==false)
					return i*grid[0].length+j;
		return -1;
	}
	
	boolean isInBound(int h, int w, int x, int y){
		if(x<0 || x>=h || y<0 || y>=w)
			return false;
		return true;
	}

}
