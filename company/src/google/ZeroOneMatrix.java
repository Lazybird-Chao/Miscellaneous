package google;

public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0)
                    res[i][j] = 0;
                else
                    res[i][j] = Integer.MAX_VALUE-1;
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i-1>=0 && res[i-1][j]+1 < res[i][j])
                    res[i][j] = res[i-1][j]+1;
                if(j-1>=0 && res[i][j-1]+1 < res[i][j])
                    res[i][j] = res[i][j-1]+1;
            }
        }
        for(int i=matrix.length-1; i>=0; i--){
            for(int j=matrix[0].length-1; j>=0; j--){
                if(i+1<matrix.length && res[i+1][j]+1 < res[i][j])
                    res[i][j] = res[i+1][j]+1;
                if(j+1<matrix[0].length && res[i][j+1]+1 < res[i][j])
                    res[i][j] = res[i][j+1]+1;
            }
        }
        return res;
    }

}
