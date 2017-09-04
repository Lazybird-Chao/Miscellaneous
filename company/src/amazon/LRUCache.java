package amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private int cacheSize;
	public class Item{
		int key;
		int value;
		Item next;
		public Item(int k, int v) {
			key = k;
			value = v;
			next = null;
		}
	}
	Map<Integer, Item> cache;
	Item head;
	Item tail;
	
	public LRUCache(int capacity) {
        cacheSize = capacity;
        cache = new HashMap<Integer, Item>();
        head = new Item(-1,-1);
        tail = head;
    }
    
    public int get(int key) {
    	int res;
        if(cache.containsKey(key)) {
        	Item itemPre = cache.get(key);
        	Item item = itemPre.next;
        	res = item.value;
        	if(!item.equals(tail)) {
	        	itemPre.next = item.next;
	        	cache.put(item.next.key, itemPre);
	        	cache.put(key, tail);
	        	tail.next = item;
	        	tail = item;
	        	tail.next = null;
        	}
        } else {
        	res = -1;
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
        	Item itemPre = cache.get(key);
        	Item item = itemPre.next;
        	item.value = value;
        	if(!item.equals(tail)) {
	        	itemPre.next = item.next;
	        	cache.put(item.next.key, itemPre);
	        	cache.put(key, tail);
	        	tail.next = item;
	        	tail = item;
	        	tail.next = null;
        	}
        } else {
        	if(cache.size() == cacheSize) {
        		Item old = head.next;
        		cache.remove(old.key);
        		if(!old.equals(tail)) {
        			cache.put(old.next.key, head);
        			head.next = old.next;
        		} else {
        			tail = head;
        			head.next = null;
        		}
        	}
    		Item newitem = new Item(key, value);
    		tail.next = newitem;
    		cache.put(key, tail);
    		tail = tail.next;	
        }
        return;
    }

}
