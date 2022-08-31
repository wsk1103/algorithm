import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/8/31
 * @desc say
 **/
public class L946 {

    /*
     * //给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
     * //，返回 true；否则，返回 false 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * //输出：true
     * //解释：我们可以按以下顺序执行：
     * //push(1), push(2), push(3), push(4), pop() -> 4,
     * //push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * //输出：false
     * //解释：1 不能在 2 之前弹出。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= pushed.length <= 1000
     * // 0 <= pushed[i] <= 1000
     * // pushed 的所有元素 互不相同
     * // popped.length == pushed.length
     * // popped 是 pushed 的一个排列
     * //
     * //
     * // Related Topics 栈 数组 模拟 👍 284 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了95.71% 的Java用户
     * 内存消耗:40.8 MB,击败了95.89% 的Java用户
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean handle(int[] pushed, int[] popped) {
        LinkedList<Integer> list = new LinkedList<>();
        int p = 0;
        for (int now : pushed) {
            list.push(now);
            while (now == popped[p]) {
                list.poll();
                p++;
                if (list.isEmpty()) {
                    break;
                }
                now = list.peek();
            }
        }
        while (!list.isEmpty()) {
            int now = list.poll();
            if (now != popped[p++]) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] p1, p2;
        p1 = new int[]{2, 1, 0};
        p2 = new int[]{1, 2, 0};
//        System.err.println(handle(p1, p2));
        p1 = new int[]{1, 2, 3, 4, 5};
        p2 = new int[]{4, 5, 3, 2, 1};
        System.err.println(handle(p1, p2));
        p1 = new int[]{1, 2, 3, 4, 5};
        p2 = new int[]{4, 5, 3, 1, 2};
        System.err.println(handle(p1, p2));
    }

}
