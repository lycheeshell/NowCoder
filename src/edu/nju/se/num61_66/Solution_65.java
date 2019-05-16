package edu.nju.se.num61_66;

/**
 * 	矩阵中的路径
 * 
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 * @author zongk
 *
 */
public class Solution_65 {
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    	
    	boolean[] used = new boolean[rows*cols];
    	
    	for(int i=0; i<rows; i++) {
    		for(int j=0; j<cols; j++) {
    			if(judge(matrix, rows, cols, i, j, str, 0, used)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean judge(char[] matrix, int rows, int cols, int row, int col, char[] str, int index, boolean[] used) {
    	
    	if(index == str.length) {
    		return true;
    	}
    	
    	if(row < 0 || col < 0 || row >= rows || col >= cols) {
    		return false;
    	}
    	
    	if(str[index] == matrix[cols*row+col] && !used[cols*row+col]) {
    		used[cols*row+col] = true;
    		if(judge(matrix, rows, cols, row+1, col, str, index+1, used)
    		|| judge(matrix, rows, cols, row-1, col, str, index+1, used)
    		|| judge(matrix, rows, cols, row, col+1, str, index+1, used)
    		|| judge(matrix, rows, cols, row, col-1, str, index+1, used) ) {
    			return true;
    			
    		} else {
    			//System.out.println("row " + row + "-----col " + col);
    			used[cols*row+col] = false;
    			return false;
    		}
    	} else {
    		return false;
    	}
    	
    }
    
    public static void main(String[] args) {
		new Solution_65().test();
	}
    
    public void test() {
    	String s1 = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
    	char[] m = s1.toCharArray();
    	String s2 = "SGGFIECVAASABCEHJIGQEM";
    	char[] n = s2.toCharArray();
    	System.out.print(hasPath(m, 5, 8, n));
    }
}
