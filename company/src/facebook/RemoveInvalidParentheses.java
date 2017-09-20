package facebook;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> r = new ArrayList<String>();
        if(s == null || s.isEmpty()){
            r.add("");
            return r;
        }
        int removecount = removeCount(s);
        if(removecount ==0){
            r.add(s);
            return r;
        }
        Set<String> res = new HashSet<String>();
        StringBuilder p = new StringBuilder();
        dfs(s, 0, p, removecount, 0, res);
        
        for(String item: res)
            r.add(item);
        return r;
    }
    
    int removeCount(String s){
        Stack<Integer> stack = new Stack<Integer>();
        int removecount = 0;
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    removecount++;
                else
                    stack.pop();
            }
            i++;
        }
        removecount += stack.size();
        return removecount;
    }
    
    void dfs(String s, int i, StringBuilder p, int rcount, int curcount, Set<String> res){
        if(s.length() - i < rcount - curcount)
            return;
        if(curcount == rcount){
            String tmp = p.toString() + s.substring(i, s.length());
            //System.out.println(tmp);
            if(removeCount(tmp)==0)
                res.add(tmp);
            return;
        }
        p.append(s.charAt(i));
        dfs(s, i+1, p, rcount, curcount, res);
        p.deleteCharAt(p.length()-1);
        dfs(s, i+1, p, rcount, curcount+1, res);
        return;     
    }

}
