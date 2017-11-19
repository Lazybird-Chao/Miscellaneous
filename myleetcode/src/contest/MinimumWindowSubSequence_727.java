package contest;

public class MinimumWindowSubSequence_727 {
	public String minWindow(String S, String T) {
        if(S == null || T == null)
            return "";
        record = new int[S.length()][T.length()];
        for(int i = 0; i< S.length(); i++)
            for(int j = 0; j<T.length(); j++)
                record[i][j] = -2;
        int start = 0;
        int end = 0;
        start = S.indexOf(T.charAt(0), 0);
        String mins = null;
        while(start != -1){
            if( 1 < T.length())
                end = helper(S, start+1, T, 1);
            else
                end = start;
            if(end != -1 && (mins == null || mins.length() > end-start+1))
                mins = S.substring(start, end+1);
            start = S.indexOf(T.charAt(0), start+1);
        }
        if(mins == null)
            return "";
        else
            return mins;       
        
    }
    int[][] record;
    int helper(String S, int i, String T, int j){
        if(i >= S.length())
            return -1;
         if(record[i][j]!=-2)
            return record[i][j];
        if(j==T.length()-1){
            int posj = S.indexOf(T.charAt(j), i);
            record[i][j] = posj;
            return posj;
        }
        int posj = S.indexOf(T.charAt(j), i);
        if(posj == -1){
            record[i][j] = -1;
            return -1;
        }else{
            return helper(S, posj+1, T, j+1);
        }
    }

}
