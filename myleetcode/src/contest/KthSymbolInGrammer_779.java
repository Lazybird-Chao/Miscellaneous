package contest;

public class KthSymbolInGrammer_779 {
	int kthGrammar(int N, int K) {
        int len = 1;
        while(len < K)
            len *= 2;
        return helper(len, K);
    }
    int helper(int len, int k){
        if(len==1)
            return 0;
        len = len/2;
        if(k > len){
            k = k-len;
            return helper(len, k) ^ 1;
        }else
            return helper(len, k);
    }

}
