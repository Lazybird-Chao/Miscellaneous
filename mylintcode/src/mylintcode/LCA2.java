package mylintcode;

public class LCA2 {
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
            ParentTreeNode A,
            ParentTreeNode B) {
		if(root==null)
			return null;
		List<ParentTreeNode> patha = new ArrayList<ParentTreeNode>();
		List<ParentTreeNode> pathb = new ArrayList<ParentTreeNode>();
		while(A!=null) {
			patha.add(A);
			A = A.parent;
		}
		while(B!=null) {
			pathb.add(B);
			B = B.parent;
		}
		int starta=0;
		int startb=0;
		if(A.size()>B.size()) 
			starta = A.size()-B.size();
		else
			startb = B.size()-A.size();
		while(starta<A.size() && startb<B.size()) {
			if(patha.get(starta)==pathb.get(startb))
				return patha.get(starta);
			starta++;
			startb++;
		}
		return null;
		
	}

}
