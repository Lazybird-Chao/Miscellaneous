package mylintcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	Map<Integer, Integer> numberRecord;
	public TwoSum(){
		numberRecord = new HashMap<Integer, Integer>();
	}
	// Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
    	if(!numberRecord.containsKey(number))
    		numberRecord.put(number, 1);
    	else
    		numberRecord.put(number, numberRecord.get(number)+1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
    	for(int num: numberRecord.keySet()){
    		if(numberRecord.containsKey(value-num)){
    		    if(value-num!=num || numberRecord.get(num)>1)
    			    return true;
    		}
    	}
    	return false;
    		
    }

}
