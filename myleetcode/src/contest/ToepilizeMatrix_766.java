package contest;

public class ToepilizeMatrix_766 {
	bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        if(matrix.empty())
            return true;
        int m = matrix.size();
        int n = matrix[0].size();
        for(int i=0; i<m; i++){
            int num = matrix[i][0];
            int j = i;
            int k = 0;
            while(j<m && k<n){
                if(matrix[j][k]!=num)
                    return false;
                j++;
                k++;
            }
        }
        for(int i=1; i<n; i++){
            int num = matrix[0][i];
            int j= 0;
            int k=i;
            while(j<m && k<n){
                if(matrix[j][k] != num)
                    return false;
                j++;
                k++;
            }
        }
        return true;
    }

}
