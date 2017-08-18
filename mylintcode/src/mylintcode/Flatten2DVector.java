package mylintcode;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {
	public class Vector2D implements Iterator<Integer> {
	
	List<List<Integer>> data;
	List<Integer> vecSizes;
	int index1;
	int index2;
	public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
		data = vec2d;
		for(int i=0; i<vec2d.size(); i++) {
			vecSizes.add(vec2d.get(i).size());
		}
		index1 = index2 = 0;
    }

    @Override
    public Integer next() {
        // Write your code here
    		int res;
    		if(index1<vecSizes.size()) {
    			res = data.get(index1).get(index2);
    		}
    		else {
    			index1=0;
    			index2=0;
    			res = data.get(index1).get(index2);
    		}
    		index2 = (index2+1)==vecSizes.get(index1)? 0:index2+1;
    		index1 = index2==0 ? index1+1 : index1;
    		return res;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
    		return index1<vecSizes.size();
    }

    @Override
    public void remove() {    }
    
	}
	
}
