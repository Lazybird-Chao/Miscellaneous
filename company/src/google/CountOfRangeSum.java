package google;

public class CountOfRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null || nums.length ==0)
            return 0;
        long[] presum  = new long[nums.length+1];
        presum[0] = 0;
        for(int i= 0; i<nums.length; i++){
            presum[i+1] = presum[i] + nums[i]; 
        }
        int res = countAndMerge(presum, lower, upper, 0, presum.length-1);
        return res;
        
    }
    int countAndMerge(long[] s, int lower, int upper, int left, int right){
        if(left>=right)
            return 0;
        int count = 0;
        int mid = left + (right-left)/2;
        count = countAndMerge(s, lower, upper, left, mid) + countAndMerge(s, lower, upper, mid+1, right);
        int i, j, k;
        i = left;
        j = k = mid+1;
        while(i<=mid){
            while(j<=right && s[j] - s[i]<lower)
                j++;
            while(k<=right && s[k] - s[i]<=upper)
                k++;
            if(j<=k)
                count += k-1-j+1;
            i++;
        }
        //System.out.print(left); System.out.print(" "); System.out.print(right); System.out.print(" "); System.out.println(count);
        i = left;
        j = mid+1;
        k = 0;
        long[] m_s = new long[right-left+1];
        while(i<=mid && j<=right){
            if(s[i]<s[j])
                m_s[k++] = s[i++];
            else
                m_s[k++] = s[j++];
        }
        while(i<=mid)
            m_s[k++] = s[i++];
        while(j<=right)
            m_s[k++] = s[j++];
        for(i = left; i<=right; i++)
            s[i] = m_s[i-left];
        return count;
    }

}
