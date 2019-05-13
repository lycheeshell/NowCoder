package edu.nju.se.num31_45;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
 * Good Luck!
 * 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 
 * @author zongk
 *
 */
public class Solution_41 {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	int i = 2;
    	while(sum / i - i / 2 >= 0) {
    		
    		double mid = ((double)sum) / i;
    		int midInt = sum / i;
    		BigDecimal midBig = new BigDecimal(mid-midInt);
    		
    		if(midBig.compareTo(new BigDecimal(0)) == 0 && i % 2 == 1) {
    			
    			ArrayList<Integer> list = new ArrayList<Integer>();
    			
    			for(int k=midInt-i/2; k<=midInt+i/2; k++) {
    				if(k <= 0) return result;
    				list.add(k);
    			}
    			int index = result.size();
    			for(int j=0; j<result.size(); j++) {
    				if(result.get(j).get(0) > list.get(0)) {
    					index = j;
    					break;
    				}
    			}

    			result.add(index, list);
    		}
    		
    		if(midBig.compareTo(new BigDecimal(0.5)) == 0 && i % 2 == 0) {
    			
    			ArrayList<Integer> list = new ArrayList<Integer>();
    			
    			for(int k=midInt-i/2+1; k<=midInt+i/2; k++) {
    				if(k <= 0) return result;
    				list.add(k);
    			}
    			int index = result.size();
    			for(int j=0; j<result.size(); j++) {
    				if(result.get(j).get(0) > list.get(0)) {
    					index = j;
    					break;
    				}
    			}

    			result.add(index, list);
    		}
    		
    		i++;
    	}
    	
    	return result;
    }
    
}
