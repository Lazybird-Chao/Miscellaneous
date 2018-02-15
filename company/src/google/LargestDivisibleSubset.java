package google;

public class LargestDivisibleSubset {
	class Pair{
        int idx;
        int len;
        Pair(){
            idx = -1;
            len = 0;
        }
        Pair(int i, int l){
            idx = i;
            len = l;
        }
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length==0)
            return new ArrayList<Integer>();
        Arrays.sort(nums);
        Pair[] f = new Pair[nums.length];
        f[0] = new Pair(0, 1);
        int maxlen = 1;
        int idx = 0;
        for(int i=1; i<nums.length; i++){
            f[i] = new Pair(i, 1);
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j]==0 && f[i].len < f[j].len+1){
                    f[i].len = f[j].len+1;
                    f[i].idx = j;
                }
            }
            if(maxlen < f[i].len){
                maxlen = f[i].len;
                idx = i;
            }
        }
        //System.out.println(maxlen);
        List<Integer> res = new ArrayList<Integer>();
        while(f[idx].idx != idx){
            res.add(nums[idx]);
            idx = f[idx].idx;
        }
        res.add(nums[idx]);
        return res;
    }

}
