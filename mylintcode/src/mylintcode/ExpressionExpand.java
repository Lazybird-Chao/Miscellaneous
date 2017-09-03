package mylintcode;

import java.util.Stack;

public class ExpressionExpand {
	public String expressionExpand(String s) {
		if(s==null || s.isEmpty())
			return "";
		StringBuilder res = new StringBuilder();
		StringBuilder partres = new StringBuilder();
		StringBuilder partCount = new StringBuilder();
		int pcount=0;
		Stack<Character> exp = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='[')
				exp.push('[');
			else if(s.charAt(i) <= '9' && s.charAt(i) >= '0')
				exp.push(s.charAt(i));
			else if(s.charAt(i) == ']') { 
				char c = exp.pop();
				while(c!='[') {
					partres.append(c);
					c = exp.pop();
				}
				c = exp.pop();
				while(c <= '9' && c>= '0') {
					partCount.append(c);
					if(exp.isEmpty())
					    break;
					c = exp.pop();
				}
				if(c<'0' || c>'9')
				    exp.push(c);
				pcount = Integer.parseInt(partCount.reverse().toString());
				partCount.setLength(0);
			}
			else {
				if(exp.isEmpty())
					res.append(s.charAt(i));
				else 
					exp.push(s.charAt(i));
			}
			
			String pstring = partres.reverse().toString();
			partres.setLength(0);
			for(int j=0; j<pcount; j++)
				partres.append(pstring);
			if(exp.isEmpty() && partres.length()!=0) {
				res.append(partres.toString());
				pcount=0;
				partres.setLength(0);
			} else {
			    for(int j=0; j<partres.length(); j++)
			        exp.push(partres.charAt(j));
			    partres.setLength(0);
			}
		}
		return res.toString();
	}

}
