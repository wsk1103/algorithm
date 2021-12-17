import com.alibaba.fastjson.JSON;

/**
 * @author sk
 * @time 2021/12/17
 * @desc say
 **/
public class L338 {

    /*
     * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
     *
     *
     *
     * 示例 1:
     *
     * 输入: n = 2
     * 输出: [0,1,1]
     * 解释:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 示例 2:
     *
     * 输入: n = 5
     * 输出: [0,1,1,2,1,2]
     * 解释:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     *
     *
     * 说明 :
     *
     * 0 <= n <= 105
     *
     *
     * 进阶:
     *
     * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
     * 要求算法的空间复杂度为 O(n) 。
     * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
     */

    /**
     * 对于整数i，可能是偶数或者奇数；在二进制中，偶数的最右一位总为0，奇数则总为1。
     *
     * 偶数。i/2相当于整数i右移一位，又因为偶数的最右一位总为0，则整数i的二进制表示中1的个数和i/2相同
     * 奇数。奇数右移一位总会少一个1的个数，则此时整数i的二进制表示中1的个数等于i/2二进制表示中1的个数加1
     * 在这题中，可以先建立一个result数组存0-n中每个数的二进制表示1的个数，初始化为全0，result[i]表示整数i二进制表示中1的个数
     * 现在要知道i的二进制表示中1的个数，就得知道i/2二进制表示中1的个数。现在可以模拟一下过程：
     * 已知result[0]=0，由0可以推出0和1的二进制表示中1的个数，由
     * 1 -->2和3
     * 2 -->4和5
     * 3 -->6和7
     * …以此类推，最后可以得到0-n之间的每个数字的二进制表示中 1 的个数
     * @param n
     * @return
     */
    public static int[] handle(int n) {
        int[] to = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            to[i] = to[i >> 1] + (i & 1);
        }
        return to;
    }

    public static void main(String[] args) {
        System.err.println(JSON.toJSONString(handle(6)));
    }
}
