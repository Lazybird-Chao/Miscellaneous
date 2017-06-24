package myleetcode;

public class StudentAttendanceRecord1 {
	public boolean checkRecord(String s){
		if(s.contains("LLL"))
			return false;
		int Afirst = s.indexOf('A');
		if(Afirst>=0&& Afirst<s.length()-1 &&(s.indexOf('A',Afirst+1))>=0){
				return false;
		}
		else
			return true;
	}
	
	public boolean method2(String s){
		int status=0;
		/*
		 * A - 1
		 * A...A false
		 * L - 2
		 * LL -3
		 * LLL false
		 * A..L - 4
		 * A..LL - 5
		 */
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			switch (status) {
			case 0:
				if(ch=='A')
					status = 1;
				else if(ch=='L')
					status = 2;
				break;
			case 1:
				if(ch=='A')
					return false;
				else if(ch == 'L')
					status = 4;
				break;
			case 2:
				if(ch=='A')
					status = 1;
				else if(ch=='L')
					status = 3;
				else
					status = 0;
				break;
			case 3:
				if(ch=='A')
					status = 1;
				else if(ch=='L')
					return false;
				else
					status = 0;
				break;
			case 4:
				if(ch=='A')
					return false;
				else if(ch=='L')
					status = 5;
				else 
					status = 1;
				break;
			case 5:
				if(ch=='A' || ch=='L')
					return false;
				else
					status = 1;
				break;	
			}
		}
		return true;
		
	}

}
