package contest;

public class NumberOfAtoms_726 {
	public String countOfAtoms(String formula) {
        if(formula == null || formula.length() ==0)
            return "";
        Stack<String> stack = new Stack<String>();
        char[] fm = formula.toCharArray();
        int i = 0;
        int ns = 0;
        int ne = 0;
        while(i < fm.length){
            if(fm[i] >= 'A' && fm[i] <='Z'){
                ns = i;
                i++;
                while(i < fm.length){
                    if(!(fm[i] >= 'a' && fm[i] <='z'))
                        break;
                    i++;
                }
                ne = i-1;
                stack.push(new String(formula.substring(ns, ne+1)));
                //System.out.println(stack.peek());
            } else if(fm[i] >='0' && fm[i] <='9'){
                ns = i;
                i++;
                while(i < fm.length){
                    if(!(fm[i] >='0' && fm[i] <='9'))
                        break;
                    i++;
                }
                ne = i-1;
                stack.push(new String(formula.substring(ns, ne+1)));
                //System.out.println(stack.peek());
            }else if(fm[i] == '('){
                stack.push("(");
                i++;
            }else if(fm[i] == ')'){
                List<String> tmp = new ArrayList<String>();
                while(!stack.peek().equals("("))
                    tmp.add(stack.pop());
                stack.pop();
                i++;
                if(fm[i] >='0' && fm[i] <='9'){
                    ns = i;
                    i++;
                    while(i < fm.length){
                        if(!(fm[i] >='0' && fm[i] <='9'))
                            break;
                        i++;
                    }
                    ne = i-1;
                    int count = Integer.parseInt(formula.substring(ns, ne+1));
                    int j = 0;
                    while(j < tmp.size()){
                        String name = tmp.get(j);
                        if(name.charAt(0) >='0' && name.charAt(0) <= '9'){
                            name = String.valueOf(Integer.parseInt(name)*count);
                            j++;
                            stack.push(tmp.get(j));
                            stack.push(name);
                            j++;
                        }else{
                            stack.push(name);
                            stack.push(String.valueOf(count));
                            j++;
                        }
                    }
                        
                }else{
                    for(int j = tmp.size()-1; j>=0; j--){
                        stack.push(tmp.get(j));
                    }
                } 
            }
        }
        
        Map<String, Integer> smap = new HashMap<String, Integer>();
        while(!stack.isEmpty()){
            String tmp = stack.pop();
            //System.out.println(tmp);
            if(tmp.charAt(0) >='0' && tmp.charAt(0) <='9'){
                int count = Integer.parseInt(tmp);
                String name = stack.pop();
                if(smap.containsKey(name))
                    smap.put(name, smap.get(name)+count);
                else
                    smap.put(name, count);
            }else{
                if(smap.containsKey(tmp))
                    smap.put(tmp, smap.get(tmp)+1);
                else
                    smap.put(tmp, 1);
            }
        }
        String[] res = new String[smap.size()];
        int j = 0;
        for(String key: smap.keySet())
            res[j++] = key;
        Arrays.sort(res);
        StringBuilder sb = new StringBuilder();
        for(j = 0; j<res.length; j++){
            sb.append(res[j]);
            int count = smap.get(res[j]);
            if(count > 1)
                sb.append(String.valueOf(count));
        }
        return sb.toString();
        
    }

}
