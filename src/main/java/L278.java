/**
 * @author sk
 * @time 2022/9/7
 * @desc say
 **/
public class L278 {


    /*
     * //你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
     * //版本都是错的。
     * //
     * // 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * //
     * // 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
     * //的版本。你应该尽量减少对调用 API 的次数。
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 5, bad = 4
     * //输出：4
     * //解释：
     * //调用 isBadVersion(3) -> false
     * //调用 isBadVersion(5) -> true
     * //调用 isBadVersion(4) -> true
     * //所以，4 是第一个错误的版本。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 1, bad = 1
     * //输出：1
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= bad <= n <= 2³¹ - 1
     * //
     * //
     * // Related Topics 二分查找 交互 👍 786 👎 0
     *
     *
     * //leetcode submit region begin(Prohibit modification and deletion)
     * /* The isBadVersion API is defined in the parent class VersionControl.
     *       boolean isBadVersion(int version);
     */

    static int bad = 9;

    /**
     * 执行耗时:24 ms,击败了8.30% 的Java用户
     * 内存消耗:38.1 MB,击败了77.45% 的Java用户
     */
    public static class Solution extends VersionControl {
        public static int firstBadVersion(int n) {
            if (n == 1) {
                return 1;
            }
            int start = 1;
            int end = n;
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                boolean b = isBadVersion(mid);
                int other;
                if (mid + 1 > n) {
                    other = mid - 1;
                } else {
                    other = mid + 1;
                }
                boolean ob = isBadVersion(other);
                if (b && !ob) {
                    return mid;
                } else if (!b && ob) {
                    return other;
                } else if (b && ob) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return 1;
        }

        /**
         * 执行耗时:14 ms,击败了31.51% 的Java用户
         * 内存消耗:38.4 MB,击败了33.12% 的Java用户
         *
         * @param n
         * @return
         */
        public static int firstBadVersion2(int n) {
            int start = 1;
            int end = n;
            while (start < end) {
                int mid = (end - start) / 2 + start;
                if (isBadVersion(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }

    public static void main(String[] args) {
        int n;
        n = 2126753390;
        bad = 1702766719;
        System.err.println(Solution.firstBadVersion(n));
        n = 20;
        System.err.println(Solution.firstBadVersion(n));
        n = 22;
        bad = 20;
        System.err.println(Solution.firstBadVersion(n));
    }

    public static class VersionControl {
        static boolean isBadVersion(int version) {
            return version >= bad;
        }
    }

}
