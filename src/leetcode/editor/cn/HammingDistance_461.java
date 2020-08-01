//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算


package leetcode.editor.cn;
//Java：汉明距离
public class P461HammingDistance{
    public static void main(String[] args) {
        Solution solution = new P461HammingDistance().new Solution();
        System.out.println(solution.hammingDistance(1,4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        int para1 = x;
        int para2 = y;
        for (int i = 0; i < 32;i++) {
            if ((para1 & 1) != (para2 & 1)) {
                hammingDistance++;
            }
            para1 >>= 1;
            para2 >>= 1;
        }
        return hammingDistance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}