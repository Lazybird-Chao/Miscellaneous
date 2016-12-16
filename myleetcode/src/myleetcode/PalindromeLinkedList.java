package myleetcode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head){
		if(head == null)
			return true;
		ListNode fast, slow;
		fast = slow = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next;
		ListNode rharlf = reverse(slow);
		ListNode fharlf = head;
		while(rharlf != null){
			if(rharlf.val != fharlf.val)
				return false;
			rharlf = rharlf.next;
			fharlf = fharlf.next;
		}
		return true;
			
	}
	
	public ListNode reverse(ListNode head){
		ListNode rhead = null;
		while(head !=null &&head.next!=null){
			ListNode tmp = head.next;
			head.next = rhead;
			rhead = head;
			head = tmp;
		}
		if(head !=null){
			head.next = rhead;
			rhead = head;
		}
		return rhead;
	}
}
