package google;

public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0)
            return res;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while( i < nums.length){
            sb.append(String.valueOf(nums[i]));
            int start = i;
            while( i < nums.length-1 && nums[i]+1 == nums[i+1])
                i++;
            if(i>start){
                sb.append("->");
                sb.append(String.valueOf(nums[i]));
            }
            res.add(sb.toString());
            sb.setLength(0);
            i++;
        }
        return res;
    }

}
