package edu.nju.se.num61_66;

/**
 * 机器人的运动范围
 * 
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author zongk
 *
 */
public class Solution_66 {
	
    public int movingCount(int threshold, int rows, int cols) {
    	
    	if(threshold < 0) {
    		return 0;
    	}
        
    	boolean[] used = new boolean[rows*cols];
    	
    	move(threshold, rows, cols, 0, 0, used);
    	
    	int num = 0;
    	for(int i=0; i<used.length; i++) {
    		if(used[i]) {
    			num++;
    		}
    	}
    	return num;
    }
    
    public void move(int k, int rows, int cols, int row, int col, boolean[] used) {
    	
    	if(row < 0 || col < 0 || row >= rows || col >= cols) {
    		return;
    	}
    	//System.out.println("row " + row + "-----col " + col);
    	if(rule(k, row, col) && !used[row*cols+col]) {
    		used[row*cols+col] = true;
    		move(k, rows, cols, row+1, col, used);
    		move(k, rows, cols, row-1, col, used);
    		move(k, rows, cols, row, col+1, used);
    		move(k, rows, cols, row, col-1, used);
    	} else {
    		return;
    	}
    }
    
    public boolean rule(int k, int row, int col) {
    	int sum = 0;
    	while(row > 0) {
    		sum = sum + row % 10;
    		row = row / 10;
    	}
    	while(col > 0) {
    		sum = sum + col % 10;
    		col = col / 10;
    	}
    	if(sum <= k) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static void main(String[] args) {
		new Solution_66().test();
	}
    
    public void test() {
    	System.out.println(movingCount(18, 40, 40));
    }
    
}
