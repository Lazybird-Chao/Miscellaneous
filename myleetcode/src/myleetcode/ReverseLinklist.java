package myleetcode;
import myleetcode.DeleteNode.ListNode;

public class ReverseLinklist {
	public ListNode reverseList(ListNode head){
		if(head== null)
			return head;
		ListNode plast= head;
		ListNode pcur = plast.next;
		head.next = null;
		while(pcur !=null){
			ListNode pnext = pcur.next;
			pcur.next = plast;
			plast = pcur;
			pcur = pnext;			
		}
		head = plast;
		return head;
	}
	
	public ListNode method2(ListNode head){
		if(head ==null || head.next==null)
			return head;
		ListNode p1 = head;
		ListNode p2 = p1.next;
		head = method2(p2);
		p2.next = p1;
		p1.next = null;
		return head;
	}
}
