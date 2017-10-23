package contest;

public class MinDeleSumForTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
        if(s1 == null || s1.isEmpty())
            return 0;
        if(s2 == null || s2.isEmpty())
            return 0;
        record = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i<=s1.length(); i++)
            for(int j = 0; j<=s2.length(); j++)
                record[i][j] = -1;
        helper(s1.toCharArray(), 0, s2.toCharArray(), 0);
        return record[0][0];
        
    }
    
    int[][] record;
    int helper(char[] s1, int idx1, char[] s2, int idx2){
        if(idx1 == s1.length && idx2 == s2.length)
            return 0;
        if(record[idx1][idx2] != -1)
            return record[idx1][idx2];
        if(idx1 == s1.length){
            int sum = 0;
            for(int i = idx2; i < s2.length; i++)
                sum += s2[i];
            record[idx1][idx2] = sum;
            return sum;
        }else if(idx2 == s2.length){
            int sum = 0;
            for(int i = idx1; i<s1.length; i++)
                sum += s1[i];
            record[idx1][idx2] = sum;
            return sum;
        }
        
        int curmin = 0;
        curmin = s1[idx1] + helper(s1, idx1+1, s2, idx2);
        curmin = Math.min(curmin, s2[idx2]+helper(s1, idx1, s2, idx2+1));
        if(s1[idx1]==s2[idx2])
            curmin = Math.min(curmin, helper(s1, idx1+1, s2, idx2+1));
        record[idx1][idx2] = curmin;
        return curmin; 
    }

}
