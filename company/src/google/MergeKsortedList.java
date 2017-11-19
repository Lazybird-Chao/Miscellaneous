package google;

public class MergeKsortedList {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
            return null;
        ListNode head = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(1, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null)
                q.offer(lists[i]);
        }
        ListNode p = head;
        while(!q.isEmpty()){
            ListNode tmp = q.poll();
            p.next = tmp;
            if(tmp.next!=null)
                q.offer(tmp.next);
            p = p.next;
        }
        return head.next;
    }

}
