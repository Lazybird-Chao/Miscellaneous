package google;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
        if(n<1)
            return new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        helper(n, n, sb, res);
        return res;
        
    }
    void helper(int left, int right, StringBuilder sb, List<String> res){
        if(left == 0 && right ==0){
            res.add(new String(sb));
            return;
        }
        if(left > right)
            return;
        if(left>0){
            sb.append('(');
            helper(left-1, right, sb, res);
            sb.setLength(sb.length()-1);
        }
        if(right >0){
            sb.append(')');
            helper(left, right-1, sb, res);
            sb.setLength(sb.length()-1);
        }
        return;
    }

}
