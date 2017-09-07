package amazon;

public class Search2DMatrix2 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0)
			return false;
		int h = matrix.length;
		int w = matrix[0].length;
		int i=0;
		int j= w-1;
		while(i<h && j>=0) {
			if(matrix[i][j] < target) {
				i++;
			} else if(matrix[i][j] > target) {
				j--;
			} else
				return true;
		}
		return false;
	}

}
