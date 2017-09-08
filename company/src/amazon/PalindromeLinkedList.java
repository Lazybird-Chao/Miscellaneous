package amazon;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }                           // when finish, if fast == null, there are even nodes, and slow is first of right half
                                    // if fast.next == null, there are odd nodes, and slow is the middle
        ListNode pre = slow;
        ListNode p = pre.next;
        while(p != null){
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        p = pre;
        ListNode p1 = head;
        while(p!=slow){
            if(p1.val != p.val)
                return false;
            p1 = p1.next;
            p = p.next;
        }
        return p1.val == p.val;
        
    }

}
