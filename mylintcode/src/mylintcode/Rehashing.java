package mylintcode;

public class Rehashing {
	public ListNode[] rehashing(ListNode[] hashTable) {
		if(hashTable ==null || hashTable.length==0)
			return new ListNode[0];
		ListNode[] newTable = new ListNode[hashTable.length*2];
		for(int i=0; i<hashTable.length; i++) {
			ListNode cur = hashTable[i];
			if(cur!=null) {
				while(cur!=null) {
					int v = cur.val;
					int pos = v%newTable.length;
					if(pos<0)
						pos = (pos+newTable.length)%newTable.length;
					ListNode tmp = new ListNode(v);
					tmp.next = newTable[pos];
					newTable[pos] = tmp;
					cur = cur.next;
				}
			}
		}
		return newTable;
		
	}

}
