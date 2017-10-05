package facebook;

public class EncodeDecodeTinyUrl {
	public class Codec {

	    Map<String, String> longToShort;
	    Map<String, String> shortToLong;
	    char[] dict;
	    int codeLen;
	    double maxCode;
	    String codeHead;
	    Random randGen;
	    public Codec(){
	        longToShort = new HashMap<String, String>();
	        shortToLong = new HashMap<String, String>();
	        dict = new char[10+26+26];
	        codeLen = 6;
	        maxCode = Math.pow(62, 6);
	        codeHead = new String("http://tinyurl.com/");
	        randGen = new Random();
	    }
	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	        if(longToShort.containsKey(longUrl))
	            return codeHead+longToShort.get(longUrl);
	        if(longToShort.size()/maxCode >= 0.5)
	            codeLen++;
	        StringBuilder res = new StringBuilder();
	        do{
	            res.setLength(0);
	            int[] seq = genSeq(codeLen);
	            for(int i = 0; i < codeLen; i++)
	                res.append(dict[i]);
	        }while(shortToLong.containsKey(res.toString()));
	        shortToLong.put(res.toString(), longUrl);
	        longToShort.put(longUrl, res.toString());
	        return codeHead+res.toString();
	    }
	    int[] genSeq(int len){
	        int[] res = new int[len];
	        for(int i = 0; i < len; i++)
	            res[i] = randGen.nextInt(62);
	        return res;
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	        String code = shortUrl.substring(codeHead.length());
	        if(shortToLong.containsKey(code))
	            return shortToLong.get(code);
	        return "";
	    }
	}

}
