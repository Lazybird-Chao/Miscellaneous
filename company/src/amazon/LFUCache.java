package amazon;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
		
	class Item{
		int key;
		int value;
		int freq;
		Item next;
		Item pre;
		Bucket bucket;
		public Item(int k, int v, int f) {
			key = k;
			value = v;
			freq = f;
			next = pre = null;
			bucket = null;
		}
	}
	class Bucket{
		Item head;
		Item tail;
		int freq;
		Bucket next;
		Bucket pre;
		public Bucket(int f) {
			freq = f;
			head = tail = null;
			next = pre = null;
		}
	}
	Map<Integer, Item> cache;
	int cacheSize;
	Bucket BucketListHead;
	Bucket BucketListTail;
	
 	public LFUCache(int capacity) {
        cacheSize = capacity;
        BucketListHead = new Bucket(0);
        BucketListTail = BucketListHead;
        cache = new HashMap<Integer, Item>();
    }
    
    public int get(int key) {
    	if(!cache.containsKey(key)) {
    		System.out.println(-1);
    		return -1;
    	}
    	Item curItem = accessItem(key);
    	System.out.println(curItem.value);
    	return curItem.value;	
        
    }
    
    public void put(int key, int value) {
    	if(cache.containsKey(key)) {
    		Item curItem = accessItem(key);
    		curItem.value = value;
    	} else {
    		Item newItem = new Item(key, value, 1);
    		cache.put(key,  newItem);
    		
			Bucket curLeastBucket = BucketListHead.next;
			if(curLeastBucket != null && curLeastBucket.freq == 1) {
				Item nextTail = curLeastBucket.tail;
	    		nextTail.next = newItem;
	    		newItem.next = null;
	    		newItem.pre = nextTail;
	    		newItem.bucket = curLeastBucket;
	    		curLeastBucket.tail = newItem;
	    		
			} else {
				Bucket newBucket = new Bucket(1);
	    		newBucket.head = new Item(0, 0, 1);
	    		newBucket.tail = newBucket.head;
	    		newBucket.head.bucket = newBucket;
	    		newBucket.next = BucketListHead.next;
	    		newBucket.pre = BucketListHead;
	    		if(BucketListHead.next == null)
	    			BucketListTail = newBucket;
	    		else
	    			BucketListHead.next.pre = newBucket;
	    		BucketListHead.next = newBucket;
	    		newBucket.tail.next = newItem;
	    		newItem.pre = newBucket.tail;
	    		newItem.next = null;
	    		newItem.bucket = newBucket;
	    		newBucket.tail = newItem;
			}
			if(cache.size() > cacheSize) {
				curLeastBucket = BucketListHead.next;
				if(curLeastBucket.head.next == newItem && cacheSize>0) {
					curLeastBucket = curLeastBucket.next;
				}
				Item delItem = curLeastBucket.head.next;
				cache.remove(delItem.key);
				curLeastBucket.head.next = delItem.next;
				if(delItem.next != null)
					delItem.next.pre = curLeastBucket.head;
				else {
					Bucket pre = curLeastBucket.pre;
					pre.next = curLeastBucket.next;
					if(curLeastBucket.next != null)
						curLeastBucket.next.pre = pre;
					else
						BucketListTail = pre;
					curLeastBucket.next  = curLeastBucket.pre = null;
					curLeastBucket.head = curLeastBucket.tail = null;
				}
				delItem.next = delItem.pre = null;
				delItem.bucket = null;
			}
    		
    	}
    	System.out.println("NULL");
        return;
    }
    
    Item accessItem(int key) {
    	Item curItem = cache.get(key);
    	Bucket curBucket = curItem.bucket;
    	curItem.pre.next = curItem.next;
    	if(curItem.next != null) {
    		curItem.next.pre = curItem.pre;
    	} else {
    		curBucket.tail = curItem.pre;
    		if(curBucket.tail == curBucket.head) {
    			Bucket pre = curBucket.pre;
    			pre.next = curBucket.next;
    			if(curBucket.next != null)
    				curBucket.next.pre = pre;
    			curBucket.next = curBucket.pre = null;
    			curBucket.head = curBucket.tail = null;
    			curBucket = pre;
    		}
    	}
    	curItem.freq++;
    	if(curBucket.next != null && curBucket.next.freq == curItem.freq) {
    		Item nextTail = curBucket.next.tail;
    		nextTail.next = curItem;
    		curItem.next = null;
    		curItem.pre = nextTail;
    		curBucket.next.tail = curItem;
    		curItem.bucket = curBucket.next;
    	} else {
    		Bucket newBucket = new Bucket(curItem.freq);
    		newBucket.head = new Item(0, 0, curItem.freq);
    		newBucket.tail = newBucket.head;
    		newBucket.head.bucket = newBucket;
    		newBucket.next = curBucket.next;
    		newBucket.pre = curBucket;
    		if(curBucket.next == null)
    			BucketListTail = newBucket;
    		else
    			curBucket.next.pre = newBucket;
    		curBucket.next = newBucket;
    		newBucket.tail.next = curItem;
    		curItem.next = null;
    		curItem.pre = newBucket.tail;
    		newBucket.tail = curItem;
    		curItem.bucket = newBucket;
    	}
    	return curItem;
    }
	    
    public static void main(String args[]) {
    	/*LFUCache test = new LFUCache(2);
    	test.put(1,1);
    	test.put(2,2);
    	test.get(1);
    	test.put(3,3);
    	test.get(2);
    	test.get(3);
    	test.put(4, 4);
    	test.get(1);
    	test.get(3);
    	test.get(4);
    	*/
    	
    	LFUCache test = new LFUCache(0);
    	test.put(1,1);
    	test.get(1);
    	
    }
}
