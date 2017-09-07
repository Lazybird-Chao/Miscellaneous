package amazon;

import common.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head == null)
			return null;
		ListNode pre = head;
		ListNode p = head.next;
		pre.next = null;
		while(p != null) {
			ListNode tmp = p.next;
			p.next = pre;
			pre = p;
			p = tmp;
		}
		return pre;
		
	}
	
	public ListNode method2(ListNode head) {
		if(head == null)
			return null;
		return reverse(head);
		
	}
	public ListNode reverse(ListNode head) {
		if(head.next == null) {
			return head;
		}
		ListNode newhead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newhead;	
	}

}
