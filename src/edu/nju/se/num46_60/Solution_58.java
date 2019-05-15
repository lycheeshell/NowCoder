package edu.nju.se.num46_60;

/**
 * 对称的二叉树
 * 
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author zongk
 *
 */
public class Solution_58 {
	
	boolean isSymmetrical(TreeNode pRoot) {
		
		if(pRoot == null) { 
			return true;
		}
		
		return compareSymmetrical(pRoot.left, pRoot.right);
		
    }
	
	boolean compareSymmetrical(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}
		if(left == null) {
			return false;
		}
		if(right == null) {
			return false;
		}
		if(left.val != right.val) {
			return false;
		}
		return compareSymmetrical(left.left, right.right) && compareSymmetrical(left.right, right.left);
	}
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
}
