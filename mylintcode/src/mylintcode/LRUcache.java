package mylintcode;

import java.util.HashMap;

public class LRUcache {
	public class ListNode{
        public int key;
        public int val;
        public ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
	private int capacity;
	private ListNode usedDummyHead;
	private ListNode usedTail;
	private HashMap<Integer, ListNode> preNode;
	
	public LRUcache(int capacity) {
		this.capacity = capacity;
		this.usedDummyHead = new ListNode(-1, -1);
		usedTail = usedDummyHead;
		preNode = new HashMap<Integer, ListNode>();
		
	}
	
	int get(int key) {
		if(!preNode.containsKey(key)) {
			return -1;
		}
		ListNode pre = preNode.get(key);
		ListNode cur = pre.next;
		int res = cur.val;
		if(cur.next==null)
			return res;
		pre.next = cur.next;
		preNode.put(cur.next.key, pre);
		cur.next = null;
		usedTail.next = cur;
		preNode.put(cur.key, usedTail);
		usedTail = cur;
		return res;
	}
	
	void set(int key, int value) {
		if(get(key)!=-1) {
			preNode.get(key).next.val = value;
		}
		else {
			ListNode cur = new ListNode(key, value);
			if(preNode.size()==capacity) {
				ListNode f = usedDummyHead.next;
				preNode.remove(f.key);
				usedDummyHead.next = f.next;
				if(f.next!=null)
					preNode.put(f.next.key, usedDummyHead);
				else
					usedTail = usedDummyHead;
			}
			ListNode pre;
			if(usedDummyHead.next==null) {
				pre = usedDummyHead;
			}
			else {
				pre = usedTail;
			}
			usedTail.next= cur;
			preNode.put(cur.key, pre);
			usedTail = cur;
		}
	}
	

}
