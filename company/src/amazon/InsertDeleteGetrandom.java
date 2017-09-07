package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetrandom {
	
	int size;
	ArrayList<Integer> dataset;
	Map<Integer, Integer> posmap;
	Random randomGen;
	/** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        dataset = new ArrayList<Integer>();
        posmap = new HashMap<Integer, Integer>();   
        randomGen = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(posmap.containsKey(val))
        	return false;
        dataset.add(val);
        size++;
        posmap.put(val, size-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(posmap.containsKey(val)) {
        	int pos = posmap.get(val);
        	posmap.remove(val);
        	int replaceval = dataset.get(size-1);
        	dataset.set(pos, replaceval);
        	size--;
        	posmap.put(replaceval, pos);
        	return true;
        } 
        else
        	return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randpos = 0;
        if(size > 0)
        	randpos = randomGen.nextInt(size);
        return dataset.get(randpos);
    }
    

}
