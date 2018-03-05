package contest;

public class NumOfSubarrayWithBoundedMax_795 {
	int numSubarrayBoundedMax(vector<int>& A, int L, int R) {
        if(A.empty())
            return 0;
        vector<int> f(A.size(), 0);
        int total_count = 0;
        int last_pos = -1;
        if(A[0] >= L && A[0]<= R){
            f[0] = 1;
        }else if(A[0] > R)
            last_pos = 0;
        total_count += f[0];
        for(int i=1; i<A.size(); i++){
            if(A[i] >=L && A[i]<= R)
                f[i] = i-last_pos;
            else if(A[i] < L)
                f[i] = f[i-1];
            else{ 
                f[i] = 0;
                last_pos = i;
            }
            total_count += f[i];
        }
        return total_count;
    }

}
