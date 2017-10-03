package facebook;

public class InsertDelGetrandom1 {
	class RandomizedSet{
	    ArrayList<Integer> data;
	    Map<Integer, Integer> posmap;
	    Random randGen;
	/** Initialize your data structure here. */
	    public RandomizedSet() {
	        data = new ArrayList<Integer>();
	        posmap = new HashMap<Integer, Integer>();
	        randGen = new Random();
	    }

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(posmap.containsKey(val))
	            return false;
	        data.add(val);
	        posmap.put(val, data.size()-1);
	        return true;
	    }

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!posmap.containsKey(val))
	            return false;
	        int pos = posmap.get(val);
	        posmap.remove(val);
	        if(pos == data.size()-1)
	            data.remove(pos);
	        else{
	            data.set(pos, data.get(data.size()-1));
	            data.remove(data.size()-1);
	            posmap.put(data.get(pos), pos);
	        }
	        return true;
	    }

	/** Get a random element from the set. */
	    public int getRandom() {
	        if(data.size()>0){
	            int randn = randGen.nextInt(data.size());
	            return data.get(randn);
	        } else
	            return -1;
	        
	    }
	}


}
