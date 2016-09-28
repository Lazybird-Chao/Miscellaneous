package myleetcode;

public class DeleteNode {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public void deleteNode(ListNode node){
		if(node == null || node.next == null)
			return;
		ListNode p =null;
		while(node.next != null){
			p=node;
			node = node.next;
			p.val= node.val;
		}
		p.next = null;
	}
	
	public void method2(ListNode node){
		if(node == null || node.next == null)
			return;
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
