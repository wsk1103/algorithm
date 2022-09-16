import java.util.*;

/**
 * @author sk
 * @time 2022/9/16
 * @desc say
 **/
public class L850 {

    /*
     * //我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
     * //矩形 i 左下角的坐标，
     * // (xi1, yi1) 是该矩形 左下角 的坐标，
     * // (xi2, yi2) 是该矩形 右上角 的坐标。
     * //
     * // 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。
     * //
     * // 返回 总面积 。因为答案可能太大，返回
     * // 10⁹ + 7 的 模 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //
     * //
     * //输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
     * //输出：6
     * //解释：如图所示，三个矩形覆盖了总面积为6的区域。
     * //从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
     * //从(1,0)到(2,3)，三个矩形都重叠。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：rectangles = [[0,0,1000000000,1000000000]]
     * //输出：49
     * //解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= rectangles.length <= 200
     * // rectanges[i].length = 4
     * //
     * // 0 <= xi1, yi1, xi2, yi2 <= 10⁹
     * // 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。
     * //
     * //
     * // Related Topics 线段树 数组 有序集合 扫描线 👍 145 👎 0
     */

    /**
     * Time Limit Exceeded
     *
     * @param rectangles
     * @return
     */
    public static int handle(int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> {
            int sub = Integer.compare(a[0], b[0]);
            if (sub == 0) {
                sub = Integer.compare(a[1], b[1]);
                if (sub == 0) {
                    sub = Integer.compare(a[2], b[2]);
                    if (sub == 0) {
                        sub = Integer.compare(a[3], b[3]);
                    }
                }
            }
            return sub;
        });
//        Map<Integer, int[]> map = new HashMap<>();
        KV[] kvs = new KV[rectangles[rectangles.length - 1][3]];
        int index = 0;
        for (int[] rectangle : rectangles) {
            if (index != 0) {
                int[] ci0 = rectangles[index - 1];
                if (rectangle[0] == ci0[0] && rectangle[1] == ci0[1] && rectangle[2] == ci0[2] && rectangle[3] == ci0[3]) {
                    index++;
                    continue;
                }
            }
            index++;
            int x1 = Math.min(rectangle[0], rectangle[2]);
            int y1 = Math.min(rectangle[1], rectangle[3]);
            int x2 = Math.max(rectangle[2], rectangle[0]);
            int y2 = Math.max(rectangle[3], rectangle[1]);
            for (int i = x1; i < x2; i++) {
                KV tmp = kvs[i];
                if (tmp == null) {
                    tmp = new KV();
                    tmp.low = y1;
                    tmp.height = y2;
                    kvs[i] = tmp;
                } else {
                    int ty0 = tmp.low;
                    if (y1 < ty0) {
                        tmp.low = y1;
                    }
                    int ty1 = tmp.height;
                    if (y2 > ty1) {
                        tmp.height = y2;
                    }
                }
//                int[] tmp = map.get(i);
//                if (tmp == null) {
//                    tmp = new int[2];
//                    tmp[0] = y1;
//                    tmp[1] = y2;
//                    map.put(i, tmp);
//                } else {
//                    int ty0 = tmp[0];
//                    if (y1 < ty0) {
//                        tmp[0] = y1;
//                    }
//                    int ty1 = tmp[1];
//                    if (y2 > ty1) {
//                        tmp[1] = y2;
//                    }
//                }
            }
        }
        long add = 0;
        for (KV value : kvs) {
            int sub = value.height - value.low;
            add += sub;
        }
//        for (int[] value : map.values()) {
//            int sub = value[1] - value[0];
//            add += sub;
//        }
        long div = (long) (Math.pow(10, 9) + 7);
        return (int) (add % div);
    }

    /**
     * 执行耗时:10 ms,击败了23.03% 的Java用户
     * 内存消耗:40.7 MB,击败了90.13% 的Java用户
     *
     * @param rectangles
     * @return
     */
    public static int handle2(int[][] rectangles) {
        int open = 0, close = 1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rect : rectangles) {
            events[t++] = new int[]{rect[1], open, rect[0], rect[2]};
            events[t++] = new int[]{rect[3], close, rect[0], rect[2]};
        }
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        List<int[]> active = new ArrayList<>();
        int curY = events[0][0];
        long res = 0;
        for (int[] event : events) {
            int y = event[0], type = event[1], x1 = event[2], x2 = event[3];
            long query = 0;
            int cur = -1;
            // 合并区间
            for (int[] act : active) {
                cur = Math.max(cur, act[0]);
                query += Math.max(act[1] - cur, 0);
                cur = Math.max(cur, act[1]);
            }
            res += query * (y - curY);
            if (type == open) {
                active.add(new int[]{x1, x2});
                active.sort(Comparator.comparingInt(a -> a[0]));
            } else {
                for (int i = 0; i < active.size(); i++) {
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
                }
            }
            curY = y;
        }
        res %= 1_000_000_007;
        return (int) res;
    }

    public static class KV {
        int low;
        int height;
    }

    public static void main(String[] args) {
        int[][] re;
//        re = new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}};
//        System.err.println(handle(re));
        re = new int[][]{{0, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}, {1, 0, 100000000, 100000000}};
        System.err.println(handle(re));
    }

}
