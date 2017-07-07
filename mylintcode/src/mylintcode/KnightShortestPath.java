package mylintcode;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
	public class Point {
	      public int x, y;
	      public Point() { x = 0; y = 0; }
	      public Point(int a, int b) { x = a; y = b; }
	}
	public int shortestPath(boolean[][] grid, Point source, Point destination) {
		if(grid == null || grid.length <=source.x || grid[0].length <=source.y)
			return -1;
		if(grid[source.x][source.y]==true)
			return -1;
		
		int w = grid[0].length;
		int h = grid.length;
		int[][] neighborPos = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
		boolean[][] accessed = new boolean[h][w];
		Queue<Point> accList = new LinkedList<Point>();
		accList.offer(source);
		accessed[source.x][source.y] = true;
		int step = 0;
		while(accList.isEmpty()==false){
			int levCount = accList.size();
			for(int j=0; j<levCount; j++){
				Point cur = accList.poll();
				if(cur.x == destination.x && cur.y == destination.y)
					return step;
				for(int i=0; i<8; i++){
					int tx = cur.x + neighborPos[i][0];
					int ty = cur.y + neighborPos[i][1];
					if(isInBound(h, w, tx,ty) && accessed[tx][ty]==false && grid[tx][ty]==false){
						accList.offer(new Point(tx,ty));
						accessed[tx][ty] = true;
					}
				}
			}
			step++;
		}
		return -1;
	}
	
	public boolean isInBound(int h, int w, int x, int y){
		if(x<0 || x>=h || y<0 || y>=w)
			return false;
		else
			return true;
	}

}
