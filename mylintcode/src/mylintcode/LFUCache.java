package mylintcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
	
	 class item{
		public int key;
		public int value;
		public int count;
		public long lifecount;
		public item(int k, int v, int c, long life) {
			key = k;
			value = v;
			count = c;
			lifecount = life;
		}
	}
	PriorityQueue<item> freqQ;
	Map<Integer, item> cache;
	int size;
	long lifecount;
	// @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
    	lifecount = 0;
    	size = capacity;
    	cache = new HashMap<Integer,item>();
    	freqQ = new PriorityQueue<item>(1, new Comparator<item>() {
    		public int compare(item A, item B) {
    			if(A.count != B.count)
    				return A.count-B.count;
    			else
    				return (int)(A.lifecount - B.lifecount);
    		}
    	});
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
    	lifecount++;
    	if(cache.containsKey(key)) {
    		item cacheitem = cache.get(key);
    		freqQ.remove(cacheitem);
    		cacheitem.count++;
    		cacheitem.lifecount = lifecount;
    		cacheitem.value = value;
    		freqQ.add(cacheitem);
    	} else {
    		if(cache.size() == size) {
    			item evictitem = freqQ.poll();
    			cache.remove(evictitem.key);	
    		} 
    		item newitem = new item(key, value, 1, lifecount);
			freqQ.add(newitem);
			cache.put(key,  newitem);		
    	}
    	return;
    }

    public int get(int key) {
        // Write your code here
    	lifecount++;
    	if(cache.containsKey(key)) {
    		item cacheitem = cache.get(key);
    		freqQ.remove(cacheitem);
    		cacheitem.count++;
    		cacheitem.lifecount = lifecount;
    		freqQ.add(cacheitem);
    		return cacheitem.value;
    	} else {
    		return -1;
    	}
    }

}
