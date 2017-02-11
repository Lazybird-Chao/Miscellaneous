package myleetcode;

public class DiagnonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length==0)
			return new int[0];
		int i=0,j=0;
		int h = matrix.length;
		int w = matrix[0].length;
		int[] res = new int[h*w];
		int k=0;
		res[k] = matrix[i][j];k++;
		while(i!=h-1 || j!=w-1){
			if(i==0 || j== w-1){
				if(j==w-1)
					i++;
				else
					j++;
				res[k] = matrix[i][j];k++;
				while(i<h-1 && j>0){
					i++;
					j--;
					res[k] = matrix[i][j];k++;
				}
			}
			else if(j==0 || i==h-1){
				if(i==h-1)
					j++;
				else
					i++;
				res[k] = matrix[i][j];k++;
				while(i>0 && j<w-1){
					i--;
					j++;
					res[k] = matrix[i][j];k++;
				}
			}
		}
		return res;
	}
}
