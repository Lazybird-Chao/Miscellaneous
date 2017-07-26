package mylintcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
	public ListNode mergeKLists(List<ListNode> lists) { 
		if(lists==null || lists.size()==0)
			return null;
		Queue<ListNode> minQ = new PriorityQueue<ListNode>(lists.size(), 
				new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
		
		for(int i=0; i<lists.size(); i++) {
			if(lists.get(i)!=null)
				minQ.add(lists.get(i));
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(minQ.isEmpty()==false) {
			ListNode cur = minQ.poll();
			if(cur.next!=null)
				minQ.add(cur.next);
			p.next = cur;
			p= p.next;	
		}
		return head.next;
		
		
	}

}
