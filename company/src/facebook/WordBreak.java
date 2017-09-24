package facebook;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null)
            return false;
        if(s.isEmpty())
            return true;
        else if(wordDict.isEmpty())
            return false;
        Set<String> dict = new HashSet<String>();
        for(String w : wordDict)
            dict.add(w);
        boolean[][] f = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                f[i][j] = false;
                if(dict.contains(s.substring(i,j+1))){
                    f[i][j] = true;
                }else{
                    for(int k = i; k < j; k++){
                        if(f[i][k] && f[k+1][j]){
                            f[i][j] = true;
                            break;
                        }
                    }            
                }
                //System.out.print(f[i][j]+" ");
            }
            //System.out.println();
        }
        return f[0][s.length()-1];
        
        return method2(s, wordDict);
    }
    
    public boolean method2(String s, List<String> wordDict) {
        if(s == null || wordDict == null)
            return false;
        if(s.isEmpty())
            return true;
        else if(wordDict.isEmpty())
            return false;
        Set<String> dict = new HashSet<String>();
        for(String w : wordDict)
            dict.add(w);
        boolean[] f = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(dict.contains(s.substring(0, i+1)))
                f[i] = true;
            if(f[i]){
                for(int j = i+1; j<s.length(); j++){
                    if(dict.contains(s.substring(i+1, j+1)))
                        f[j] = true;
                }
            }
        }
        return f[s.length()-1];
    }

}
