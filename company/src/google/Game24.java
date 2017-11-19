package google;

public class Game24 {
	 /*
    public boolean judgePoint24(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        
        boolean[] used = new boolean[4];
        char[] ops = {'+', '-', '*', '/'};
        List<RealNum> exp = new ArrayList<RealNum>();
        return helper(nums, used, exp);
        
    }
    class RealNum{
        int numerator;
        int denormitor;
        char c;
        public RealNum(int n, int d){
            numerator = n;
            denormitor = d;
            c = '#';
        }
        public RealNum(char c){
            this.c = c;
        }
    }
    boolean helper(int[] nums, boolean[] used, List<RealNum> expression){
        char[] ops = {'+', '-', '*', '/'};
        if(expression.size() == 7){
            return evaluate(expression);
        }
        for(int i =0; i<4; i++){
            if(used[i] == false){
                used[i] = true;
                expression.add(new RealNum(nums[i], 1));
                if(helper(nums, used, expression))
                    return true;
                used[i] = false;
                expression.remove(expression.size()-1);
            }
        }
        for(int i = 0; i<4; i++){
            expression.add(new RealNum(ops[i]));
            if(helper(nums, used, expression))
                return true;
            expression.remove(expression.size()-1);
        }
        return false;
    }
    
    boolean evaluate(List<RealNum> exp){
        Stack<RealNum> stack = new Stack();
        for(int i = 0; i<exp.size(); i++){
            RealNum tmp = exp.get(i);
            if(tmp.c != '#'){
                RealNum a = null;
                RealNum b = null;
                if(!stack.isEmpty())
                    a = stack.pop();
                else
                    return false;
                if(!stack.isEmpty())
                    b = stack.pop();
                else
                    return false;
                if(tmp.c == '+')
                    stack.push(new RealNum(a.numerator*b.denormitor + a.denormitor*b.numerator, a.denormitor*b.denormitor));
                else if(tmp.c == '-')
                    stack.push(new RealNum(a.numerator*b.denormitor - a.denormitor*b.numerator, a.denormitor*b.denormitor));
                else if(tmp.c == '*')
                    stack.push(new RealNum(a.numerator*b.numerator, a.denormitor*b.denormitor));
                else if(tmp.c == '/'){
                    if(b.denormitor == 0)
                        return false;
                    else
                        stack.push(new RealNum(a.numerator*b.denormitor, a.denormitor*b.numerator));
                }
            }else
                stack.push(tmp);         
        }
        if(stack.size() != 1)
            return false;
        else{
            RealNum res = stack.pop();
            if(res.c == '#' && res.denormitor != 0 && res.numerator % res.denormitor == 0 && res.numerator / res.denormitor == 24)
                return true;
            else
                return false;
        }
    }
    */
    public boolean judgePoint24(int[] nums) {
        return f(new double[] {nums[0], nums[1], nums[2], nums[3]});
    }
    
    private boolean f(double[] a) {
        if (a.length == 1) {
            return Math.abs(a[0]-24)<0.0001;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, l = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[l++] = a[k];
                    }
                }
                for (double k : compute(a[i], a[j])) {
                    b[a.length - 2] = k;
                    if (f(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private double[] compute(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
    }
    

}
