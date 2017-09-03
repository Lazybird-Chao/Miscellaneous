package mylintcode;

import java.util.ArrayList;

public class ZigzagIterator2 {
	
	ArrayList<ArrayList<Integer>> vecs;
	int[] size;
	int listIndex;
	int[] nextIndex;
	int numVecs;
	public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
		this.vecs = vecs;
		numVecs = vecs.size();
		size = new int[numVecs];
		listIndex = -1;
		nextIndex = new int[numVecs];
		for(int i=0; i<numVecs; i++) {
			size[i] = vecs.get(i).size();
			nextIndex[i] = 0;
			if(listIndex < 0 && size[i] > 0)
				listIndex = i;
		}
    }

    public int next() {
        // Write your code here
    	if(nextIndex[listIndex] >= size[listIndex])
    		return -1;
    	int tmp = vecs.get(listIndex).get(nextIndex[listIndex]);
    	nextIndex[listIndex]++;
    	int tmpl = listIndex;
    	listIndex = (listIndex+1)%numVecs;
    	while(nextIndex[listIndex]>=size[listIndex] && listIndex!=tmpl)
    		listIndex = (listIndex+1)%numVecs;
    	return tmp;
    }

    public boolean hasNext() {
        // Write your code here   
    	return listIndex>=0 && nextIndex[listIndex] < size[listIndex];
    }
    

}
