package mylintcode;

import java.util.LinkedList;
import java.util.Queue;

public class BuildPostOffice2 {
	public int shortestDistance(int[][] grid) {
		if(grid==null || grid.length ==0 || grid[0].length ==0)
			return -1;
		
		int [][] cost = new int[grid.length][grid[0].length];

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j]==1)
					helper(grid, i,j,cost);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == 0 && cost[i][j]>=0)
					min = Math.min(cost[i][j], min);
			}
		}
		
		if(min==Integer.MAX_VALUE)
			return -1;
		else
			return min;
		
	}
	
	public void helper(int[][] grid, int startx, int starty, int[][] cost){
		int h = grid.length;
		int w = grid[0].length;
		int[][] neighborPos = {{0,1},{0,-1},{-1,0},{1,0}};
		Queue<Integer> accList = new LinkedList<Integer>();
		boolean[][] accessed = new boolean[h][w];
		accList.offer(startx*w+starty);
		accessed[startx][starty]= true;
		int step = 0;
		while(accList.isEmpty()==false){
			int levelsize = accList.size();
			for(int j=0; j< levelsize; j++){
				int cur = accList.poll();
				int x = cur/w;
				int y = cur%w;
				for(int i=0; i<4; i++){
					int tx = x+neighborPos[i][0];
					int ty = y+neighborPos[j][1];
					if(inBound(h,w,tx,ty) && grid[tx][ty]==0 && accessed[tx][ty]==false){
						accList.offer(tx*w+ty);
						accessed[tx][ty] = true;
						if(cost[tx][ty]>=0)
							cost[tx][ty] += step+1;
					}
				}
			}
			step++;
		}
		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++)
				if(grid[i][j]==0 && accessed[i][j]==false)
					cost[i][j]=-1;
					
		return;
	}
	
	public boolean inBound(int h, int w, int x, int y){
		if(x<0 || x>=h || y<0 || y>= w )
			return false;
		else
			 return true;
	}
	
	public static void main(String[] args){
		int[][] grid = {{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}};
		BuildPostOffice2 test = new BuildPostOffice2();
		System.out.println(test.shortestDistance(grid));
	}

}
