package google;

public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
        if(input == null || input.isEmpty())
            return 0;
        String[] dirs = input.split("\n");
        int[] pathLen = new int[dirs.length];
        int maxFilePathLen = 0;
        for(int i = 0; i < dirs.length; i++){
            int depth = checkDepth(dirs[i]);
            if(depth == 0)
                pathLen[depth] = dirs[i].length();
            else
                pathLen[depth] = dirs[i].length() - depth + pathLen[depth-1];
            if(dirs[i].contains("."))
                maxFilePathLen = Math.max(pathLen[depth] + depth, maxFilePathLen);
        }
        return maxFilePathLen;
        
    }
    int checkDepth(String dir){
        int d = 0;
        char[] dirc = dir.toCharArray();
        int i = 0;
        while(i < dirc.length){
            if(dirc[i] == '\t')
                d++;
            else
                break;
            i++;
        }
        return  d;
    }

}
