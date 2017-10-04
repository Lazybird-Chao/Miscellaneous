package facebook;

public class WildcardMatch {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        record = new int[s.length()+1][p.length()+1];
        for(int i = 0; i<=s.length(); i++)
            for(int j = 0; j<=p.length(); j++)
                record[i][j] = -1;
        return helper(s, 0, p, 0);
        
    }
    int[][] record;
    boolean helper(String S, int i, String P, int j){
        if(record[i][j] != -1)
            return record[i][j]==1? true: false;
        if(j == P.length() && i == S.length()){
            record[i][j] = 1;
            return true;
        }
        else if(j == P.length() && i < S.length()){
            record[i][j] = 0;
            return false;
        }
        else if(i == S.length() && j < P.length()){
            boolean res;
            if(P.charAt(j) == '*'){
                res = helper(S, i, P, j+1);  
            }
            else
                res = false;
            record[i][j] = res? 1: 0;
            return res;
        }
        boolean res;
        if(P.charAt(j) == '*'){
            res = helper(S, i, P, j+1) || helper(S, i+1, P, j) || helper(S, i+1, P, j+1);
        } else if(P.charAt(j) == '?'){
            res = helper(S, i+1, P, j+1);
        } else{ 
            if(P.charAt(j) == S.charAt(i)){
                res = helper(S, i+1, P, j+1);
            } else
                res = false;
        }
        record[i][j] = res? 1: 0;
        return res;
    }

}
