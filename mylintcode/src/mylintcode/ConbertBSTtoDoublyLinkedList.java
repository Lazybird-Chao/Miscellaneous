package mylintcode;

public class ConbertBSTtoDoublyLinkedList {
	public DoublyListNode bstToDoublyList(TreeNode root) {
		if(root==null)
			return null;
		DoublyListNode dummy = new DoublyListNode(0);
		helper(root, dummy);
		dummy.next.prev = null;
		return dummy.next;
		
	}
	
	public class DoublyListNode {
      int val;
      DoublyListNode next, prev;
      DoublyListNode(int val) {
          	this.val = val;
          	this.next = this.prev = null;
      	}
	}
	
	DoublyListNode helper(TreeNode root, DoublyListNode pre) {
		if(root==null)
			return null;
		DoublyListNode cur = new DoublyListNode(root.val);
		if(root.left!=null) {
			pre = helper(root, pre);
		}
		pre.next = cur;
		cur.prev = pre;
		if(root.right!=null)
			return helper(root.right, cur);
		else
			return cur;
	}

}
