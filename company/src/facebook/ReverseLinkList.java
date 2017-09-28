package facebook;

public class ReverseLinkList {
	public ListNode reverseList(ListNode head){
        if(head == null)
            return null;
        /*
        ListNode pre = head;
        ListNode p = pre.next;
        pre.next = null;
        while(p != null){
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        return pre;
        */
        helper(head);
        return rhead;
    }
    
    ListNode rhead;
    ListNode helper(ListNode p){
        if(p.next == null){
            rhead = p;
        }else{
            ListNode pre = helper(p.next);
            pre.next = p;
        }
        p.next = null;
        return p;
    }

}
