package facebook;

public class AddOperator {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.isEmpty())
            return res;
        StringBuilder sb = new StringBuilder();
        helper(num.toCharArray(), 0, 0, 0, sb, target, res);
        return res;
    }
    
    void helper(char[] num, int pos, long presum, long premul, StringBuilder sb, int target, List<String> res){
        if(pos == num.length ){
            if(presum+premul == target)
                res.add(sb.toString());
            return;
        }
        int len = sb.length();
        int end = num.length;
        if(num[pos] == '0'){
            end = pos+1;
        }
        for(int i=pos; i<end; i++){
            int n = toInteger(num, pos, i);
            if(n>=0){
                if(len == 0){
                    sb.append(num, pos, i-pos+1);
                    helper(num, i+1, presum+premul, n, sb, target, res);
                    sb.setLength(len);
                } else{
                    sb.append('*');
                    sb.append(num, pos, i-pos+1);
                    helper(num, i+1, presum, premul*n, sb, target, res);
                    sb.setLength(len);

                    sb.append('+');
                    sb.append(num, pos, i-pos+1);
                    helper(num, i+1, presum+premul, n, sb, target, res);
                    sb.setLength(len);

                    sb.append('-');
                    sb.append(num, pos, i-pos+1);
                    helper(num, i+1, presum+premul, -n, sb, target, res);
                    sb.setLength(len);
                }
            } else{
                break;
            }
        }
        return;
    }
    
    int toInteger(char[] num, int start, int end){
        int n = 0;
        for(int i=start; i<=end; i++){
            if(n <= (Integer.MAX_VALUE - num[i]+'0')/10)
                n = n*10 + num[i]-'0';
            else
                return Integer.MIN_VALUE;
        }
        return n;
    }

}
