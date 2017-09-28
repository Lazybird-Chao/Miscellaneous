package facebook;

class LRUCache {

    class cacheLine{
        int value;
        int key;
        cacheLine next;
        public cacheLine(int k, int v){
            value = v;
            next = null;
            key = k;
        }
    }
    Map<Integer, cacheLine> cache;
    int capacity;
    cacheLine head;
    cacheLine tail;
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, cacheLine>();
        this.capacity = capacity;
        head = new cacheLine(-1, -1);
        tail = head;
    }
    
    public int get(int key) {
        int res = -1;
        if(!cache.isEmpty() && cache.containsKey(key)){
            cacheLine pre = cache.get(key);
            res = pre.next.value;
            cacheLine cur = pre.next;
            if(cur != tail){      ////////////////////////// notice
                pre.next = cur.next;
                cache.put(pre.next.key, pre);    ////////////////////////// notice
                cur.next = null;
                tail.next = cur;
                cache.put(key, tail);
                tail = cur;
            }
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(capacity == 0)
            return;
        if(cache.containsKey(key)){
            cacheLine pre = cache.get(key);
            cacheLine cur = pre.next;
            cur.value = value;
            if(cur != tail){    ////////////////////////// notice
                pre.next = cur.next;
                cache.put(pre.next.key, pre);  ////////////////////////// notice
                cur.next = null;
                tail.next = cur;
                cache.put(key, tail);
                tail = cur;
            }
        }
        else{
            cacheLine item = new cacheLine(key, value);
            if(cache.size() < capacity){
                tail.next = item;
                cache.put(key, tail);
                tail = item;
            } else{  
                int toremove = head.next.key;
                cache.remove(toremove);      ////////////////////////// notice
                if( head.next != tail){      ////////////////////////// notice
                    head.next = head.next.next;
                    cache.put(head.next.key, head);
                } else {
                    head.next = null;
                    tail = head;
                }
                tail.next = item;
                cache.put(key, tail);
                tail = item;
            }
        }
        return;
        
    }
}
