package google;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if(s==null || p ==null)
            return false;
        if(s.isEmpty() && p.isEmpty())
            return true;
        else if(p.isEmpty())
            return false;
        if(p.charAt(0)=='*' || p.contains("**"))
            return false;
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        boolean[][] f = new boolean[sa.length+1][pa.length+1];
        f[0][0] = true;
        for(int i =0; i<=sa.length; i++){
            //if(i>0)
               // System.out.print(sa[i-1]);System.out.print(":");
            for(int j=1; j<=pa.length; j++){
                if(pa[j-1] == '*'){
                    if(i>0 && (pa[j-2] == '.' || sa[i-1] == pa[j-2])){
                        if(f[i-1][j] || f[i-1][j-1] || (j>1 && f[i-1][j-2])){
                            f[i][j] = true;
                            continue;
                        }
                    } 
                    if(f[i][j-1] || (j>1 && f[i][j-2]))
                        f[i][j] = true;
                }else if(pa[j-1] == '.'){
                    if(i>0 && f[i-1][j-1])
                        f[i][j] = true;
                }else if(i>0 && f[i-1][j-1] && sa[i-1] == pa[j-1])
                    f[i][j] = true;
                //System.out.print(f[i][j]);System.out.print(" ");
            }
            //System.out.println();
        }
        
        return f[sa.length][pa.length];
    }

}
