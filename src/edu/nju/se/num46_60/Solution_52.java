package edu.nju.se.num46_60;

/**
 * 	正则表达式匹配
 * 
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * @author zongk
 *
 */
public class Solution_52 {
	
    public boolean match(char[] str, char[] pattern) {
        
    	int i = 0;
    	int j = 0;
    	
    	while(i<str.length && j<pattern.length) {
    		
    		if(pattern[j] == '.') {
    			i++;
    			j++;
    		} else if(pattern[j] == '*') {
    			while(str[i] == pattern[j-1] || pattern[j-1] == '.' ) {
    				i++;
    				
    				boolean allSame = true;
    				if(j==pattern.length-1) {
    					
    				} else {
    					int k=j+1;
    					while(k<pattern.length) {
    						if(k<pattern.length-1 && pattern[k] != pattern[j-1] && pattern[k] != '*' && pattern[k+1] != '*') {
    							allSame = false;
    						} else if(k == pattern.length-1 && (pattern[k] != pattern[j-1] && pattern[k] != '*' && pattern[k] != str[i-1]) ) {
    							allSame = false;
    						}
    						k++;
    					}
    				}
    				
    				if((!allSame) && str[str.length-1] != pattern[pattern.length-1]) {
    					return false;
    				}
    				
    				if(i==str.length && allSame) {
    					return true;
    				}
    			}
    			j++;
    		} else {
    			if(str[i] == pattern[j]) {
    				i++;
    				j++;
    			} else if(j+1 < pattern.length && pattern[j+1] == '*') {
    				j++;
    			} else {
    				return false;
    			}
    		}
    		
    	}
    	
    	if(i<str.length || j<pattern.length) {
    		if(j==pattern.length-2 && pattern[j+1] == '*') {
    			return true;
    		}
    		if(j==pattern.length-1 && pattern[j] == '*') {
    			return true;
    		}
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public static void main(String[] s) {
    	char[] str= {'b','b','b','b','a'};
    	char[] pattern = {'.','*','a','*','a'};
    	System.out.println(new Solution_52().match(str, pattern));
    }
	
}
