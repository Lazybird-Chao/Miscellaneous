package facebook;

public class FlattenNestedListIterator {
	public class NestedIterator implements Iterator<Integer> {
	    
	    Stack<NestedInteger> sdata;
	    NestedInteger nextNI;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        sdata = new Stack<NestedInteger>();
	        for(int i = nestedList.size()-1; i>=0; i--)
	            sdata.push(nestedList.get(i));
	        nextNI = null;
	        findNext();
	    }
	    void findNext(){
	        NestedInteger cur = null;
	        while(!sdata.isEmpty()){
	            cur = sdata.pop();
	            if(!cur.isInteger()){
	                List<NestedInteger> curlist = cur.getList();
	                cur = null;
	                for(int i = curlist.size()-1; i>=0; i--){
	                    sdata.push(curlist.get(i));
	                }
	            }
	            else
	                break;
	        }
	        nextNI = cur;
	    }
	    
	    

	    @Override
	    public Integer next() {
	        int ret = nextNI.getInteger();
	        findNext();
	        return ret;     
	    }

	    @Override
	    public boolean hasNext() {
	        return nextNI != null;
	    }
	}


}
