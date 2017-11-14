package contest;

public class SplitLinkedlistInParts {
	public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null)
            return new ListNode[k];
        int count = 0;
        ListNode head = new ListNode(0);
        head.next = root;
        ListNode p = root;
        while(p != null){
            p = p.next;
            count++;
        }
        int partcount = 0;
        int residue = 0;
        partcount = count / k;
        residue = count % k;
        ListNode[] res = new ListNode[k];
        int part = 0;
        p = root;
        //System.out.println(count);
        while(part < k){
            int tmp = partcount;
            if(part < residue)
                tmp = partcount + 1;
            if(tmp ==0){
                res[part++] = null;
                continue;
            }
            res[part] = p;
            ListNode pre = p;
            while(tmp > 0){
                pre = p;
                p = p.next;
                tmp--;
            }
            //System.out.println(p.val);
            pre.next = null;
            part++;
        }
        return res;
    }

}
