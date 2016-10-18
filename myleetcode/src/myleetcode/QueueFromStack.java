package myleetcode;

import java.util.Stack;

public class QueueFromStack {
	Stack<Integer> myStack;
	public QueueFromStack(){
		myStack= new Stack<Integer>();
	}
	public void push(int x){
		Stack<Integer> tmp = new Stack<Integer>();
		while(myStack.empty()==false){
			tmp.push(myStack.pop());
		}
		myStack.push(x);
		while(tmp.empty()==false)
			myStack.push(tmp.pop());
	}
	
	public void pop(){
		myStack.pop();
	}
	
	public int peek(){
		return myStack.peek();
	}
	
	public boolean empty(){
		return myStack.empty();
	}
	
	
	// another method of using two stacks:
	
}


