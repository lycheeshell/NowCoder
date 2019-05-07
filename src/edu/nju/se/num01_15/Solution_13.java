package edu.nju.se.num01_15;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 
 * 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author zongk
 *
 */
public class Solution_13 {

	public void reOrderArray(int [] array) {
		
		Queue<Integer> odd = new ConcurrentLinkedQueue<Integer>();
		Queue<Integer> even = new ConcurrentLinkedQueue<Integer>();
		
		for(int i=0; i<array.length; i++) {
			if(array[i] % 2 == 1) {
				odd.offer(array[i]);
			} else {
				even.offer(array[i]);
			}
		}
		
		int index = 0;
		while(!odd.isEmpty()) {
			array[index++] = odd.poll();
		}
		while(!even.isEmpty()) {
			array[index++] = even.poll();
		}
    }

}
