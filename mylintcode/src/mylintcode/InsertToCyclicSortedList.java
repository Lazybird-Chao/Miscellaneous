package mylintcode;

public class InsertToCyclicSortedList {
	public ListNode insert(ListNode node, int x) {
		if(node==null){
            ListNode n = new ListNode(x);
            n.next = n;
            return n;
        }
		ListNode start = node;
		while(start!= node.next){
			if(node.val<=x && x<=node.next.val){
				ListNode n = new ListNode(x);
				n.next = node.next;
				node.next = n;
				return node;
			}
			else if(node.val>node.next.val && (node.val<= x || node.next.val >= x)){
			    ListNode n = new ListNode(x);
				n.next = node.next;
				node.next = n;
				return node;
			}
			node = node.next;
		}
		ListNode n = new ListNode(x);
		n.next = node.next;
		node.next = n;
		return node;
		
	}

}
