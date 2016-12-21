package myleetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackbyQueue {
class MyStack{
	Queue<Integer> mylistHead = new LinkedList<Integer>();
	Queue<Integer> mylistTail = new LinkedList<Integer>();
	public void push(int x){
		mylistHead.add(x);
	}
	
	public void pop(){
		while(mylistHead.size()>1){
			mylistTail.add(mylistHead.remove());
		}
		mylistHead.remove();
		Queue<Integer> tmp = mylistHead;
		mylistHead = mylistTail;
		mylistTail = tmp;
	}
	
	public int top(){
		while(mylistHead.size()>1){
			mylistTail.add(mylistHead.remove());
		}
		return mylistHead.peek();
		
	}
	
	public boolean empty(){
		return mylistHead.isEmpty();
	}
}

class method2{
	Queue<Integer> myqueue = new LinkedList<Integer>();
	public void push(int x){
		myqueue.add(x);
		int i = myqueue.size();
		while(i>1){
			myqueue.add(myqueue.poll());
		}
	}
	
	public void pop(){
		myqueue.poll();
	}
	
	public int top(){
		return myqueue.peek();
	}
	
	public boolean empty(){
		return myqueue.isEmpty();
	}
}
}
