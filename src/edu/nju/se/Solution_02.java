package edu.nju.se;

/**
 * 替换空格
 * 
 * @author zongk
 *
 */
public class Solution_02 {

	public String replaceSpace(StringBuffer str) {
		
		StringBuffer sb = new StringBuffer();
    	String s = str.toString();
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) == ' ') {
    			sb.append("%20");
    		} else {
    			sb.append(s.charAt(i));
    		}
    	}
    	
    	return sb.toString();
    }
	
}
