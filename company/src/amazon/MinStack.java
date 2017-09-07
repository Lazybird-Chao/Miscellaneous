package amazon;

import java.util.Stack;

public class MinStack {
	Stack<Integer> sdata;
	Stack<Integer> smin;
	/** initialize your data structure here. */
    public MinStack() {
        sdata = new Stack<Integer>();
        smin = new Stack<Integer>();
    }
    
    public void push(int x) {
        sdata.push(x);
        if(smin.isEmpty() || x<=smin.peek())
        	smin.push(x);
    }
    
    public void pop() {
    	int i = sdata.pop();
        if(!smin.isEmpty() && i==smin.peek())
        	smin.pop();
    }
    
    public int top() {
        return sdata.peek();
    }
    
    public int getMin() {
        return smin.peek();
    }


}
