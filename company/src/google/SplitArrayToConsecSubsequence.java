package google;

public class SplitArrayToConsecSubsequence {
	bool isPossible(vector<int>& nums) {
        if(nums.empty())
            return false;
        unordered_map<int, int> counts;
        for(int i=0; i<nums.size(); i++){
            if(counts.find(nums[i]) == counts.end())
                counts[nums[i]] =1 ;
            else
                counts[nums[i]]++;
        }
        unordered_map<int, int> seqs;
        for(int i=0; i<nums.size(); i++){
            int n = nums[i];
            if(counts[n]==0)
                continue;
            if(seqs.find(n-1) != seqs.end() && seqs[n-1]>0){
                seqs[n-1]--;
                if(seqs.find(n) == seqs.end())
                    seqs[n] = 1;
                else
                    seqs[n]++;
            }else{
                if(counts.find(n+1)==counts.end() || counts[n+1]==0)
                    return false;
                if(counts.find(n+2)==counts.end() || counts[n+2]==0)
                    return false;
                counts[n+1]--;
                counts[n+2]--;
                if(seqs.find(n+2)==seqs.end())
                    seqs[n+2] = 1;
                else
                    seqs[n+2]++;
            }
            counts[n]--;
        }
        return true;
    }

}
