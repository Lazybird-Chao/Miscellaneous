package mylintcode;

import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
	public class NestedIterator implements Iterator<Integer> {

		List<NestedInteger> nestedList;
		Stack<List<NestedInteger>> nextStack;
		List<NestedInteger> nextNestedList;
		Stack<Integer> indexStack;
		int index;
		NestedInteger curNestedInteger;
		
	    public NestedIterator(List<NestedInteger> nestedList) {
	        // Initialize your data structure here.
	    	this.nestedList = nestedList;
	    	nextStack = new Stack<List<NestedInteger>>();
	    	indexStack = new Stack<Integer>();
	    	nextNestedList = nestedList;
	    	index = 0;
	    	curNestedInteger = null;
	    	
	    }

	    // @return {int} the next element in the iteration
	    @Override
	    public Integer next() {
	        // Write your code here
	    	if(curNestedInteger == null && hasNext()==false)
	    		return null;
	    	Integer res = curNestedInteger.getInteger();
	    	index++;
	    	curNestedInteger = null;
	    	return res;
	    	
	    	
	    	
	    }

	    // @return {boolean} true if the iteration has more element or false
	    @Override
	    public boolean hasNext() {
	        // Write your code here
	    	while(nextNestedList!=null && (index < nextNestedList.size() || (!nextStack.isEmpty()))) {
	    		curNestedInteger = null;
	    		if(index < nextNestedList.size()) {
	    			curNestedInteger = nextNestedList.get(index);
	    			if(curNestedInteger.isInteger())
	    				break;
	    			else {
	    				nextStack.push(nextNestedList);
		    			indexStack.push(index+1);
		    			nextNestedList = cur.getList();
		    			index = 0;
	    			}
	    		} else {
	    			nextNestedList = nextStack.pop();
	    			index = indexStac.pop();
	    		}
	    	}
	    	if(curNestedInteger == null)
	    		return false;
	    	else
	    		return true;
	    }

	    @Override
	    public void remove() {}
	}

}
