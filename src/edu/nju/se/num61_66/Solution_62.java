package edu.nju.se.num61_66;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉搜索树的第k个结点
 * 
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 
 * @author zongk
 *
 */
public class Solution_62 {
	
	ArrayList<TreeNode> list = new  ArrayList<TreeNode>();
	ArrayList<Integer> num = new ArrayList<Integer>();
	

    TreeNode KthNode(TreeNode pRoot, int k) {
    	
    	if(k < 1) {
    		return null;
    	}
        
    	load(pRoot);
    	
    	if(k > list.size()) {
    		return null;
    	}
    	
    	int[] numbers = new int[num.size()];
    	for(int i=0; i<num.size(); i++) {
    		numbers[i] = num.get(i);
    	}
    	Arrays.sort(numbers);
    	int value = numbers[k-1];
    	
    	for(TreeNode node : list) {
    		if(node.val == value) {
    			return node;
    		}
    	}
    	return null;
    }
    
    public void load(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	if(root != null) {
    		list.add(root);
    		num.add(root.val);
    	}
    	load(root.left);
    	load(root.right);
    }
    
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
		new Solution_62().test();
	}
    public void test() {
		TreeNode n8 = new TreeNode(8);
		TreeNode n6 = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n11 = new TreeNode(11);
		n8.left = n6;
		n8.right = n10;
		n6.left = n5;
		n6.right = n7;
		n10.left = n9;
		n10.right = n11;
		System.out.println(KthNode(n8, 1).val);
	}
}
