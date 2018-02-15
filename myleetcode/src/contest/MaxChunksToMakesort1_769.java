package contest;

public class MaxChunksToMakesort1_769 {
	int maxChunksToSorted(vector<int>& arr) {
        if(arr.empty())
            return 0;
        int s = arr.size();
        int e = -1;
        int i=0;
        int j=0;
        int count = 0;
        while(i<arr.size()){
            j = i;
            s = e = arr[i];
            while(j<arr.size()){
                s = min(s, arr[j]);
                e = max(e, arr[j]);
                if(s==i && e==j){
                    count++;
                    i = j+1;
                    break;
                }
                j++;
            }
        }
        return count;
    }

}
