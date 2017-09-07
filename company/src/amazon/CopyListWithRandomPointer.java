package amazon;

public class CopyListWithRandomPointer {
	
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		RandomListNode p = head;
		while(p != null) {
			RandomListNode pCopy = new RandomListNode(p.label);
			RandomListNode next = p.next;
			pCopy.next = next;
			p.next = pCopy;
			p = next;
		}
		RandomListNode headCopy = head.next;
		p = head;
		while(p != null) {
			RandomListNode next = p.next.next;
			RandomListNode pCopy = p.next;
			if(p.random != null)
			    pCopy.random = p.random.next;
			p = next;
		}
		p = head;
		while(p != null) {
			RandomListNode pCopy = p.next;
			RandomListNode next = p.next.next;
			p.next = next;
			if(next != null)
				pCopy.next = next.next;
			p = next;
		}
		return headCopy;
	}

}
