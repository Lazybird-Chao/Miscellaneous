package contest;

public class ParseLispExpression_736 {
	public int evaluate(String expression) {
        if(expression == null || expression.length() ==0)
            return 0;
        List<Map<String,Integer>> ctxStack = new ArrayList<Map<String, Integer>>();
        int pos = 0;
        int pos_end = findExp(expression, 0);
        String exp = expression.substring(pos+1, pos_end);
        int res = expEvaluate(exp, ctxStack);
        return res;
        
    }
    int findExp(String exp, int start){
        int i = start+1;
        int count = 1;
        while(count != 0 && i<exp.length()){
            if(exp.charAt(i)=='(')
                count++;
            else if(exp.charAt(i)==')')
                count--;
            i++;
        }
        return i-1;
    }
    
    int expEvaluate(String exp, List<Map<String, Integer>> ctxStack){
        if(exp.charAt(0) == 'l')
            return expLet(exp, ctxStack);
        else
            return expAddMul(exp, ctxStack);
    }
    int expLet(String exp, List<Map<String, Integer>> ctxStack){
        Map<String, Integer> ctxcur = new HashMap<String, Integer>();
        int pos = exp.indexOf(' ', 0);
        String var = "";
        int value = 0;
        pos++;
        while(pos<exp.length()){
            if(exp.charAt(pos) == '(')
                break;
            int pos_end = exp.indexOf(' ', pos);
            if(pos_end == -1)
                break;
            //System.out.println(pos_end);
            var = exp.substring(pos, pos_end);
            //System.out.println(exp);
            pos = pos_end+1;
            if(exp.charAt(pos)=='('){
                pos_end = findExp(exp, pos);
                String subexp1 = exp.substring(pos+1, pos_end);
                ctxStack.add(ctxcur);
                value = expEvaluate(subexp1, ctxStack);
                ctxStack.remove(ctxStack.size()-1);
                pos = pos_end+1;
            }else{
                pos_end = exp.indexOf(' ', pos);
                String subs = exp.substring(pos, pos_end);
                if((subs.charAt(0) >='0' && subs.charAt(0)<='9') || (subs.charAt(0)=='-'))
                    value = Integer.parseInt(subs);
                else{
                    if(ctxcur.containsKey(subs))
                        value = ctxcur.get(subs);
                    else{
                        for(int i = ctxStack.size()-1; i>=0; i--){
                            if(ctxStack.get(i).containsKey(subs)){
                                value = ctxStack.get(i).get(subs);
                                break;
                            }
                        }
                    }
                }
                pos = pos_end;
            }
            ctxcur.put(var, value);
            pos++;
        }
        
        if(exp.charAt(pos)=='('){
            int pos_end = findExp(exp, pos);
            String subexp1 = exp.substring(pos+1, pos_end);
            ctxStack.add(ctxcur);
            value = expEvaluate(subexp1, ctxStack);
            ctxStack.remove(ctxStack.size()-1);
            return value;
        }else{
            String subs = exp.substring(pos);
            if((subs.charAt(0) >='0' && subs.charAt(0)<='9') || (subs.charAt(0)=='-'))
                value = Integer.parseInt(subs);
            else{
                if(ctxcur.containsKey(subs))
                    value = ctxcur.get(subs);
                else{
                    for(int i = ctxStack.size()-1; i>=0; i--){
                        if(ctxStack.get(i).containsKey(subs)){
                            value = ctxStack.get(i).get(subs);
                            break;
                        }
                    }
                }
            }
            return value;
        }
    }
    int expAddMul(String exp, List<Map<String, Integer>> ctxStack){      
        int oprand1 = 0;
        int oprand2 = 0;
        int pos = exp.indexOf(' ', 0);
        pos++;
        if(exp.charAt(pos)=='('){
            int pos_end = findExp(exp, pos);
            String subexp1 = exp.substring(pos+1, pos_end);
            oprand1 = expEvaluate(subexp1, ctxStack);
            pos = pos_end+1;
        }else{
            int pos_end = exp.indexOf(' ', pos);
            String subs = exp.substring(pos, pos_end);
            if((subs.charAt(0) >='0' && subs.charAt(0)<='9') || (subs.charAt(0)=='-'))
                oprand1 = Integer.parseInt(subs);
            else{
                for(int i = ctxStack.size()-1; i>=0; i--){
                    if(ctxStack.get(i).containsKey(subs)){
                        oprand1 = ctxStack.get(i).get(subs);
                        break;
                    }
                }
            }
            pos = pos_end;
        }
        
        pos++;
        if(exp.charAt(pos)=='('){
            int pos_end = findExp(exp, pos);
            String subexp1 = exp.substring(pos+1, pos_end);
            oprand2 = expEvaluate(subexp1, ctxStack);
            pos = pos_end+1;
        }else{
            String subs = exp.substring(pos);
            //System.out.println(subs);
            if((subs.charAt(0) >='0' && subs.charAt(0)<='9') || (subs.charAt(0)=='-')) 
                oprand2 = Integer.parseInt(subs);
            else{
                for(int i = ctxStack.size()-1; i>=0; i--){
                    if(ctxStack.get(i).containsKey(subs)){
                        oprand2 = ctxStack.get(i).get(subs);
                        break;
                    }
                }
            }
        }
        //System.out.println(oprand1);
        //System.out.println(oprand2);
        if(exp.charAt(0) == 'a')
            return oprand1 + oprand2;
        else
            return oprand1 * oprand2;
        
    }

}
