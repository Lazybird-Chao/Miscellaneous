package mylintcode;

import java.util.Queue;

public class ImplementStackbyQueues {
	
	Queue<Integer> q1;
	Queue<Integer> q2;
	int size;
	int topele;
	boolean topvalid;
	
	
	// Push a new item into the stack
    public void push(int x) {
        // Write your code here
    	q1.offer(x);
    	size++;
    	topele = x;
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if(size==0)
            return;
    	size--;
    	int tmp =0;
    	for(int i=0; i<size; i++) {
    	    tmp = q1.poll();
    		q2.offer(tmp);
    	}
    	topele = tmp;
    	q1.poll();
    	Queue<Integer> tmpq = q1;
    	q1= q2;
    	q2 = tmpq;
    	return;
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
    	if(size==0)
    		return 0;
    	return topele;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
    	return size==0;
    }  

}
