package myleetcode;

public class LinkedListRandomNode {
	ListNode head;
	public Solution(ListNode head){
		this.head = head;
	}
	
	public int getRandom(){
		int ret = head.val;
		ListNode p = head.next;
		int k=1;
		int i=1;
		while(p!=null){
			if(Math.random()<(double)k/(k+i))
				ret = p.val;
			p=p.next;
			i++;
		}
		return ret;
	}
}
