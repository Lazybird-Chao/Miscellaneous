package myleetcode;
import myleetcode.DeleteNode.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode p0 = head;
		head = head.next;
		p0.next = head.next;
		head.next = p0;
		
		ListNode p1 = p0.next;
		while(p1 !=null){
			ListNode p2 = p1.next;
			if(p2 !=null){
				p0.next = p2;
				p1.next = p2.next;
				p2.next = p1;
			}
			p0 = p1;
			p1 = p1.next;
		}
		return head;
	}
	
	public ListNode method2(ListNode head){
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode current = dummy;
	    while (current.next != null && current.next.next != null) {
	        ListNode first = current.next;
	        ListNode second = current.next.next;
	        first.next = second.next;
	        current.next = second;
	        current.next.next = first;
	        current = current.next.next;
	    }
	    return dummy.next;
	}
}
