package facebook;

public class ReverseNodesinKgroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        if(k == 1)
            return head;
        ListNode p = head;
        ListNode prehead = null;
        ListNode dummy = new ListNode(0);
        ListNode pretail = dummy;
        pretail.next = p;
        while(p != null){
            prehead = p;
            int count = 0;
            while(count < k && p != null){
                count++;
                p = p.next;
            }
            if(count < k)
                break;
            pretail.next = helper(prehead, k);
            prehead.next = p;
            pretail = prehead;
        }
        return dummy.next;
    }
    
    ListNode helper(ListNode h, int k){
        int i = 1;
        ListNode pre = h;
        ListNode p = h.next;
        while(i < k && p != null){
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
            i++;
        }
        return pre;
    }

}
