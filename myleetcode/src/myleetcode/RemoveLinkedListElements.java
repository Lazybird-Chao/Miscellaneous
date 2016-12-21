package myleetcode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val){
		ListNode p = head;
		if(p==null)
			return null;
		while(p != null && p.val == val){
			p = p.next;
		}
		head = p;
		if(p==null)
			return head;
		ListNode p2 = p.next;
		while(p2!=null){
			if(p2.val == val)
				p.next = p2.next;
			else
				p = p.next;
			p2 = p2.next;
		}
		return head;
		
	}
	
	public ListNode method2(ListNode head, int val){
		ListNode dummyhead = new ListNode(val-1);
		dummyhead.next = head;
		ListNode p1 = dummyhead;
		ListNode p2 = head;
		while(p2!=null){
			if(p2.val == val)
				p1.next = p2.next;
			else
				p1 = p1.next;
			p2 = p2.next;
		}
		return dummyhead.next;
	}
	
	public ListNode method3(ListNode head, int val){
		if(head == null)
			return null;
		head.next = method3(head.next, val);
		return head.val==val ? head.next: head;
	}
}
