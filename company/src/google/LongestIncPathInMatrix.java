package google;

public class LongestIncPathInMatrix {
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length == 0)
            return 0;
        int[][] lengthInc = new int[matrix.length][matrix[0].length];
        //int[][] lengthDec = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                findInc(matrix, i, j, lengthInc);
                //findDec(matrix, i, j, lengthDec, lengthInc);
            }
        }
        return maxlen;
        
    }
    int maxlen = 0;
    int findInc(int[][] matrix, int x, int y, int[][] length){
            if(length[x][y] != 0)
                return length[x][y];
            int curlen = 1;
            if(isValid(matrix, x, y-1) && matrix[x][y] < matrix[x][y-1])
                curlen = Math.max(curlen, 1 + findInc(matrix, x, y-1, length));
            if(isValid(matrix, x, y+1) && matrix[x][y] < matrix[x][y+1])
                curlen = Math.max(curlen, 1 + findInc(matrix, x, y+1, length));
            if(isValid(matrix, x-1, y) && matrix[x][y] < matrix[x-1][y])
                curlen = Math.max(curlen, 1 + findInc(matrix, x-1, y, length));
            if(isValid(matrix, x+1, y) && matrix[x][y] < matrix[x+1][y])
                curlen = Math.max(curlen, 1 + findInc(matrix, x+1, y, length));
            length[x][y] = curlen;
            maxlen = Math.max(maxlen, curlen);
            return curlen;
    }
    /*
     int findDec(int[][] matrix, int x, int y, int[][] length, int[][] lengthInc){
            if(length[x][y] != 0)
                return length[x][y];
            int curlen = 1;
            if(isValid(matrix, x, y-1) && matrix[x][y] > matrix[x][y-1])
                curlen = Math.max(curlen, 1 + findDec(matrix, x, y-1, length, lengthInc));
            if(isValid(matrix, x, y+1) && matrix[x][y] > matrix[x][y+1])
                curlen = Math.max(curlen, 1 + findDec(matrix, x, y+1, length, lengthInc));
            if(isValid(matrix, x-1, y) && matrix[x][y] > matrix[x-1][y])
                curlen = Math.max(curlen, 1 + findDec(matrix, x-1, y, length, lengthInc));
            if(isValid(matrix, x+1, y) && matrix[x][y] > matrix[x+1][y])
                curlen = Math.max(curlen, 1 + findDec(matrix, x+1, y, length, lengthInc));
            length[x][y] = curlen;
            maxlen = Math.max(maxlen, curlen+lengthInc[x][y]-1);
            return curlen;
    } */
    boolean isValid(int[][] matrix, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return false;
        return true;
    }

}
