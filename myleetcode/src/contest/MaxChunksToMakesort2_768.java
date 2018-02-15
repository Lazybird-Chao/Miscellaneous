package contest;

public class MaxChunksToMakesort2_768 {
	int maxChunksToSorted(vector<int>& arr) {
        if(arr.empty())
            return 0;
        vector<int> arr2(arr);
        sort(arr2.begin(), arr2.end());
        unordered_map<int, int> counts;
        int i=0;
        int zerocount = 0;
        int res = 0;
        while(i<arr.size()){
            if(counts.find(arr2[i])==counts.end())
                counts[arr2[i]]==0;
            if(counts[arr2[i]]==0)
                zerocount++;
            if(counts.find(arr[i])==counts.end())
                counts[arr[i]]==0;
            if(counts[arr[i]]==0)
                zerocount++;
            counts[arr2[i]]++;
            counts[arr[i]]--;
            if(counts[arr[i]]==0)
                zerocount--;
            if(counts[arr2[i]]==0)
                zerocount--;
            if(zerocount==0)
                res++;
            i++;
        }
        return res;
    }

}
