package edu.nju.se.num31_45;

/**
 * 平衡二叉树
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * @author zongk
 *
 */
public class Solution_39 {
	
    public boolean IsBalanced_Solution(TreeNode root) {
    	
    	if(root == null) {
    		return true;
    	}
    	
    	if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
    		return false;
    	}

    	return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    	
    }
    
    public int TreeDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
    	return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
    
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void main(String[] s) {
		new Solution_39().test();
	}
	public void test() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.right = n2;
		n2.right = n3;
		n3.right = n4;
		n4.right = n5;
		n5.right = n6;
		n6.right = n7;
		System.out.println(IsBalanced_Solution(n1));
	}
}
