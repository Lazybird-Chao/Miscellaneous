package facebook;

public class SparseMatrixMultiply {
	public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null)
            return new int[0][0];
        int m = A.length;
        int p = A[0].length;
        int n = B[0].length;
        
        List<pair>[] As = new List[m];
        for(int i=0; i<A.length; i++){
            As[i] = new ArrayList<pair>();
            for(int j=0; j<A[0].length; j++){
                if(A[i][j] != 0)
                    As[i].add(new pair(j, A[i][j]));
            }
        }
        List<pair>[] Bs = new List[n];
        for(int i=0; i<B[0].length; i++){
            Bs[i] = new ArrayList<pair>();
            for(int j=0; j<B.length; j++){
                if(B[j][i] != 0)
                    Bs[i].add(new pair(j, B[j][i]));
            }
        }
        
        int[][] C = new int[m][n];
        for(int i=0; i<m; i++){
            if(As[i].size()==0)
                continue;
            for(int j=0; j<n; j++){
                if(Bs[j].size()==0)
                    continue;
                int k1 = 0;
                int k2 = 0;
                int tmp = 0;
                while(k1<As[i].size() && k2<Bs[j].size()){
                    if(As[i].get(k1).index == Bs[j].get(k2).index){
                        tmp += As[i].get(k1).value * Bs[j].get(k2).value;
                        k1++;
                        k2++;
                    } else if(As[i].get(k1).index < Bs[j].get(k2).index){
                        k1++;
                    } else{
                        k2++;
                    }
                }
                C[i][j] = tmp;
            }
        }
        return C;
    }
    class pair{
        int index;
        int value;
        public pair(int i, int v){
            index = i;
            value = v;
        }
    }
    
    public int[][] method2(int[][] A, int[][] B) {
       int m = A.length;
       int n = A[0].length;
       int nB = B[0].length;
       int[][] C = new int[m][nB];
       for (int i = 0;i<m;i++) {
           for (int k=0;k<n;k++) {
               if (A[i][k]!=0) {
                   for (int j=0;j<nB;j++) {
                       if (B[k][j]!=0) {
                           C[i][j]+=A[i][k]*B[k][j];
                       }
                   }
               }
           }
       }
       return C;
    }

}
