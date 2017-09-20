package facebook;

public class LetterCombineOfPhoneNumber {
	public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.isEmpty())
            return res;
        if(digits.contains("0") || digits.contains("1"))
            return res;
        char[][] digitmap = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
                    {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        StringBuilder sb = new StringBuilder();
        dfs(digits.toCharArray(), digitmap, 0, sb, res);
        return res;
    }
    
    void dfs(char[] digits, char[][] digitmap, int curpos, StringBuilder sb, List<String> res){
        if(curpos == digits.length){
            res.add(sb.toString());
            return;
        }
        if(digits[curpos] == '0' || digits[curpos] == '1'){
            //dfs(digits, digitmap, curpos+1, sb, res);
            return;
        }
        int idx = digits[curpos]-'0';
        for(int i=0; i<digitmap[idx].length; i++){
            sb.append(digitmap[idx][i]);
            dfs(digits, digitmap, curpos+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    
    }

}
