/**
 * @author sk
 * @time 2022/8/31
 * @desc say
 **/
public class L223 {

    /*
     * //给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
     * //
     * // 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
     * //
     * //
     * //
     * // 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
     * // 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
     * //
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
     * //输出：45
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
     * //输出：16
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴
     * //
     * //
     * // Related Topics 几何 数学 👍 203 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了50.15% 的Java用户
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public static int handle(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = (ax2 - ax1) * (ay2 - ay1);
        a = Math.abs(a);
        int b = (bx2 - bx1) * (by2 - by1);
        b = Math.abs(b);
        int dif;
        if (ay1 >= by2 || ay2 <= by1 || ax1 >= bx2 || ax2 <= bx1) {
            dif = 0;
        } else {
            int width;
            if (ax1 <= bx1 && ax2 >= bx2) {
                width = bx2 - bx1;
            } else if (ax1 >= bx1 && ax2 <= bx2) {
                width = ax2 - ax1;
            } else if (bx2 >= ax2) {
                width = ax2 - bx1;
            } else {
                width = bx2 - ax1;
            }
            int height;
            if (ay1 <= by1 && ay2 >= by2) {
                height = by2 - by1;
            } else if (ay1 >= by1 && ay2 <= by2) {
                height = ay2 - ay1;
            } else if (ay2 >= by2) {
                height = by2 - ay1;
            } else {
                height = ay2 - by1;
            }
            dif = width * height;
            dif = Math.abs(dif);
        }
        return a + b - dif;
    }

    public static void main(String[] args) {
        int ax1, ay1, ax2, ay2, bx1, by1, bx2, by2;
        ax1 = -3;
        ay1 = 0;
        ax2 = 3;
        ay2 = 4;
        bx1 = 0;
        by1 = -1;
        bx2 = 9;
        by2 = 2;
        System.err.println(handle(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

}
