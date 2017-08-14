package mylintcode;

public class LinkedListCycle2 {
	 public ListNode detectCycle(ListNode head) {
		 if(head==null)
			 return null;
		 ListNode pfast = head;
		 ListNode pslow = head;
		 while(pfast!=null && pfast.next!=null) {
			 pfast = pfast.next.next;
			 pslow = pslow.next;
			 if(pfast==pslow)
				 break;
		 }
		 if(pfast ==null || pfast.next==null)
			 return null;
		 pslow = head;
		 while(pfast != pslow) {
			 pfast = pfast.next;
			 pslow = pslow.next;
		 }
		 return pfast;
		 
	 }

}
