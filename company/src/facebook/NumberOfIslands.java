package facebook;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    expand(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    void expand(char[][] grid, int x, int y){
        int[] nx = {0,0,1,-1};
        int[] ny = {1,-1,0,0};
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        qx.offer(x);
        qy.offer(y);
        grid[x][y] = '0';
        while(! qx.isEmpty()){
            int curx = qx.poll();
            int cury = qy.poll();
            for(int i=0; i<4; i++){
                int tx = curx + nx[i];
                int ty = cury + ny[i];
                if(isvalid(grid, tx, ty) && grid[tx][ty] == '1'){
                    qx.offer(tx);
                    qy.offer(ty);
                    grid[tx][ty] = '0';
                }
            }
        }
        return;
    }
    boolean isvalid(char[][] grid, int x, int y){
        if(x>=grid.length || x<0 || y<0 || y>=grid[0].length)
            return false;
        return true;
    }

}
