package mylintcode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head==null)
			return null;
		ListNode h1, h2;
		h1 = new ListNode(0);
		h2 = new ListNode(0);
		ListNode p = head;
		ListNode p1 = h1;
		ListNode p2 = h2;
		while(p!=null) {
			if(p.val<x) {
				p1.next = p;
				p1 = p;
			}
			else {
				p2.next = p;
				p2 = p;
			}
			p=p.next;
		}
		p1.next = h2.next;
		p2.next = null;
		return h1.next;
	}

}
