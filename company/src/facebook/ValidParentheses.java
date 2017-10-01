package facebook;

public class ValidParentheses {
	public boolean isValid(String s) {
        if(s == null)
            return false;
        if(s.isEmpty())
            return true;
        char[] sa = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < sa.length; i++){
            if(sa[i] == '(' || sa[i] == '{' || sa[i] == '[')
                stack.push(sa[i]);
            else if(sa[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            } else if(sa[i] == '}'){
                if(stack.isEmpty() || stack.peek() != '{')
                    return false;
                stack.pop();
            } else{
                if(stack.isEmpty() || stack.peek() != '[')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
