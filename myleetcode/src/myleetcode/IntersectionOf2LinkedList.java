package myleetcode;

public class IntersectionOf2LinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA==null || headB==null)
			return null;
		int countA=0;
		ListNode p = headA;
		while(p != null){
			p = p.next;
			countA++;
		}
		int countB=0;
		p=headB;
		while(p != null){
			p = p.next;
			countB++;
		}
		p = countA>countB?headA: headB;
		ListNode p2 =countA>countB? headB:headA;
		int diff = countA>countB?(countA - countB):(countB-countA);
		while(diff>0){
			p = p.next;
			diff--;
		}
		while(p!=null && p2!=null){
			if(p == p2)
				return p;
			p=p.next;
			p2=p2.next;
		}
		
		return null;
		
	}
	
	public ListNode method2(ListNode headA, ListNode headB){
		if(headA==null || headB==null)
			return null;
		
		ListNode p1, p2;
		p1=headA;
		p2= headB;
		while(p1!=null &&p2 !=null){
			if(p1==p2)
				return p1;
			p1= p1.next==null?headB:p1.next;
			p2 = p2.next==null?headA:p2.next;
		}
		return null;
	}
	
	
}
