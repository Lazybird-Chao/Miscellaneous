package google;

public class KthSmallestInMultiTable {
	 /*
    public int findKthNumber(int m, int n, int k) {
        if(k > m*n)
            return 0;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(m, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.value - b.value;
            }
        });
        for(int i=1; i<=m; i++)
            q.offer(new Pair(i, i));
        int kmax = 0;
        for(int i=0; i<k; i++){
            Pair cur = q.poll();
            kmax = cur.value;
            cur.value += cur.row;
            if(cur.value <= cur.row*n)
                q.offer(cur);
        }
        return kmax;
        
    }
    */
    
    class Pair{
        public int row;
        public int value;
        public Pair(int r, int v){
            row = r;
            value = v;
        }
    }
    
    public int findKthNumber(int m, int n, int k){
        if(k > m*n)
            return 0;
        int right = m*n;
        int left = 1;
        while(left +1 <right){
            int mid = left + (right-left)/2;
            int c = countSmaller(mid, m, n);
            if(c < k)
                left = mid;
            else
                right = mid;
        }
        return right;
        
    }
    int countSmaller(int x, int m, int n){
        int c = 0;
        int a = Math.min(m, n);
        int b = Math.max(m, n);
        for(int i=1; i<=a; i++){
            c += Math.min(x/i, b);
        }
        return c;
    }
    

}
