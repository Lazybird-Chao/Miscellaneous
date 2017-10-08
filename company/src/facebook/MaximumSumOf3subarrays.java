package facebook;

public class MaximumSumOf3subarrays {
	
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k*3)
            return new int[0];
        int[] sumk = new int[nums.length];
        int tmps = 0;
        for(int i = 0; i < nums.length; i++){
            tmps += nums[i];
            if(i == k-1){
                sumk[i] = tmps;
            }else if(i > k-1){
                tmps -= nums[i-k];
                sumk[i] = tmps;
            }
            //System.out.println(sumk[i]);
        }
        int[][][] record = new int[sumk.length][4][];
        int max = sumk[sumk.length-1];
        int maxidx = sumk.length-1;
        for(int i = sumk.length-1; i >=k-1; i--){
            if(sumk[i] >= max){
                max = sumk[i];
                maxidx = i;
            }
            int[] tmp = {maxidx};
            record[i][1] = tmp;
        } 
        
        for(int i = sumk.length - k -1; i>=k-1; i--){
            if(i == sumk.length - k -1){
                max = sumk[i] + sumk[i+k];
                int[] tmp = {i, i+k};
                record[i][2] = tmp;
            } else{
                if(sumk[i] + sumk[record[i+k][1][0]] >= max){
                    max = sumk[i] + sumk[record[i+k][1][0]];
                    int[] tmp = {i, record[i+k][1][0]};
                    record[i][2] = tmp;
                } else{
                    record[i][2] = record[i+1][2];
                }
            }
        }
        
        for(int i = sumk.length - 2*k-1; i>=k-1; i--){
            if(i==sumk.length-2*k-1){
                max = sumk[i] + sumk[i+k] + sumk[i+2*k];
                int[] tmp = {i, i+k, i+2*k};
                record[i][3] = tmp;
            } else{
                int k1 = record[i+k][2][0];
                int k2 = record[i+k][2][1];
                if(sumk[i] + sumk[k1] + sumk[k2] >= max){
                    max = sumk[i] + sumk[k1] + sumk[k2];
                    int[] tmp = {i, k1, k2};
                    record[i][3] = tmp;
                }else{
                    record[i][3] = record[i+1][3];
                }
            }
        }
        
        int[] ans = record[k-1][3];
        for(int i = 0; i<ans.length; i++)
            ans[i] = ans[i] - k +1;
        return ans;
        
    }
	
	/*
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k*3)
            return new int[0];
        int[] sumk = new int[nums.length];
        int tmps = 0;
        for(int i = 0; i < nums.length; i++){
            tmps += nums[i];
            if(i == k-1){
                sumk[i] = tmps;
            }else if(i > k-1){
                tmps -= nums[i-k];
                sumk[i] = tmps;
            }
            //System.out.println(sumk[i]);
        }
        record = new int[sumk.length][4][];
        int max = sumk[sumk.length-1];
        int maxidx = sumk.length-1;
        for(int i = sumk.length-1; i >=k-1; i--){
            if(sumk[i] > max){
                max = sumk[i];
                maxidx = i;
            }
            int[] ans = {maxidx};
            record[i][1] = ans;
        } 
        
        int[] ans = helper(sumk, k-1, k, 3);
        for(int i = 0; i<ans.length; i++)
            ans[i] = ans[i] - k +1;
        return ans;
    }
    
    
    int[][][] record;
    int[] helper(int[] sumk, int index, int k, int numArrays){
        if(sumk.length - index-1 < k*(numArrays-1)){
            // System.out.print(index);
            // System.out.print(":");
            // System.out.print(numArrays);
            // System.out.print(" ");
            return new int[0];
        }
        if(record[index][numArrays] != null && record[index][numArrays].length != 0){
            return record[index][numArrays];
        }
        int max = 0;
        int[] ans = new int[numArrays];
        for(int i = index; i < sumk.length; i++){
            int curmax = sumk[i];
            int[] curans = helper(sumk, i+k, k, numArrays-1);
            for(int j =0; j<curans.length; j++)
                curmax += sumk[curans[j]];
            if(curmax > max){
                max = curmax;
                ans[0] = i;
                for(int j = 0; j<curans.length; j++)
                    ans[j+1] = curans[j];
            }
            // if(index == 3){
            //     System.out.print(curmax);
            //     System.out.print(" ");
            //     System.out.println(curans.length);
            // }
        }
        record[index][numArrays] = ans;
        return ans;
    }
    */
    

}
