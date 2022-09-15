import java.util.HashSet;
import java.util.Set;

/**
 * @author sk
 * @time 2022/9/15
 * @desc say
 **/
public class L672 {

    /*
     * //房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
     * //
     * // 这 4 个开关各自都具有不同的功能，其中：
     * //
     * //
     * // 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
     * // 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
     * // 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
     * // 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
     * //
     * //
     * // 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
     * //
     * // 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 1, presses = 1
     * //输出：2
     * //解释：状态可以是：
     * //- 按压开关 1 ，[关]
     * //- 按压开关 2 ，[开]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 2, presses = 1
     * //输出：3
     * //解释：状态可以是：
     * //- 按压开关 1 ，[关, 关]
     * //- 按压开关 2 ，[开, 关]
     * //- 按压开关 3 ，[关, 开]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：n = 3, presses = 1
     * //输出：4
     * //解释：状态可以是：
     * //- 按压开关 1 ，[关, 关, 关]
     * //- 按压开关 2 ，[关, 开, 关]
     * //- 按压开关 3 ，[开, 关, 开]
     * //- 按压开关 4 ，[关, 开, 开]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 1000
     * // 0 <= presses <= 1000
     * //
     * //
     * // Related Topics 位运算 深度优先搜索 广度优先搜索 数学 👍 132 👎 0
     */

    static int ans = 0;

    /**
     * Time Limit Exceeded
     *
     * @param n
     * @param presses
     * @return
     */
    public static int handle(int n, int presses) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }
        loop(0, presses, set, sb);
        return ans;
    }

    /**
     * 如果把所有灯的状态全部考虑变化，搜索空间就太大了，需要找到灯的变化规律。很容易就能发现，
     * 这些灯的状态是 6 个一循环，也就是说前 6 个灯的状态唯一地决定了其余的灯。
     * <p>
     * 还有操作本身的顺序并不影响灯的最终状态，进行 A 操作后接 B 操作，和 B 操作后接 A 操作是一样的。
     * 而连续两次执行相同的操作与不执行任何操作相同，所以我们只需要考虑每个操作是 0 次还是 1 次。
     * <p>
     * 其实我们还可以更进一步缩小范围，只需要前 3 个灯就可以确定所有灯的状态，因为前 6 盏灯的操作次数可以用下面的公式来表示。
     * <p>
     * Light 1 = 1 + a + c + d
     * Light 2 = 1 + a + b
     * Light 3 = 1 + a + c
     * Light 4 = 1 + a + b + d
     * Light 5 = 1 + a + c
     * Light 6 = 1 + a + b
     * 如果 light 1-3 确定了，light 4-6 也就确定了，其中 light 5 和 light 6 显然，而 light4 = light 1 + light 2 - light 3，
     * 也就是说最多就 8 种状态，于是我们枚举一下就行了。
     * <p>
     * 当 m=0 时，所有灯都亮起，只有一个状态 (1,1,1)。在这种情况下，答案总是 1。
     * 当 m=1 时，分别执行 a,b,c,d 我们可以得到 4 个状态 (0,0,0), (1,0,1), (0,1,0), (0,1,1)。在这种情况下，对于 n=1,2,3 的答案是 2,3,4。
     * 当 m=2 时，我们可以获得除 (0,1,1) 之外的 7 个状态。在这种情况下，n=1,2,3 的答案是 2,4,7。
     * 当 m=3 时，我们可以得到所有 8 个状态。在这种情况下，n=1,2,3 的答案是 2,4,8
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了93.43% 的Java用户
     *
     * @param n
     * @param presses
     * @return
     */
    public static int handle2(int n, int presses) {
        n = Math.min(n, 3);
        if (presses == 0) return 1;
        if (presses == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (presses == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }

    public static void loop(int now, int presses, Set<String> set, StringBuilder sb) {
        if (now >= presses) {
            return;
        }
        // 1
        StringBuilder tmp = new StringBuilder(sb);
        for (int i = 0; i < tmp.length(); i++) {
            String cc = tmp.charAt(i) == '0' ? "1" : "0";
            tmp.replace(i, i + 1, cc);
        }
        if (!set.contains(tmp.toString())) {
            ans += 1;
            set.add(tmp.toString());
        }
        loop(now + 1, presses, set, tmp);

        //2
        tmp = new StringBuilder(sb);
        for (int i = 0; i < tmp.length(); i += 2) {
            String cc = tmp.charAt(i) == '0' ? "1" : "0";
            tmp.replace(i, i + 1, cc);
        }
        if (!set.contains(tmp.toString())) {
            ans += 1;
            set.add(tmp.toString());
        }
        loop(now + 1, presses, set, tmp);

        //3
        tmp = new StringBuilder(sb);
        for (int i = 1; i < tmp.length(); i += 2) {
            String cc = tmp.charAt(i) == '0' ? "1" : "0";
            tmp.replace(i, i + 1, cc);
        }
        if (!set.contains(tmp.toString())) {
            ans += 1;
            set.add(tmp.toString());
        }
        loop(now + 1, presses, set, tmp);

        //4
        tmp = new StringBuilder(sb);
        for (int i = 0; i < tmp.length(); i += 3) {
            String cc = tmp.charAt(i) == '0' ? "1" : "0";
            tmp.replace(i, i + 1, cc);
        }
        if (!set.contains(tmp.toString())) {
            ans += 1;
            set.add(tmp.toString());
        }
        loop(now + 1, presses, set, tmp);
    }

    public static void main(String[] args) {
        int n, p;
        n = 3;
        p = 1;
        System.err.println(handle(n, p));
        n = 10;
        p = 10;
        System.err.println(handle(n, p));
    }

}
