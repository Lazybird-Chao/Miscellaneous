package myleetcode;

import java.util.ArrayList;

public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1==null || l2==null)
			return null;
		ListNode p1=null, p2=null;
		while(l1.next!=null){
			p1 = l1;
			l1 = l1.next;
			p1.next = p2;
			p2 = p1;
		}
		l1.next = p2;
		p1=p2=null;
		while(l2.next!=null){
			p1 = l2;
			l2 = l2.next;
			p1.next = p2;
			p2 = p1;
		}
		l2.next = p2;
		
		ListNode sum=null;
		p1 = l1;
		p2 = l2;
		int c=0;
		while(p1!=null || p2!=null){
			int s = c;
			if(p1!=null){
				s+=p1.val;
				p1 = p1.next;
			}
			if(p2!=null){
				s+= p2.val;
				p2 = p2.next;
			}
			c = s/10;
			s = s%10;
			ListNode tmp = new ListNode(s);
			tmp.next = sum;
			sum = tmp;
		}
		if(c!=0){
			ListNode tmp = new ListNode(c);
			tmp.next = sum;
			sum = tmp;
		}
		return sum;	
	}
	
	public ListNode method2(ListNode l1, ListNode l2){
		if(l1==null || l2==null)
			return null;
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		ListNode t = l1;
		while(t!=null){
			p1.add(t.val);
			t=t.next;
		}
		t = l2;
		while(t!=null){
			p2.add(t.val);
			t=t.next;
		}
		int i = p1.size()-1;
		int j = p2.size()-1;
		int c=0;
		ListNode sum = null;
		while(i>=0 || j>=0){
			int s = c;
			if(i>0){
				s+= p1.get(i);
				i--;
			}
			if(j>0){
				s+= p2.get(j);
				j--;
			}
			c = s/10;
			s = s%10;
			ListNode tmp = new ListNode(s);
			tmp.next = sum;
			sum = tmp;
		}
		if(c!=0){
			ListNode tmp = new ListNode(c);
			tmp.next = sum;
			sum = tmp;
		}
		return sum;		
		
	}
}
