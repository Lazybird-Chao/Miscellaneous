package myleetcode;


public class MergeSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergepoint1, mergepoint2;
		ListNode head;
		if(l1 == null)
			return head = l2;
		else if(l2 == null)
			return head = l1;
		else
			head = l1.val <= l2.val ? l1 : l2;
		while(l1 !=null && l2!= null){
			if(l1.val <= l2.val){
				mergepoint1 = l1;
				l1 = l1.next;
				while(l1 != null && l1.val <= l2.val){
					mergepoint1 = l1;
					l1 = l1.next;
				}
				mergepoint1.next = l2;
			}
			else{
				mergepoint2 = l2;
				l2 = l2.next;
				while(l2 != null && l2.val <= l1.val){
					mergepoint2 = l2;
					l2 = l2.next;
				}
				mergepoint2.next = l1;
			}
				
		}
		return head;
    }
	
	public ListNode method2(ListNode head, ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
