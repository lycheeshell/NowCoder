package edu.nju.se.num31_45;

/**
 * 数组中的逆序对
 * 
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 
 * 题目保证输入的数组中没有的相同的数字
 * 
 * 数据范围：
 * 
 * 对于%50的数据,size<=10^4
 * 
 * 对于%75的数据,size<=10^5
 * 
 * 对于%100的数据,size<=2*10^5
 * 
 * 
 * 示例
 * 
 * 输入 1,2,3,4,5,6,7,0 输出 7
 * 
 * 
 * @author zongk
 *
 */
public class Solution_35 {

	/*
	*归并排序的思想，最后求得的逆序数进行取摸 % 1000000007
	*/
	public int InversePairs(int[] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}
		int pairsNum = mergeSort(array, 0, array.length - 1);
		return pairsNum;
	}

	public int mergeSort(int[] array, int left, int right) {
		if (left == right) {
			return 0;
		}
		int mid = (left + right) / 2;
		int leftNum = mergeSort(array, left, mid);
		int rightNum = mergeSort(array, mid + 1, right);
		return (Sort(array, left, mid, right) + leftNum + rightNum) % 1000000007;
	}

	public int Sort(int[] array, int left, int middle, int right) {
		int current1 = middle;
		int current2 = right;
		int current3 = right - left;
		int temp[] = new int[right - left + 1];
		int pairsnum = 0;
		while (current1 >= left && current2 >= middle + 1) {
			if (array[current1] > array[current2]) {
				temp[current3--] = array[current1--];
				pairsnum += (current2 - middle); // 这个地方是current2-middle！！！！
				if (pairsnum > 1000000007)// 数值过大求余
				{
					pairsnum %= 1000000007;
				}
			} else {
				temp[current3--] = array[current2--];
			}
		}
		while (current1 >= left) {
			temp[current3--] = array[current1--];
		}
		while (current2 >= middle + 1) {
			temp[current3--] = array[current2--];
		}
		// 将临时数组赋值给原数组
		int i = 0;
		while (left <= right) {
			array[left++] = temp[i++];
		}
		return pairsnum;
	}

}


/**
 * 这道题目，是归并排序的典型应用。
 * 归并排序的基本思想是分治，在治的过程中有前后数字的大小对比，此时就是统计逆序对的最佳时机。
 */
//public class Solution {
//    //统计逆序对的个数
//    int cnt;
//    public int InversePairs(int [] array) {
//        if(array.length != 0){
//            divide(array,0,array.length-1);
//        }
//        return cnt;
//    }
// 
//    //归并排序的分治---分
//    private void divide(int[] arr,int start,int end){
//        //递归的终止条件
//        if(start >= end)
//            return;
//        //计算中间值，注意溢出
//        int mid = start + (end - start)/2;
// 
//        //递归分
//        divide(arr,start,mid);
//        divide(arr,mid+1,end);
// 
//        //治
//        merge(arr,start,mid,end);
//    }
// 
//    private void merge(int[] arr,int start,int mid,int end){
//        int[] temp = new int[end-start+1];
// 
//        //存一下变量
//        int i=start,j=mid+1,k=0;
//        //下面就开始两两进行比较，若前面的数大于后面的数，就构成逆序对
//        while(i<=mid && j<=end){
//            //若前面小于后面，直接存进去，并且移动前面数所在的数组的指针即可
//            if(arr[i] <= arr[j]){
//                temp[k++] = arr[i++];
//            }else{
//                temp[k++] = arr[j++];
//                //a[i]>a[j]了，那么这一次，从a[i]开始到a[mid]必定都是大于这个a[j]的，因为此时分治的两边已经是各自有序了
//                cnt = (cnt+mid-i+1)%1000000007;
//            }
//        }
//        //各自还有剩余的没比完，直接赋值即可
//        while(i<=mid)
//            temp[k++] = arr[i++];
//        while(j<=end)
//            temp[k++] = arr[j++];
//        //覆盖原数组
//        for (k = 0; k < temp.length; k++)
//            arr[start + k] = temp[k];
//    }
//}
