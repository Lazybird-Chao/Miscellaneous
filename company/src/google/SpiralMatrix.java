package google;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0].length ==0)
            return new ArrayList<Integer>();
        int i, j, k;
        int h_s, h_e, w_s, w_e;
        i = j = k = 0;
        h_s = w_s = 0;
        h_e = matrix.length-1;
        w_e = matrix[0].length-1;
        List<Integer> res = new ArrayList<Integer>();
        while(k < matrix.length*matrix[0].length){
            i = h_s;
            j = w_s;
            while(j<=w_e){
                res.add(matrix[i][j++]);
                k++;
            }
            j--;
            i++;
            while(i<=h_e){
                res.add(matrix[i++][j]);
                k++;
            }
            i--;
            j--;
            while(j>=w_s && i>h_s){
                res.add(matrix[i][j--]);
                k++;
            }
            j++;
            i--;
            while(i>h_s && j<w_e){
                res.add(matrix[i--][j]);
                k++;
            }
            h_s++;
            w_s++;
            h_e--;
            w_e--;
        }
        return res;
    }

}
