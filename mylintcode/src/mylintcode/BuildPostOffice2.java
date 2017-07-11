package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuildPostOffice2 {
	/*
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
	*/
	
	
	public class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
   public int shortestDistance(int[][] grid) {
       // Write your code here
       if(grid == null || grid.length == 0 || grid[0].length == 0){
           return -1;
       }
       ArrayList<Point> offices = new ArrayList<Point>();
       int m = grid.length;
       int n = grid[0].length;
       for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(grid[i][j] == 1){
                  Point point = new Point(i, j);
                  offices.add(point);
               }
           }
       } 
       int[][] distance = new int[m][n];
       boolean[][] blackList = new boolean[m][n];
       for(Point office: offices){
           updateDis(office, grid, distance, blackList);
       }
       int smallest = findSmallest(grid, distance, blackList);
      return smallest;
   }
    public void updateDis(Point office, int[][] grid, int[][] distance, boolean[][] blackList){
        int[] helperX = {1, 0, -1, 0};
        int[] helperY = {0, 1, 0, -1};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] accessed = new boolean[m][n];
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(office);
        int steps = 0;
        while(queue.isEmpty()){
            int size = queue.size();
            steps++;
            for(int i = size; i >0; i-- ){
                Point cur = queue.poll();
                for(int z = 0; z < 4; z++){
                   Point next = new Point(cur.x + helperX[z], cur.y + helperY[z]);
                   if(!inBound(next, grid)){
                       continue;
                   }
                   if(accessed[next.x][next.y] == true){
                       continue;
                   }
                   if(grid[next.x][next.y] == 0){
                       accessed[next.x][next.y] = true;
                       distance[next.x][next.y] += steps;
                       queue.offer(next);
                   }
                }
            }
       }
        for( int p = 0 ; p < m; p++){
           for(int q = 0 ; q < n; q++){
               if(accessed[p][q] == false){
                   blackList[p][q] = true;
               }
           }
       }
   }
    public boolean inBound(Point p, int[][]grid){
        int l = grid.length;
        int w = grid[0].length;
        if(p.x < 0 || p.x >= l){
            return false;
        }
        if(p.y < 0 || p.y >= w){
            return false;
        }
        return true;
    }
    
    public int findSmallest(int[][] grid,int[][] distance, boolean[][] blackList){
       int shortest =  Integer.MAX_VALUE;
       int m = grid.length;
       int n = grid[0].length;
       for(int x = 0; x < m; x++){
           for(int y=0; y< n; y++){
               if(grid[x][y] == 1 || grid[x][y] == 2){
                   continue;
               }
               if(blackList[x][y] == true){
                   continue;
               }
               shortest = Math.min(shortest, distance[x][y] );
           }
       }
       if(shortest == Integer.MAX_VALUE){
           return -1;
       }
       return shortest;
      
   }
	
	public static void main(String[] args){
		int[][] grid = {{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}};
		BuildPostOffice2 test = new BuildPostOffice2();
		System.out.println(test.shortestDistance(grid));
	}

}
