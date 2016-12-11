package myleetcode;


public class RemoveDupInList {
	public ListNode deleteDuplicates(ListNode head){
		if(head == null)
			return head;
		ListNode pcur = head;

		while(pcur.next != null){
			if(pcur.val == pcur.next.val){
				ListNode psame = pcur;
				do{
					pcur = pcur.next;
				}
				while(pcur.next != null && pcur.val == pcur.next.val);
				psame.next = pcur.next;
				if(pcur.next == null)	
					break;
					
			}
			pcur = pcur.next;
			
		}
		return head;
	}
}
