package mylintcode;

import java.util.List;

public class ZigzagIterator {
	
	private int[] nextIndex;
	private int listIndex;
	private int[] size;
	private List<Integer>[] v;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
		v = (List<Integer>[]) new List[2];
		v[0] = v1;
		v[1] = v2;
		size = new int[2];
		size[0] = v1.size();
		size[1] = v2.size();
		nextIndex = new int[2];
		nextIndex[0] = nextIndex[1] = 0;
		if(v1.isEmpty() && (!v2.isEmpty()))
			listIndex = 1;
		else
			listIndex = 0;
		
    }

    public int next() {
        // Write your code here
    	if(nextIndex[listIndex] >= size[listIndex])
    		return -1;
    	int tmp = v[listIndex].get(nextIndex[listIndex]);
    	nextIndex[listIndex]++;
    	listIndex ^= 1;
    	if(nextIndex[listIndex] >= size[listIndex])
    		listIndex ^= 1;
    	return tmp;
    }

    public boolean hasNext() {
        // Write your code here  
    	return nextIndex[listIndex] < size[listIndex];
    	
    }

}
