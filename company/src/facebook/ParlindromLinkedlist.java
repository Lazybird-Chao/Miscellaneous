package facebook;

public class ParlindromLinkedlist {
	public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null)
            return true;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode halftail = null;
        while(p2!= null && p2.next != null){
            halftail = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode h1 = head;
        ListNode h2 = p1;
        h2 = reverse(h2);
        p1 = h1;
        p2 = h2;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val)
                break;
            p1 = p1.next;
            p2 = p2.next;
        }
        h2 = reverse(h2);
        halftail.next = h2;
        if(p1 !=null && p2 != null)
            return false;
        else
            return true;   
    }
    
    ListNode reverse(ListNode h){
        ListNode pre = h;
        ListNode p = h.next;
        pre.next = null;
        while(p != null){
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        return pre;
    }

}
