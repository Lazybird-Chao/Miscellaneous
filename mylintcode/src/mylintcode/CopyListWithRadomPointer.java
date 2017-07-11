package mylintcode;

public class CopyListWithRadomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return null;
		RandomListNode l1 = head;
		while(l1!=null){
			RandomListNode cur_copy = new RandomListNode(l1.val);
			cur_copy.next = l1.next;
			l1.next = cur_copy;
			l1 = cur_copy.next;
		}
		
		l1 = head;
		while(l1!=null){
			l1.next.random = l1.random.next;
		}
		
		RandomListNode copyHead = head.next;
		l1 = head;
		while(l1!= null){
			RandomListNode tmp = l1.next.next;
			l1.next.next = tmp.next;
			l1.next = tmp;
			l1 = tmp;
			
		}
		return copyHead;
		
	}

}
