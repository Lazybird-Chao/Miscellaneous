package contest;

public class GlobalLobalInversion_775 {
	bool isIdealPermutation(vector<int>& A) {
        if(A.empty())
            return true;
        /*
        int local_inver_count = 0;
        for(int i=0; i<A.size()-1; i++){
            if(A[i] > A[i+1])
                local_inver_count++;
        }
        */
        int premax = A[0];
        for(int i=0; i<A.size(); i++){
            if(i>=2){
                premax = max(premax, A[i-2]);
                if(A[i] < premax)
                    return false;
            }
        }
        return true;
    }

}
