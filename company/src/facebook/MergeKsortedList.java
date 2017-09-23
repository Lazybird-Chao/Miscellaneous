package facebook;

public class MergeKsortedList {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(1, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null)
                q.add(lists[i]);
        }
        while(!q.isEmpty()){
            ListNode cur = q.poll();
            p.next = cur;
            p = cur;
            if(cur.next != null)
                q.offer(cur.next);
        }
        return head.next;
        
    }

}
