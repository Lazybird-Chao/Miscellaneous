package google;

public class TrapWater2 {
	class Solution {
	    /*
	    public int trapRainWater(int[][] heightMap) {
	        if(heightMap == null || heightMap.length == 0 || heightMap[0].length==0)
	            return 0;
	        int trapwater = 0;
	        for(int i = 1; i < heightMap.length-1; i++){
	            for(int j = 1; j < heightMap[0].length-1; j++){
	                trapwater += bfs(heightMap, i, j);
	                //System.out.println(trapwater);
	            }
	        }
	        return trapwater;
	    }
	    
	    int bfs(int[][] heightMap, int x, int y){
	        int baseH = heightMap[x][y];
	        PriorityQueue<Point> boundQ = new PriorityQueue<Point>(1, new Comparator<Point>(){
	            public int compare(Point a, Point b){
	                return a.h - b.h;
	            }
	        });
	        boolean[][] accessed = new boolean[heightMap.length][heightMap[0].length];
	        for(int i = 0; i<heightMap.length; i++)
	            for(int j = 0; j < heightMap[0].length; j++)
	                accessed[i][j] = false;
	        boundQ.add(new Point(x, y, baseH));
	        accessed[x][y] = true;
	        int maxh = 0;
	        while(true){
	            int minh = boundQ.peek().h;
	            //System.out.println(minh);
	            maxh = Math.max(maxh, minh - baseH);
	            Point minp = boundQ.peek();
	            if(minp.x == 0 || minp.x == heightMap.length-1 || minp.y == 0 || minp.y == heightMap[0].length-1)
	                break;
	            boundQ.poll();
	            if(minp.x-1 >=0 && accessed[minp.x-1][minp.y] == false){
	                boundQ.offer(new Point(minp.x-1, minp.y, heightMap[minp.x-1][minp.y]));
	                accessed[minp.x-1][minp.y] = true;  
	            }
	            if(minp.x+1 < heightMap.length && accessed[minp.x+1][minp.y] == false){
	                boundQ.offer(new Point(minp.x+1, minp.y, heightMap[minp.x+1][minp.y]));
	                accessed[minp.x+1][minp.y] = true;
	            }
	            if(minp.y-1 >=0 && accessed[minp.x][minp.y-1] == false){
	                boundQ.offer(new Point(minp.x, minp.y-1, heightMap[minp.x][minp.y-1]));
	                accessed[minp.x][minp.y-1] = true;
	            }
	            if(minp.y+1 < heightMap[0].length && accessed[minp.x][minp.y+1] == false){
	                boundQ.offer(new Point(minp.x, minp.y+1, heightMap[minp.x][minp.y+1]));
	                accessed[minp.x][minp.y+1] = true;
	            }
	        }
	        return maxh;
	    }
	    class Point{
	        int x;
	        int y;
	        int h;
	        public Point(int x, int y, int h){
	            this.x = x;
	            this.y = y;
	            this.h = h;
	        }
	    }
	    */
	    class Cell {
	        int row;
	        int col;
	        int height;
	        public Cell(int row, int col, int height) {
	            this.row = row;
	            this.col = col;
	            this.height = height;
	        }
	    }

	    public int trapRainWater(int[][] heights) {
	        if (heights == null || heights.length == 0 || heights[0].length == 0)
	            return 0;

	        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
	            public int compare(Cell a, Cell b) {
	                return a.height - b.height;
	            }
	        });
	        
	        int m = heights.length;
	        int n = heights[0].length;
	        boolean[][] visited = new boolean[m][n];

	        // Initially, add all the Cells which are on borders to the queue.
	        for (int i = 0; i < m; i++) {
	            visited[i][0] = true;
	            visited[i][n - 1] = true;
	            queue.offer(new Cell(i, 0, heights[i][0]));
	            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
	        }

	        for (int i = 0; i < n; i++) {
	            visited[0][i] = true;
	            visited[m - 1][i] = true;
	            queue.offer(new Cell(0, i, heights[0][i]));
	            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
	        }

	        // from the borders, pick the shortest cell visited and check its neighbors:
	        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
	       // add all its neighbors to the queue.
	        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	        int res = 0;
	        while (!queue.isEmpty()) {
	            Cell cell = queue.poll();
	            for (int[] dir : dirs) {
	                int row = cell.row + dir[0];
	                int col = cell.col + dir[1];
	                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
	                    visited[row][col] = true;
	                    res += Math.max(0, cell.height - heights[row][col]);
	                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
	                }
	            }
	        }
	        
	        return res;
	    }
	}

}
