package edu.nju.se;

/**
 * 重建二叉树
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author zongk
 *
 */
public class Solution_04 {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if(pre.length == 0 && in.length == 0) {
			return null;
		}
		
		int root = pre[0];
		TreeNode node = new TreeNode(root);
		
		int index = -1;
		for(int i=0; i<in.length; i++) {
			if(in[i] == root) {
				index = i;
				break;
			}
		}
		
		int[] leftPre = new int[index];
		for(int i=1; i<=index; i++) {
			leftPre[i-1] = pre[i];
		}
		int[] leftIn = new int[index];
		for(int i=0; i<index; i++) {
			leftIn[i] = in[i];
		}
		int rightLength = pre.length-index-1;
		int[] rightPre = new int[rightLength];
		for(int i=0; i<rightLength; i++) {
			rightPre[i] = pre[index + 1 + i];
		}
		int[] rightIn = new int[rightLength];
		for(int i=0; i<rightLength; i++) {
			rightIn[i] = in[index + 1 + i];
		}
		
		node.left = reConstructBinaryTree(leftPre, leftIn);
		node.right = reConstructBinaryTree(rightPre, rightIn);
		
		return node;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
