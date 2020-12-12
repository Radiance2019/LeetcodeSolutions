//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package leetcode.editor.cn;
//Java：寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays_4{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays_4().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 1) {
            return (double)getKth(nums1, nums2, mid + 1);
        } else {
            return (getKth(nums1, nums2, mid) + getKth(nums1, nums2, mid + 1)) / 2.0;
        }
    }

    public int getKth(int[] arr1, int[] arr2, int k) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int index1 = 0;
        int index2 = 0;

        while (true) {
            //边界处理
            if (len1 == index1) {
                return arr2[index2 + k - 1];
            }
            if (len2 == index2) {
                return arr1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(arr1[index1], arr2[index2]);
            }
            //正常情况
            int newIndex1 = Math.min(index1 + k / 2, len1) - 1;
            int newIndex2 = Math.min(index2 + k / 2, len2) - 1;
            int pivot1 = arr1[newIndex1];
            int pivot2 = arr2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}