package edu.nju.se.num16_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树中和为某一值的路径
 * 
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * @author zongk
 *
 */
public class Solution_24 {
	
	ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null) { 
			
		} else {
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			list1.add(root.val);
			list2.add(root.val);
			scanTree(list1, root.left);
			scanTree(list2, root.right);
			if(root.left == null && root.right == null) {
				allList.add(list1);
			}
		}
		
		Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		
		for(ArrayList<Integer> list : allList) {
			int total = 0;
			for(Integer num : list) {
				total = total + num;
			}
			if(total == target) {
				ArrayList<ArrayList<Integer>> temp = map.get(list.size());
				if(temp == null) {
					temp = new ArrayList<ArrayList<Integer>>();
					temp.add(list);
					map.put(list.size(), temp);
				}
			}
		}
		
		Object[] sort =  map.keySet().toArray();
		Arrays.sort(sort);
		
		for(int i=sort.length-1; i>=0; i--) {
			ArrayList<ArrayList<Integer>> temp = map.get(sort[i]);
			for(ArrayList<Integer> last : temp) {
				result.add(last);
			}
		}
		
		return result;
        
    }
	
	public void scanTree(ArrayList<Integer> list, TreeNode root) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			list.add(root.val);
			allList.add(list);
		}
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			list1.add(list.get(i));
			list2.add(list.get(i));
		}
		list1.add(root.val);
		list2.add(root.val);
		
		scanTree(list1, root.left);
		scanTree(list2, root.right);
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
		new Solution_24().test();
	}
	
	public void test() {
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n10 = new TreeNode(10);
		TreeNode n12 = new TreeNode(12);
		
		n5.left = n4;
		n5.right = n7;
		n10.left = n5;
		n10.right = n12;
		
		System.out.println(FindPath(n10, 22));
		
	}
}
