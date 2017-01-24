package myleetcode;

import java.util.Stack;;

public class MinStack {
	int min_value;
	Stack<Integer> value_stack;
	
	public MinStack(){
		min_value = Integer.MAX_VALUE;
		value_stack = new Stack<Integer>();
	}
	
	public void push(int x){
		if(value_stack.isEmpty()){
			min_value = x;
			value_stack.push(x);
		}
		else{
			if(x<=min_value){
				value_stack.push(min_value);
				min_value = x;
			}
			value_stack.push(x);
		}
	}
	
	public void pop(){
		if(value_stack.peek()==min_value){
			value_stack.pop();
			min_value = value_stack.empty()==true?min_value:value_stack.pop();
		}
		else
			value_stack.pop();
	}
	
	public int top(){
		return value_stack.peek();
	}
	
	public int getMin(){
		return min_value;
	}
	
	
	public class method2{
		int min_value;
		Stack<Integer> value_stack;
		
		public MinStack(){
			min_value = Integer.MAX_VALUE;
			value_stack = new Stack<Integer>();
		}
		
		public void push(int x){
			if(value_stack.empty()){
				min_value = x;
			}
			
			value_stack.push(x-min_value);
			if(x<min_value)
				min_value = x;
			
		}
		
		public void pop(){
			int tmp = value_stack.pop();
			if(tmp<0)
				min_value = min_value - tmp;
		}
		
		public int top(){
			int tmp = value_stack.peek();
			if(tmp<0)
				return min_value;
			else
				return min_value + tmp;
		}
		
		public int getMin(){
			return min_value;
		}
	}
}
