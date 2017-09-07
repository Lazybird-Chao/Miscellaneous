package amazon;

import common.ListNode;

public class IntersectionOfTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		ListNode p1 = headA;
		int count1=0;
		while(p1 != null) {
			p1 = p1.next;
			++count1;
		}
		ListNode p2 = headB;
		int count2 = 0;
		while(p2!=null) {
			p2 = p2.next;
			count2++;
		}
		if(count1 > count2) {
			p1 = headA;
			p2 = headB;
			count1 = count1-count2;
		} else {
			p1 = headB;
			p2 = headA;
			count1 = count2-count1;
		}
		while(count1!=0) {
			p1 = p1.next;
			--count1;
		}
		while(p1!=null && p2!=null) {
			if(p1==p2)
				return p1;
			else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return null;
			
	}

}
