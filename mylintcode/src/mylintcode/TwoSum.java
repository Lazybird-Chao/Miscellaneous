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
    
    public int[] twoSum(int[] numbers, int target) {
    	if(numbers==null || numbers.length==0)
    		return new int[0];
    	Map<Integer, Integer> records = new HashMap<Integer, Integer>();
    	int[] res = new int[2];
    	for(int i=0; i<numbers.length; i++) {
    		if(records.containsKey(numbers[i])) {
    			res[0] = records.get(numbers[i])+1;
    			res[1] = i+1;
    			break;
    		}
    		else
    			records.put(target-numbers[i], i);
    	}
    	return res;
    }

}
