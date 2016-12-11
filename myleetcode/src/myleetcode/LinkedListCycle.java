package myleetcode;


public class LinkedListCycle {
	public boolean hasCycle(ListNode head){
		ListNode fast;
		ListNode slow;
		fast= slow = head;
		while(fast != null && slow != null){
			slow = slow.next;
			fast = fast.next;
			if(fast.next !=null)
				fast = fast.next;
			if(fast == slow)
				break;
		}
		return slow!=null && fast!=null;
	}
}
