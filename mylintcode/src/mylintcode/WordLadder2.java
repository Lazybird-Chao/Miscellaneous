package mylintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        if(start==null || end == null || dict == null)
			return new ArrayList<List<String>>();
		Set<Character> c_set = new HashSet<Character>();
		letterSet(start, c_set);
		letterSet(end, c_set);
		for(String s: dict)
			letterSet(s, c_set);
		char[] c = new char[c_set.size()];
		int i=0;
		for(char cc: c_set)
			c[i++] = cc;
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> curR = new ArrayList<String>();
		Set<String> curR_set = new HashSet<String>();
		curR.add(start);
		curR_set.add(start);
		Map<String, Integer> spmap = new HashMap<String, Integer>();
		dict.add(start);
		findShortest(end, dict, c, spmap);
		if(spmap.containsKey(start)==false)
			return new ArrayList<List<String>>();
		dict.remove(start);
		System.out.println(spmap.get(start));
		helper(start, end, dict, c, result, curR, curR_set, spmap.get(start), spmap);
		return result;
		
	}
	
	public void letterSet(String s, Set<Character> c_set){
		for(int i=0; i<s.length(); i++)
			c_set.add(s.charAt(i));
	}
	
	public int distance(String s1, String s2){
	    int count = 0;
	    for(int i=0; i<s1.length(); i++)
	        if(s1.charAt(i) != s2.charAt(i))
	            count++;
	    return count;
	}
	public void helper(String start, String end, Set<String> dict, char[] c_set,  List<List<String>> result, 
			List<String> curR, Set<String> curR_set, int sp, Map<String, Integer> spmap){
		if(start.equals(end)){
			if(result.isEmpty())
				result.add(new ArrayList<String>(curR));
			else{
				if(curR.size() < result.get(0).size()){
					result.clear();
					result.add(new ArrayList<String>(curR));
				}
				else if(curR.size() == result.get(0).size())
					result.add(new ArrayList<String>(curR));
			}
			return;
		}
		/*if(result.isEmpty()==false && curR.size() + distance(start, end) > result.get(0).size())
		    return;
		    */
		if(spmap.containsKey(start)==false)
			return;
		else if(curR.size() + spmap.get(start) > sp+1)
		    return;
		char[] c_start = start.toCharArray();
		for(int i=0; i<c_start.length; i++){
			char tmp = c_start[i];
			for(int j=0; j<c_set.length; j++){
				c_start[i] = c_set[j];
				String new_start = new String(c_start);
				if((curR_set.contains(new_start)==false) &&(dict.contains(new_start)||end.equals(new_start))){
					curR_set.add(new_start);
					curR.add(new_start);
					helper(new_start, end, dict, c_set, result, curR, curR_set, sp, spmap);
					curR.remove(curR.size()-1);
					curR_set.remove(new_start);
				}
			}
			c_start[i] = tmp;
		}
		return;
	
    }
	
	void findShortest(String end, Set<String> dict, char[] c_set, Map<String, Integer> sp ){
		sp.put(end, 0);
        Queue<String> accList = new LinkedList<String>();
        Set<String> accessed = new HashSet<String>();
        accList.offer(end);
        accessed.add(end);
        int count = 1;
        while(accList.isEmpty()==false){
        	int levelSize = accList.size();
        	for(int i=0; i<levelSize; i++){
        		String cur = accList.poll();
        		char[] c_start = cur.toCharArray();
        		for(int p=0; p<c_start.length; p++){
        			char tmp = c_start[p];
        			for(int q=0; q<c_set.length; q++){
        				c_start[p] = c_set[q];
        				String next = new String(c_start);
        				if(dict.contains(next) && accessed.add(next)){
        					accList.offer(next);
        					sp.put(next, count);
        				}
        			}
        			c_start[p]=tmp;
        		}        		
        	}
        	count++;
        }
        return;
    }
	
	public static void main(String[] args){
		//String s = "qa";
		//String e = "sq";
		/*String[] d= {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av",
				"sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po",
				"fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb",
				"yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di",
				"hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn",
				"mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};*/
		//String[] d = {"si", "ya","ba","bs","bq","ye"};
		String s ="cet";
		String e = "ism";
		String[] d = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
		Set<String> dict = new HashSet<String>();
		for(String ss: d)
			dict.add(ss);
		
		WordLadder2 test = new WordLadder2();
		List<List<String>> r = test.findLadders(s, e, dict);
		for(List<String> l: r){
			for(String ss: l){
				System.out.print(ss+"  ");
			}
			System.out.println("");
		}
		System.out.println("finish");
		return;
		
	}

}
