package edu.nju.se.num31_45;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 
 * @author zongk
 *
 */
public class Solution_31 {
	
    public int NumberOf1Between1AndN_Solution(int n) {
    	
    	if(n <= 0) {
    		return 0;
    	}
    	
    	int num = 0;
    	
    	for( int i=1; i<=n; i++) {
    		num = num + count(i);
    	}
    	
    	return num;
    }
    
    public int count(int n) {
    	int num = 0;
    	int temp = 0;
    	while(n > 0) {
    		temp = n % 10;
    		if(temp == 1) {
    			num++;
    		}
    		n = n / 10;
    	}
    	return num;
    }
    
}
