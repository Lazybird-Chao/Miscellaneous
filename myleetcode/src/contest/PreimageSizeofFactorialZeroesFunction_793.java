package contest;

public class PreimageSizeofFactorialZeroesFunction_793 {
	int preimageSizeFZF(int K) {
        if(K<1)
            return 5;
        
        int cnt = check(K+1) - check(K);
        
        return cnt;
    }
    int check(int K){
        int left = K;
        int right = K*5;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            int cnt = findCount(mid);
            if(cnt >= K)
                right = mid;
            else
                left = mid;
        }
        if(findCount(left)>=K)
            return left;
        else
            return right;
    }
    
    int findCount(int x){
        int i = 5;
        int cnt = 0;
        while(i<=x){
            cnt += x/i;
            i*=5;
        }
        return cnt;
    }
}
