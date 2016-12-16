package myleetcode;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, 
			int E, int F, int G, int H ){
		int area1 = (C-A)*(D-B);
		int area2 = (G-E)*(H-F);
		
		int coverarea=0;
		int coverleft = Math.max(A, E);
		int coverright = Math.min(C,G);
		int coverbottom = Math.max(B, F);
		int covertop = Math.min(D, H);
		if(coverleft<coverright && coverbottom<covertop)
		{
			coverarea = (coverright-coverleft)*(covertop-coverbottom);
		}
		return area1+area2-coverarea;
	}
	
	public int method2(int A, int B, int C, int D, 
			int E, int F, int G, int H ){
		int area1 = (C-A)*(D-B);
		int area2 = (G-E)*(H-F);
		
		int coverarea=0;
		int coverleft = Math.max(A, E);
		int coverright = Math.max(coverleft,Math.min(C,G));
		int coverbottom = Math.max(B, F);
		int covertop = Math.max(coverbottom, Math.min(D, H));
		coverarea = (coverright-coverleft)*(covertop-coverbottom);
		return area1+area2-coverarea;
	}
}
