import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s); 
        StringBuilder sb = new StringBuilder();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int size = st.countTokens();
        for(int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            max = max < num ? num : max;
            min = min > num ? num : min;
        }    
        
        sb.append(min).append(" ").append(max);
            
        return sb.toString();
    }
}