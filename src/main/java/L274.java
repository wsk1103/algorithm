import java.util.Arrays;

/**
 * @author sk
 * @time 2022/9/6
 * @desc say
 **/
public class L274 {

    /*
     * //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     * //
     * // 根据维基百科上 h 指数的定义：h 代表“高引用次数”，一名科研人员的 h指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
     * //且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
     * //
     * // 如果 h 有多种可能的值，h 指数 是其中最大的那个。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：citations = [3,0,6,1,5]
     * //输出：3
     * //解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     * //     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
     * //
     * // 示例 2：
     * //
     * //
     * //输入：citations = [1,3,1]
     * //输出：1
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // n == citations.length
     * // 1 <= n <= 5000
     * // 0 <= citations[i] <= 1000
     * //
     * //
     * // Related Topics 数组 计数排序 排序 👍 278 👎 0
     * @return
     */

    /**
     * 执行耗时:1 ms,击败了78.08% 的Java用户
     * 内存消耗:39.4 MB,击败了61.87% 的Java用户
     *
     * @param citations
     * @return
     */
    public static int handle(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] > max) {
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{3, 0, 6, 1, 5};
        System.err.println(handle(n));
    }

}
