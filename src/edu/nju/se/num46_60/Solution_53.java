package edu.nju.se.num46_60;

/**
 * 表示数值的字符串
 * 
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * @author zongk
 *
 */
public class Solution_53 {

    public boolean isNumeric(char[] str) {
    	
    	int signIndex = 0;
    	int pointIndex = 0;
    	int eIndex = 0;
    	int eSignIndex = 0;
    	int ePointIndex = 0;
    	
    	for(int i=0; i<str.length; i++) {
    		
    		if(isE(str[i])) {
    			if(i == str.length-1) {
    				return false;
    			}
    			if(!(i>=1  && isNumber(str[i-1]))) {
    				return false;
    			}
//    			if(!(i>=2 && (isSign(str[i-2]) || isPoint(str[i-2])) ) ) {
//    				return false;
//    			}
    			eIndex++;
    		} else if(isPoint(str[i])) {
    			if(eIndex == 0) {
    				pointIndex++;
    			} else {
    				ePointIndex++;
    			}
    			if(!(i>=1  && (isNumber(str[i-1]) || isSign(str[i-1]) ))) {
    				return false;
    			}
    		} else if(isSign(str[i])) {
    			if(eIndex == 0) {
    				if(i!=0) {
    					return false;
    				}
    				signIndex++;
    			} else {
    				if(!isE(str[i-1])) {
    					return false;
    				}
    				eSignIndex++;
    			}
    		} else if(!isNumber(str[i])) {
    			return false;
    		}
    		
    		
    		if(signIndex > 1) {
    			return false;
    		}
    		if(pointIndex > 1) {
    			return false;
    		}
    		if(eIndex > 1) {
    			return false;
    		}
    		if(eSignIndex > 1) {
    			return false;
    		}
    		if(ePointIndex > 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public boolean isNumber(char c) {
    	if(c>='0' && c<='9') {
    		return true;
    	} 
    	return false;
    }
    
    public boolean isE(char c) {
    	if(c=='e' || c=='E') {
    		return true;
    	}
    	return false;
    }
    
    public boolean isSign(char c) {
    	if(c=='-' || c=='+') {
    		return true;
    	}
    	return false;
    }
    
    public boolean isPoint(char c) {
    	if(c=='.') {
    		return true;
    	}
    	return false;
    }
    
}
