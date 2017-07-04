package mylintcode;

public class Search2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
			 return false;
		 int start, end;
		 start = 0; 
		 end = matrix.length-1;
		 while(start+1 < end){
			 int mid = start + (end-start)/2;
			 if(matrix[mid][0] > target)
				 end = mid;
			 else if(matrix[mid][0]< target)
				 start = mid;
			 else
				 return true;
		 }
		 if(matrix[start][0] == target || matrix [end][0] == target)
			 return true;
		 if(matrix[start][0] > target)
			 return false;
		 int line=0;
		 if(matrix[end][0]>target)
			 line = start;
		 else
			 line = end;
		 start = 0; 
		 end = matrix[line].length-1;
		 while(start + 1< end){
			 int mid = start + (end-start)/2;
			 if(matrix[line][mid]>target)
				 end = mid;
			 else if(matrix[line][mid]<target)
				 start = mid;
			 else
				 return true;
		 }
		 if(matrix[line][start]==target || matrix[line][end]==target)
			 return true;
		 else
			 return false;
	 }

}
