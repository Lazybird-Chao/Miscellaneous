package amazon;

import common.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null)
			return null;
		int carry = 0;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(p1!=null && p2!=null) {
			ListNode tmp = new ListNode((p1.val + p2.val + carry)%10);
			p.next = tmp;
			p= tmp;
			carry = (p1.val + p2.val + carry)/10;
			p1 = p1.next;
			p2 = p2.next;
		}
		if(p1 == null)
			p1 = p2;
		while(p1!=null) {
			ListNode tmp = new ListNode((p1.val + carry)%10);
			p.next = tmp;
			p = tmp;
			carry = (p1.val + carry)/10;
			p1 = p1.next;
		}
		if(carry != 0)
			p.next = new ListNode(carry);
		return head.next;
	}

}
