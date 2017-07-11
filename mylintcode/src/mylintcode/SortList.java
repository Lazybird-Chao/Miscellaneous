package mylintcode;

public class SortList {
	public ListNode sortList(ListNode head) {
		if(head==null)
			return null;
		int count=0;
		ListNode p = head;
		while(p!=null){
			p=p.next;
			count++;
		}
		return mergeSort(head, count);
	}
	
	public ListNode mergeSort(ListNode head, int n){
		if(n==1)
			return head;
		int subn = n/2;
		ListNode h1 = head;
		ListNode h2 = head;
		for(int i=0; i<n/2-1; i++)
			h2 = h2.next;
		ListNode tmp = h2;
		h2 = h2.next;
		tmp.next = null;
		h1 = mergeSort(h1, n/2);
		h2 = mergeSort(h2, n-n/2);
		return merge(h1, h2);
		
		
	}
	
	public ListNode merge(ListNode h1, ListNode h2){
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(h1!=null&& h2!=null){
			if(h1.val<h2.val){
				p.next = h1;
				h1 = h1.next;
			}
			else{
				p.next = h2;
				h2 = h2.next;
			}
			p= p.next;
		}
		while(h1!=null){
			p.next = h1;
			p=p.next;
			h1= h1.next;
		}
		while(h2!=null){
			p.next = h2;
			p=p.next;
			h2= h2.next;
		}
		return head.next;
	}

}
