//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closeSUm = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int leftIndex = i + 1;
            int rightIndex = len - 1;
            while (leftIndex < rightIndex) {
                int curSum = nums[i] + nums[leftIndex] + nums[rightIndex];
                if (Math.abs(target - curSum) < Math.abs(target - closeSUm)) {
                    closeSUm = curSum;
                }
                if (target == curSum) {
                    break;
                } else if (target > curSum) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return closeSUm;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}