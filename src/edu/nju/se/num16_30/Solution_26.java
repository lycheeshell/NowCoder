package edu.nju.se.num16_30;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author zongk
 *
 */
public class Solution_26 {
	
	public TreeNode Convert(TreeNode pRootOfTree) {
        
		if(pRootOfTree == null) {
			return null;
		}
		
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		
		if(pRootOfTree.left != null) {
			load(pRootOfTree.left, list);
		}
		list.add(pRootOfTree);
		if(pRootOfTree.right != null) {
			load(pRootOfTree.right, list);
		}
		
		for(int i=0; i<list.size(); i++) {
			if(i == list.size()-1) {
				list.get(i).right = null;
			} else {
				list.get(i).right = list.get(i+1);
			}
			if(i == 0) {
				list.get(i).left = null;
			} else {
				list.get(i).left = list.get(i-1);
			}
		}
		
		
		return list.get(0);
		
    }
	
	public void load(TreeNode root, ArrayList<TreeNode> list) {
		if(root.left != null) {
			load(root.left, list);
		}
		list.add(root);
		if(root.right != null) {
			load(root.right, list);
		}
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
