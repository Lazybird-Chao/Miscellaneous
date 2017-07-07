package mylintcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
	static public int zombie(int[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0)
			return -1;
		
		int h = grid.length;
		int w = grid[0].length;
		Queue<Integer> accList = new LinkedList<Integer>();
		int peopleCount = 0;
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				if(grid[i][j]==1)
					accList.offer(i*w+j);
				else if(grid[i][j]==0)
					peopleCount++;
			}
		}
		int[][] neighborPos = {{0,1},{0,-1},{1,0},{-1,0}};
		int level = 0;
		while(accList.isEmpty()==false){
			int levelCount = accList.size();
			for(int j=0; j<levelCount; j++){
				int cur = accList.poll();
				int tx = cur/w;
				int ty = cur%w;
				for(int i=0; i<4; i++){
					int x = tx + neighborPos[i][0];
					int y = ty + neighborPos[i][1];
					if(isInBound(h,w,x,y) && grid[x][y]==0){
						grid[x][y] = 1;
						peopleCount--;
						accList.offer(x*w+y);
					}
				}
			}
			level++;
		}
		if(peopleCount==0)
			return level-1;
		else
			 return -1;
	}
	
	static boolean isInBound(int h, int w, int x, int y){
		if(x<0 || x>=h || y<0 || y>=w)
			return false;
		else
			return true;
	}
	
	public static void main(String args[]){
		int[][] grid = {{0,1,2,0,0},{1,0,0,2,1},{0,1,0,0,0}};
		System.out.println(zombie(grid));
	}

}
