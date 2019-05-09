package edu.nju.se.num16_30;

/**
 * 	二叉搜索树的后序遍历序列
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 
 * @author zongk
 *
 */
public class Solution_23 {
	
	public boolean VerifySquenceOfBST(int [] sequence) {
		
		if(sequence.length == 0) {
			return false;
		}
		
		return judgeSubTree(sequence, 0, sequence.length-1);
		
    }
	
	public boolean judgeSubTree(int[] sequence, int start, int end) {
		
		if(start >= end) {
			return true;
		}
		
		int left = start;
		for(int i=start; i<=end; i++) {
			if(sequence[i] < sequence[end]) {
				left++;
			} else {
				break;
			}
		}
		
		for(int i=left; i<end; i++) {
			if(sequence[i] <= sequence[end]) {
				return false;
			}
		}
		
		return judgeSubTree(sequence, start, left-1) && judgeSubTree(sequence, left, end-1);
	}
	
}
