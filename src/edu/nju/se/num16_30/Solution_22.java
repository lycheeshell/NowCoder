package edu.nju.se.num16_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * 从上往下打印二叉树
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * @author zongk
 *
 */
public class Solution_22 {
	
	//<第几层，<第几个，val>
	Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        
		scanTree(root, 1);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Set<Integer> high = map.keySet();
		int max = Integer.MIN_VALUE;
		for(Integer key: high) {
			if(key > max) {
				max = key;
			}
		}
		
		for(int i=1; i<=max; i++) {
			Map<Integer, Integer> valueMap = map.get(i);
			
			Set<Integer> num = valueMap.keySet();
			int maxNum = Integer.MIN_VALUE;
			for(Integer key: num) {
				if(key > maxNum) {
					maxNum = key;
				}
			}
			
			for(int j=1; j<=maxNum; j++) {
				result.add(map.get(i).get(j));
			}
			
		}
		
		return result;
    }
	
	public void scanTree(TreeNode node, int high) {
		
		if(node == null) {
			return;
		}
		
		Map<Integer, Integer> valueMap = map.get(high);
		if(valueMap == null) {
			valueMap = new HashMap<Integer, Integer>();
			map.put(high, valueMap);
		}
		if(valueMap.size() == 0) {
			valueMap.put(1, node.val);
		} else {
			Set<Integer> set = valueMap.keySet();
			int max = Integer.MIN_VALUE;
			for(Integer key: set) {
				if(key > max) {
					max = key;
				}
			}
			valueMap.put(max+1, node.val);
		}
		
		scanTree(node.left, high+1);
		scanTree(node.right, high+1);
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
		new Solution_22().test();
	}
	
	public void test() {
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n8 = new TreeNode(8);
		TreeNode n10 = new TreeNode(10);
		TreeNode n12 = new TreeNode(12);
		TreeNode n14 = new TreeNode(14);
		TreeNode n16 = new TreeNode(16);
		
		n6.left = n4;
		n6.right = n8;
		n10.left = n6;
		n14.left = n12;
		n14.right = n16;
		n10.right = n14;
		
		System.out.println(PrintFromTopToBottom(n10));
		
	}
	
}
