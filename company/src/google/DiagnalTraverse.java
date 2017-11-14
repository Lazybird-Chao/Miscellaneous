package google;

public class DiagnalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0)
            return new int[0];
        int h = matrix.length;
        int w = matrix[0].length;
        int[] res = new int[h*w];
        int i = 0;
        int j = 0;
        int k = 0;
        res[k++] = matrix[i][j];
        while(k < h*w){
            if(j < w-1)
                j++;
            else if(j== w-1)
                i++;
            while(i < h && j >=0){
                res[k++] = matrix[i][j];
                i++;
                j--;
            }
            i--;
            j++;
            if(i<h-1)
                i++;
            else if(i== h-1)
                j++;
            
            while(i>=0 && j < w){
                res[k++] = matrix[i][j];
                i--;
                j++;
            }
            i++;
            j--;
        }
        return res;
    }

}
