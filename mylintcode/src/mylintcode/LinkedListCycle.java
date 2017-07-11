package mylintcode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) { 
		if(head==null)
			return false;
		ListNode l1, l2;
		l1 = head;
		l2 = head.next;
		while(l1!=null && l2 !=null){
			if(l1 == l2)
				return true;
			l1 = l1.next;
			if(l2.next!= null)
				l2 = l2.next.next;
			else
				break;
		}
		return false;
	}

}
