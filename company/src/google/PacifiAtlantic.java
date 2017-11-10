package google;

public class PacifiAtlantic {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int[][] color = new int[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix[0].length; i++)
            dfs(matrix, 0, i, color, 1, res);
        for(int i = 1; i<matrix.length; i++)
            dfs(matrix, i, 0, color, 1, res);
        for(int i = 0; i < matrix[0].length; i++)
            dfs(matrix, matrix.length-1, i, color, 2, res );
        for(int i = 0; i < matrix.length-1; i++)
            dfs(matrix, i, matrix[0].length-1, color, 2, res);
        return res;  
    }
    void dfs(int[][] matrix, int x, int y, int[][] color, int ocean, List<int[]> res){
        if(ocean == 1){
            if(color[x][y] == 1)
                return;
            else
                color[x][y] = 1;
        }
        else if(ocean == 2){
            if(color[x][y] == 0)
                color[x][y] = 2;
            else if(color[x][y] == 1){
                int[] tmp = {x, y};
                res.add(tmp);
                color[x][y] = 3;
            }else
                return; 
        }
        if(isValid(matrix, x, y-1) && matrix[x][y] <= matrix[x][y-1])
            dfs(matrix, x, y-1, color, ocean, res);
        if(isValid(matrix, x, y+1) && matrix[x][y] <=matrix[x][y+1])
            dfs(matrix, x, y+1, color,ocean, res);
        if(isValid(matrix, x-1, y) && matrix[x][y] <=matrix[x-1][y])
            dfs(matrix, x-1, y, color, ocean,res);
        if(isValid(matrix, x+1, y) && matrix[x][y] <= matrix[x+1][y])
            dfs(matrix, x+1, y, color, ocean, res);
        return;
    }
    boolean isValid(int[][] matrix, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return false;
        return true;
    }

}
