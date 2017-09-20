package facebook;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        /*
        if(p.contains("**"))
            return false;
        char[] sA = s.toCharArray();
        char[] pA = p.toCharArray();
        int[] pos = {0, 0};
        return helper(sA, pA, pos);
        */
        return method2(s.toCharArray(), p.toCharArray());

    }
    boolean helper(char[] sA, char[] pA, int[] pos){
        int si = pos[0];
        int pi = pos[1];
        while(pi<pA.length){
            if(si == sA.length){
                if(pi+1<pA.length && pA[pi+1] == '*')
                    pi += 2;
                else
                    return false;
            } else if(pA[pi] == '.'){
                if(pi+1 >= pA.length || pA[pi+1] != '*'){
                    si++;
                    pi++;
                } else{
                    pi+= 2;
                    while(si <= sA.length){ 
                        int[] tpos = {si, pi};
                        if(helper(sA, pA, tpos))
                            return true;
                        ++si;
                    }
                    return false;
                }
            } else{
                if(pi+1 < pA.length && pA[pi+1] == '*'){
                    pi += 2;
                    while(si <= sA.length){
                        int[] tpos = {si, pi};
                        if(helper(sA, pA, tpos))
                            return true;
                        if(si < sA.length && sA[si] == pA[pi-2])
                            ++si;
                        else 
                            break;
                    }
                    return false;
                }else if(sA[si] == pA[pi]){
                    si++;
                    pi++;
                } else
                    return false;
            }
        }
        if(si == sA.length && pi == pA.length)
            return true;
        else
            return false;
    }
    
    boolean method2(char[] s, char[] p){
        int m = p.length;
        int n = s.length;
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int i=1; i<n+1; i++)
            f[0][i] = false;
        for(int i=1; i<m+1; i++){
            if(p[i-1]=='*' && i-2>=0 && p[i-2]!='*')
                f[i][0] = f[i-2][0];
            else
                f[i][0] = false;
        }
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(p[i-1]=='.'){
                    f[i][j] = f[i-1][j-1];
                }
                else if(p[i-1]=='*'){
                    if(i>=2 && p[i-2]!='*' ){
                        if(p[i-2]==s[j-1] || p[i-2] == '.')
                            f[i][j] = f[i][j-1] || f[i-1][j] || f[i-2][j];
                        else
                            f[i][j] = f[i-2][j];
                    }
                    else
                        f[i][j] = false;
                } else{
                    if(p[i-1] == s[j-1])
                        f[i][j] = f[i-1][j-1];
                    else
                        f[i][j] = false;
                }
                //System.out.print(f[i][j]+"  ");
            }
            //System.out.println();
        }
        return f[m][n];
    }

}
