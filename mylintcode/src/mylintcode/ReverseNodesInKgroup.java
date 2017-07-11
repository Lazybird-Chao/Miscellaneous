package mylintcode;

public class ReverseNodesInKgroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null)
			return null;
		
		ListNode dummy = new ListNode(0);
		ListNode lastend = dummy;
		ListNode pre = null;
		ListNode cur = head;
		while(cur!=null){
			ListNode p = cur;
			ListNode start = cur;
			int count = 0;
			while(count<k && p!=null){
				p =p.next;
				count++;
			}
			if(p==null)
				break;
			pre = p;
			while(cur!= p){
				ListNode tmp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = tmp;
			}
			lastend.next = pre;
			lastend = start;	
		}
		return dummy.next;
	}

}
