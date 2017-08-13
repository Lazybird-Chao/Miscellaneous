package mylintcode;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConvertBTtoLinkedListByDepth {
	public List<ListNode> binaryTreeToLists(TreeNode root) {
		if(root==null)
			return new ArrayList<ListNode>();
		
		List<ListNode> ans = new ArrayList<ListNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelsize = queue.size();
			ListNode head = new ListNode(0);
			ListNode pre = head;
			for(int i=0; i<levelsize; i++) {
				TreeNode cur = queue.poll();
				ListNode curNode = new ListNode(cur.val);
				pre.next = curNode;
				pre = curNode;
				if(cur.left!=null)
					queue.offer(cur.left);
				if(cur.right!=null)
					queue.offer(cur.right);
			}
			ans.add(head.next);
		}
		return ans;
	}

}
