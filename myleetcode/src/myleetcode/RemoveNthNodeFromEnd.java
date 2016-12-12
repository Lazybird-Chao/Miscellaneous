package myleetcode;

import java.util.ArrayList;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthNodeFromEnd(ListNode head, int n){
		ArrayList<ListNode> nodeArray = new ArrayList<ListNode>();
		ListNode p = head;
		while(p!=null){
			nodeArray.add(p);
			p=p.next;
		}
		int delidx = nodeArray.size()-n;
		if(delidx ==0)
			head = head.next;
		else{
			p = nodeArray.get(delidx-1);
			p.next = p.next.next;
		}
		return head;
	}
	
	public ListNode method2(ListNode head, int n){
		ListNode fast = head;
		ListNode slow = head;
		while(n>0){
			fast = fast.next;
			n--;
		}
		if(fast == null)
		    return head.next;
		while(fast.next !=null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
