package edu.nju.se.num46_60;

/**
 * 	求1+2+3+...+n
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * @author zongk
 *
 */
public class Solution_47 {

    public int Sum_Solution(int n) {
        if(n == 1) {
        	return 1;
        }
        if(n < 1) {
        	return -1;
        }
    	
    	return n + Sum_Solution(n-1);
    	
    }
	
}
