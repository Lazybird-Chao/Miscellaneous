package facebook;

public class MaxSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return 0;
        int[] f = new int[matrix[0].length];
        int oldf = 0;
        int maxarea = 0;
        for(int i = 0; i < matrix.length; i++){
            oldf = f[0];
            if(matrix[i][0] == '0')
                f[0] = 0;
            else
                f[0] = 1;
            maxarea = Math.max(maxarea, f[0]);
            
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    oldf = f[j];
                    f[j] = 0;
                }else{
                    int tmp = Math.min(f[j], Math.min(f[j-1], oldf))+1;
                    oldf = f[j];
                    f[j] = tmp;
                    maxarea = Math.max(maxarea, f[j]*f[j]);
                }
            }
        }
        return maxarea;
    }

}
